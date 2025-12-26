package com.example.autoinjector;

import org.junit.jupiter.api.Test;
import com.example.autoinjector.bean.SomeBean;
import com.example.autoinjector.injector.Injector;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Тестирование механизма внедрения зависимостей.
 */
class InjectorTest {

    @Test
    void dependenciesShouldBeInjected() {
        Injector injector = new Injector();
        SomeBean bean = injector.inject(new SomeBean());

        assertDoesNotThrow(bean::foo);
    }
}
