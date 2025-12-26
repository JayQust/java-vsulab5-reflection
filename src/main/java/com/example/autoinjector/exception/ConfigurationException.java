package com.example.autoinjector.exception;

/**
 * Исключение, сигнализирующее об ошибке конфигурации.
 *
 * <p>Выбрасывается, если файл application.properties
 * отсутствует или в нём не указана реализация интерфейса.</p>
 */
public class ConfigurationException extends RuntimeException {

    /**
     * Создаёт исключение с сообщением об ошибке.
     *
     * @param message описание ошибки конфигурации
     */
    public ConfigurationException(String message) {
        super(message);
    }
}
