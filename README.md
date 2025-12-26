# Auto Injector (Dependency Injection)

Учебный проект на Java, реализующий простой механизм внедрения зависимостей
с использованием аннотаций, рефлексии и файла конфигурации `properties`.

## Описание

Проект демонстрирует, как автоматически инициализировать поля объекта,
помеченные аннотацией `@AutoInjectable`, на основе соответствий
«интерфейс → реализация», заданных во внешнем конфигурационном файле.

Инициализация зависимостей выполняется классом `Injector`
без использования сторонних DI-фреймворков (Spring и т.п.).

## Используемые технологии

- Java
- Maven
- Reflection API
- Annotations
- Properties
- JUnit (для тестирования)

## Принцип работы

1. Поля класса помечаются аннотацией `@AutoInjectable`
2. Тип поля должен быть интерфейсом
3. В файле `application.properties` указывается,
   какой класс является реализацией интерфейса
4. Класс `Injector`:
   - анализирует поля объекта с помощью рефлексии
   - находит поля с аннотацией `@AutoInjectable`
   - создаёт экземпляры нужных классов
   - записывает их в соответствующие поля

## Пример использования

```java
SomeBean bean = new Injector().inject(new SomeBean());
bean.foo();
```

## Конфигурация (application.properties)
com.example.autoinjector.api.SomeInterface=com.example.autoinjector.impl.SomeImpl
com.example.autoinjector.api.SomeOtherInterface=com.example.autoinjector.impl.SODoer

При изменении реализации в файле properties поведение программы меняется без изменения исходного кода.