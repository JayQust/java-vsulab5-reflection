package com.example.autoinjector.impl;

import com.example.autoinjector.api.SomeInterface;

/**
 * Альтернативная реализация {@link SomeInterface}.
 * Выводит символ "B".
 */
public class OtherImpl implements SomeInterface {

    @Override
    public void doSomething() {
        System.out.print("B");
    }
}
