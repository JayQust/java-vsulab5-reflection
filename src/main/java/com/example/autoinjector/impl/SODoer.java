package com.example.autoinjector.impl;

import com.example.autoinjector.api.SomeOtherInterface;

/**
 * Реализация интерфейса {@link SomeOtherInterface}.
 * Выводит символ "C".
 */
public class SODoer implements SomeOtherInterface {

    @Override
    public void doSomething() {
        System.out.print("C");
    }
}
