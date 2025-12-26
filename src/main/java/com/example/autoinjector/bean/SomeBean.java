package com.example.autoinjector.bean;

import com.example.autoinjector.annotation.AutoInjectable;
import com.example.autoinjector.api.SomeInterface;
import com.example.autoinjector.api.SomeOtherInterface;

/**
 * Класс, содержащий зависимости,
 * которые НЕ инициализируются вручную.
 *
 * <p>Все зависимости внедряются автоматически
 * с помощью {@link com.example.autoinjector.injector.Injector}.</p>
 */
public class SomeBean {

    /**
     * Зависимость типа SomeInterface.
     */
    @AutoInjectable
    private SomeInterface field1;

    /**
     * Зависимость типа SomeOtherInterface.
     */
    @AutoInjectable
    private SomeOtherInterface field2;

    /**
     * Демонстрирует корректную работу
     * внедрённых зависимостей.
     */
    public void foo() {
        field1.doSomething();
        field2.doSomething();
    }
}
