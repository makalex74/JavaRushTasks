package com.javarush.task.task21.task2102;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* 
Сравниваем модификаторы
*/
public class Solution {
    public static void main(String[] args) {
        int classModifiers = Solution.class.getModifiers();
        //System.out.println(Modifier.STATIC);
        System.out.println(isModifierSet(classModifiers, Modifier.PUBLIC));   //true
        System.out.println(isModifierSet(classModifiers, Modifier.STATIC));   //false

        int methodModifiers = getMainMethod().getModifiers();
        System.out.println(isModifierSet(methodModifiers, Modifier.STATIC));      //true
    }

    public static boolean isModifierSet(int allModifiers, int specificModifier) {
/*        if (specificModifier == Modifier.ABSTRACT) return Modifier.isAbstract(allModifiers);
        if (specificModifier == Modifier.FINAL) return Modifier.isFinal(allModifiers);
        if (specificModifier == Modifier.INTERFACE) return Modifier.isInterface(allModifiers);
        if (specificModifier == Modifier.NATIVE) return Modifier.isNative(allModifiers);
        if (specificModifier == Modifier.PRIVATE) return Modifier.isPrivate(allModifiers);
        if (specificModifier == Modifier.PROTECTED) return Modifier.isProtected(allModifiers);
        if (specificModifier == Modifier.PUBLIC) return Modifier.isPublic(allModifiers);
        if (specificModifier == Modifier.STATIC) return Modifier.isStatic(allModifiers);
        if (specificModifier == Modifier.STRICT) return Modifier.isStrict(allModifiers);
        if (specificModifier == Modifier.SYNCHRONIZED) return Modifier.isSynchronized(allModifiers);
        if (specificModifier == Modifier.TRANSIENT) return Modifier.isTransient(allModifiers);
        if (specificModifier == Modifier.VOLATILE) return Modifier.isVolatile(allModifiers);
        return false;*/
        return allModifiers >= specificModifier;
    }

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }

        return null;
    }
}
