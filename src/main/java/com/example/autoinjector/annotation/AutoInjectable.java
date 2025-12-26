package com.example.autoinjector.annotation;

import java.lang.annotation.*;

/**
 * Аннотация-маркер, указывающая, что поле
 * должно быть автоматически инициализировано
 * контейнером внедрения зависимостей.
 *
 * <p>Используется классом {@link com.example.autoinjector.injector.Injector}
 * для поиска полей, в которые необходимо внедрить реализацию интерфейса.</p>
 *
 * <p>Аннотация применяется ТОЛЬКО к полям.</p>
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoInjectable {
}
