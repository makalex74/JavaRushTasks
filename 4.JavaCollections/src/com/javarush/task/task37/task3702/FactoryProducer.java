package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.female.FemaleFactory;
import com.javarush.task.task37.task3702.male.MaleFactory;

public class FactoryProducer {

    public static enum HumanFactoryType{
        MALE,
        FEMALE
    }

    public static AbstractFactory getFactory (HumanFactoryType humanFactoryType){
        if (humanFactoryType == HumanFactoryType.MALE){
            return new MaleFactory();
        } else if (humanFactoryType == HumanFactoryType.FEMALE){
            return new FemaleFactory();
        } else return null;
    }

}

/*
3. В корне задачи создай класс FactoryProducer, в котором создай публичный статический энум HumanFactoryType со значениями MALE, FEMALE.

4. В FactoryProducer создай публичный статический метод getFactory с аргументом HumanFactoryType.
Этот метод должен возвращать одну из фабрик: для ключа MALE - MaleFactory, для FEMALE - FemaleFactory.
 */