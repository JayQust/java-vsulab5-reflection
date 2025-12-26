package com.example.autoinjector.exception;

/**
 * Исключение, выбрасываемое при ошибке внедрения зависимостей.
 *
 * <p>Используется, если невозможно создать объект реализации,
 * получить доступ к полю или выполнить присваивание.</p>
 */
public class InjectionException extends RuntimeException {

    /**
     * Создаёт исключение с сообщением об ошибке.
     *
     * @param message описание ошибки
     */
    public InjectionException(String message) {
        super(message);
    }

    /**
     * Создаёт исключение с сообщением и причиной.
     *
     * @param message описание ошибки
     * @param cause   исходное исключение
     */
    public InjectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
