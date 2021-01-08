package com.javarush.task.task32.task3205;

import java.lang.reflect.Proxy;

/* 
Создание прокси-объекта
*/

public class Solution {
    public static void main(String[] args) {
        SomeInterfaceWithMethods obj = getProxy();
        obj.stringMethodWithoutArgs();
        obj.voidMethodWithIntArg(1);

        /* expected output
        stringMethodWithoutArgs in
        inside stringMethodWithoutArgs
        stringMethodWithoutArgs out
        voidMethodWithIntArg in
        inside voidMethodWithIntArg
        inside voidMethodWithoutArgs
        voidMethodWithIntArg out
        */
    }

    public static SomeInterfaceWithMethods getProxy() {
        //Создаем оригинальный объект
        SomeInterfaceWithMethods origObj = new SomeInterfaceWithMethodsImpl();

        //Получаем загрузчик класса у оригинального объекта
        ClassLoader origObjClassLoader = origObj.getClass().getClassLoader();

        //Получаем все интерфейсы, которые реализует оригинальный объект
        Class[] interfaces = origObj.getClass().getInterfaces();

        //Создаем прокси нашего объекта vasia
        SomeInterfaceWithMethods proxy = (SomeInterfaceWithMethods) Proxy.newProxyInstance(origObjClassLoader, interfaces, new CustomInvocationHandler(origObj));

        return proxy;
    }

/*    public static SomeInterfaceWithMethods getProxy() {
        SomeInterfaceWithMethods original = new SomeInterfaceWithMethodsImpl();

        ClassLoader classLoader = SomeInterfaceWithMethods.class.getClassLoader();
        Class[] interfaces = {SomeInterfaceWithMethods.class};
        CustomInvocationHandler handler = new CustomInvocationHandler(original);

        return (SomeInterfaceWithMethods) Proxy.newProxyInstance(classLoader, interfaces, handler);
    }  */
}
