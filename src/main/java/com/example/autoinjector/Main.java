package com.example.autoinjector;

import com.example.autoinjector.bean.SomeBean;
import com.example.autoinjector.injector.Injector;

/**
 * Точка входа в приложение.
 */
public class Main {

    public static void main(String[] args) {
        SomeBean bean = new Injector().inject(new SomeBean());
        bean.foo(); // AC или BC
    }
}
