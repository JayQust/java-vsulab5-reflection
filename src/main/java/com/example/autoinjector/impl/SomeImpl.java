package com.example.autoinjector.impl;

import com.example.autoinjector.api.SomeInterface;

/**
 * Реализация интерфейса {@link SomeInterface}.
 * Выводит символ "A".
 */
public class SomeImpl implements SomeInterface {

    @Override
    public void doSomething() {
        System.out.print("A");
    }
}
