package com.javarush.task.task33.task3305;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, include = As.PROPERTY, property = "className")
public class ParkingLot {
    public String name;
    public String city;
    public List<Vehicle> vehicles;

    public ParkingLot(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }
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