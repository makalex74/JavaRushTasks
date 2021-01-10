package com.javarush.task.task33.task3305;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = As.PROPERTY, property = "className")
public abstract class Vehicle {
    protected String name;
    protected String owner;
    protected int age;
}

/*
Конвертация из одного класса в другой используя JSON Ӏ 3305
НЕОБХОДИМО: подключенные библиотеки Jackson Core, Bind и Annotation версии 2.8.1

Расставь JSON аннотации так, чтобы результат выполнения метода main был следующим:
{
  "className" : ".ParkingLot",
  "name" : "Super ParkingLot",
  "city" : "Kyiv",
  "vehicles" : [ {
    "className" : "com.javarush.task.task33.task3305.RacingBike",
    "name" : "Simba",
    "owner" : "Peter",
    "age" : 2
  }, {
    "className" : "com.javarush.task.task33.task3305.Motorbike",
    "name" : "Manny",
    "owner" : null
  }, {
    "className" : "com.javarush.task.task33.task3305.Car"
  } ]
}

Подсказка: это всего два класса.


 */