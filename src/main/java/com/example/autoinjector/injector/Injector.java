package com.example.autoinjector.injector;

import com.example.autoinjector.annotation.AutoInjectable;
import com.example.autoinjector.config.PropertiesLoader;
import com.example.autoinjector.exception.ConfigurationException;
import com.example.autoinjector.exception.InjectionException;

import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Класс, реализующий механизм внедрения зависимостей.
 *
 * <p>Использует:</p>
 * <ul>
 *     <li>аннотации</li>
 *     <li>рефлексию</li>
 *     <li>конфигурацию через Properties</li>
 * </ul>
 */
public class Injector {

    /**
     * Конфигурация соответствия интерфейсов и реализаций.
     */
    private final Properties properties;

    /**
     * Создаёт Injector и загружает конфигурацию.
     */
    public Injector() {
        this.properties = new PropertiesLoader().load();
    }

    /**
     * Выполняет внедрение зависимостей в объект.
     *
     * @param object объект, в который необходимо внедрить зависимости
     * @param <T>    тип объекта
     * @return объект с инициализированными полями
     */
    public <T> T inject(T object) {
        Class<?> clazz = object.getClass();

        for (Field field : clazz.getDeclaredFields()) {

            if (!field.isAnnotationPresent(AutoInjectable.class)) {
                continue;
            }

            Class<?> interfaceType = field.getType();
            String implementationName =
                    properties.getProperty(interfaceType.getName());

            if (implementationName == null) {
                throw new ConfigurationException(
                        "Реализация не найдена для " + interfaceType.getName());
            }

            try {
                Class<?> implClass = Class.forName(implementationName);

                if (!interfaceType.isAssignableFrom(implClass)) {
                    throw new InjectionException(
                            "Класс не реализует интерфейс");
                }

                Object instance =
                        implClass.getDeclaredConstructor().newInstance();

                field.setAccessible(true);
                field.set(object, instance);

            } catch (Exception e) {
                throw new InjectionException(
                        "Ошибка внедрения зависимости", e);
            }
        }
        return object;
    }
}
