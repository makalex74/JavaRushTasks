package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public static Car create(int type, int numberOfPassengers){
        Car car = null;

        switch (type) {
            case TRUCK:
                car = new Truck(numberOfPassengers);
                break;
            case SEDAN:
                car = new Sedan(numberOfPassengers);
                break;
            case CABRIOLET:
                car = new Cabriolet(numberOfPassengers);
                break;
        }

        return car;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0) throw new Exception();
        fuel += numberOfLiters;
    }

    public boolean isSummer(Date date, Date summerStart, Date summerEnd){
        if (date.after(summerStart) && date.before(summerEnd)) {
            return true;
        }
        else {
            return false;
        }
    }

    public double getWinterConsumption(int length){
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length){
        return length * summerFuelConsumption;
    }

    public double getTripConsumption(Date date, int length, Date summerStart, Date summerEnd) {
        return isSummer(date, summerStart, summerEnd) ? getSummerConsumption(length) : getWinterConsumption(length);
    }

    private boolean canPassengersBeTransferred(){
        if (isDriverAvailable() && fuel > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (canPassengersBeTransferred())
            return numberOfPassengers;
        else
            return 0;
        //return canPassengersBeTransferred() ? numberOfPassengers: 0;
    }

    public void startMoving() {
        fastenDriverBelt();
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
    }

    public abstract int getMaxSpeed();

}

/*
Рефакторинг (12)
12.1. Объединение условных операторов.
12.1.1. Добавь внутренний метод, сообщающий, могут ли быть перевезены пассажиры boolean canPassengersBeTransferred() в класс Car.
Метод должен возвращать true, если водитель доступен isDriverAvailable и есть топливо fuel.
12.1.2. Перепиши метод getNumberOfPassengersCanBeTransferred(), объединив условные операторы (используй метод canPassengersBeTransferred()).
12.2. Объединение дублирующихся фрагментов в условных операторах. Перепиши метод startMoving(), чтобы в нем не было повторяющихся вызовов функций.
12.3. Замена магического числа символьной константой. Замени магические числа в методе getMaxSpeed() на константные переменные метода:
MAX_TRUCK_SPEED, MAX_SEDAN_SPEED и MAX_CABRIOLET_SPEED.
12.4. Замена условного оператора полиморфизмом.
12.4.1. Переопредели метод getMaxSpeed() в подклассах, избавившись от условного оператора.
12.4.2. Метод getMaxSpeed() в классе Car сделай абстрактным.

Требования:
1. Необходимо создать приватный метод boolean canPassengersBeTransferred() в классе Car и реализовать его.
2. Необходимо изменить метод getNumberOfPassengersCanBeTransferred(), объединив условные операторы (используй метод canPassengersBeTransferred()).
3. Необходимо изменить метод startMoving(), чтобы в нем не было повторяющихся вызовов метода fastenDriverBelt().
4. Необходимо переопределить метод getMaxSpeed() в классе Truck. В методе нужно использовать константную переменную метода MAX_TRUCK_SPEED, значение которой равно 80.
5. Необходимо переопределить метод getMaxSpeed() в классе Sedan. В методе нужно использовать константную переменную метода MAX_SEDAN_SPEED, значение которой равно 120.
6. Необходимо переопределить метод getMaxSpeed() в классе Cabriolet. В методе нужно использовать константную переменную метода MAX_CABRIOLET_SPEED, значение которой равно 90.
7. Метод getMaxSpeed() в классе Car необходимо сделать абстрактным.


Рефакторинг (11)
11.1. Замена кода ошибки исключением. Перепиши метод заправиться fill(double numberOfLiters), чтобы он в случае ошибки кидал исключение Exception.
11.2. Разбиение условного оператора.
11.2.1. Добавь и реализуй метод в классе Car, определяющий относится ли переданная дата к лету:
boolean isSummer(Date date, Date summerStart, Date summerEnd).
11.2.2. Добавь и реализуй метод, рассчитывающий расход топлива зимой: double getWinterConsumption(int length).
11.2.3. Добавь и реализуй метод, рассчитывающий расход топлива летом: double getSummerConsumption(int length).
11.2.4. Перепиши метод getTripConsumption(), используя новые методы.

Требования:
1. Необходимо изменить метод fill(double numberOfLiters) класса Car, чтобы он в случае ошибки бросал исключение Exception.
2. Необходимо добавить в класс Car и реализовать публичный метод boolean isSummer(Date date , Date summerStart, Date summerEnd).
3. Необходимо добавить в класс Car и реализовать публичный метод double getWinterConsumption(int length).
4. Необходимо добавить в класс Car и реализовать публичный метод double getSummerConsumption(int length).
5. Необходимо изменить метод getTripConsumption(), используя методы: isSummer, getWinterConsumption, getSummerConsumption.

Рефакторинг (10)
Разберись с кодом в пакете car (машина).
10.1. Замена конструктора фабричным методом.
10.1.1. Объяви классы Truck (грузовик), Sedan (седан) и Cabriolet (кабриолет), унаследованные от Car.
10.1.2. Добавь в них конструкторы, принимающие int numberOfPassengers.
10.1.3. Добавь фабричный статический метод Car create(int type, int numberOfPassengers) в класс Car и реализуй его.
10.1.4. Измени область видимости конструктора класса Car.


Требования:
1. Нужно создать классы Truck (грузовик), Sedan (седан) и Cabriolet (кабриолет), унаследованные от Car.
2. Необходимо в созданные классы добавить конструкторы, принимающие int numberOfPassengers.
3. Необходимо создать фабричный статический метод Car create(int type, int numberOfPassengers) в классе Car и реализовать его.
4. Необходимо изменить область видимости конструктора класса Car с public на protected.
 */