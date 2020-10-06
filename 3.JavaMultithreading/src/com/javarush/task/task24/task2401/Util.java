package com.javarush.task.task24.task2401;

import java.lang.reflect.Method;

public class Util {
    // Пример того, как можно использовать интерфейс-маркер
    // Этот метод подходит только для классов, реализующих SelfInterfaceMarker
    public static void testClass(SelfInterfaceMarker interfaceMarker) throws UnsupportedInterfaceMarkerException {
        if (interfaceMarker == null) throw new UnsupportedInterfaceMarkerException();
        for (Method method : interfaceMarker.getClass().getDeclaredMethods()) {
            System.out.println(method);
        }
    }
}

/*
Создание своего интерфейса-маркера
1. Создай интерфейс-маркер SelfInterfaceMarker.
2. Создай класс SelfInterfaceMarkerImpl, который реализует SelfInterfaceMarker.
3. Добавь в SelfInterfaceMarkerImpl минимум 2 любых public метода.
4. Создай исключение UnsupportedInterfaceMarkerException, унаследуй его от класса Exception.
5. В методе testClass класса Util: если параметр == null, то выбросьте UnsupportedInterfaceMarkerException.


Требования:
1. Интерфейс-маркер SelfInterfaceMarker должен быть создан в отдельном файле.
2. Класс SelfInterfaceMarkerImpl должен быть создан в отдельном файле и реализовывать интерфейс SelfInterfaceMarker.
3. В классе SelfInterfaceMarkerImpl должны существовать минимум два public метода.
4. Исключение UnsupportedInterfaceMarkerException должно быть создано в отдельном файле.
5. Метод testClass класса Util должен бросать исключение UnsupportedInterfaceMarkerException в случае, если полученный параметр равен null.
6. В интерфейсе SelfInterfaceMarker не должны быть объявлены методы или декларированы константы.
 */