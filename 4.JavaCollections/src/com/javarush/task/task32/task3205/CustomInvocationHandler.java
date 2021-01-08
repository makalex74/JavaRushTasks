package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
    private SomeInterfaceWithMethods some;
    public CustomInvocationHandler(SomeInterfaceWithMethods some) {
        this.some = some;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() +" in");
        Object res = method.invoke(some, args);
        System.out.println(method.getName() +" out");
        return res;
    }
}

