package com.example.autoinjector.config;

import com.example.autoinjector.exception.ConfigurationException;

import java.io.InputStream;
import java.util.Properties;

/**
 * Класс, отвечающий за загрузку конфигурационного файла
 * application.properties.
 *
 * <p>Файл используется для сопоставления интерфейсов
 * с их конкретными реализациями.</p>
 */
public class PropertiesLoader {

    /**
     * Имя конфигурационного файла.
     */
    private static final String CONFIG_FILE = "application.properties";

    /**
     * Загружает файл application.properties из classpath.
     *
     * @return объект {@link Properties} с настройками
     * @throws ConfigurationException если файл не найден или повреждён
     */
    public Properties load() {
        Properties properties = new Properties();

        try (InputStream is = getClass()
                .getClassLoader()
                .getResourceAsStream(CONFIG_FILE)) {

            if (is == null) {
                throw new ConfigurationException(
                        "Файл application.properties не найден");
            }

            properties.load(is);
            return properties;

        } catch (Exception e) {
            throw new ConfigurationException(
                    "Ошибка загрузки конфигурации");
        }
    }
}
