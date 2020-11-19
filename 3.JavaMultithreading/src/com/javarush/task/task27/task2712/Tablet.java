package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet /*extends Observable*/ {
    private final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue queue;

    public Tablet(int number) {
        this.number = number;
    }

    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }

    public void createOrder() {
        Order order = null;
        try {
            order = new Order(this);
            processOrder(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        } catch (NoVideoAvailableException nve) {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
        //return order;
    }
    public void createTestOrder() {
        Order order = null;
        try {
            order = new TestOrder(this);
            //if (processOrder(order)) return null;
            processOrder(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        } catch (NoVideoAvailableException nve) {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
        //return order;
    }

    private boolean processOrder(Order order) {
        ConsoleHelper.writeMessage(order.toString());
        if (order.isEmpty())
            return true;

        queue.offer(order);

/*        setChanged();
        notifyObservers(order);*/

        new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
        return false;
    }

    public void setQueue(LinkedBlockingQueue queue) {
        this.queue = queue;
    }
}

/*
Сейчас заказ создается в методе createOrder в классе Tablet.
В классе Tablet создай метод void createTestOrder() с похожей функциональностью,
который будет случайным образом генерировать заказ со случайными блюдами не общаясь с реальным человеком.
Все необходимые данные передай в конструкторе.

Подсказка:
а) создай класс TestOrder - наследник Order - в пакете родителя.
б) в классе Order создай protected метод initDishes(), в котором инициализируй dishes. Вызови этот метод в конструкторе
в) в классе Order сделай поле dishes protected
г) переопредели initDishes в классе-наследнике TestOrder. Сделай инициализацию случайным набором блюд.
д) вместо создания объекта Order в методе createTestOrder() класса Tablet, создавай объект класса TestOrder.
Весь другой функционал метода createTestOrder оставь прежним

3. Отрефакторь методы createTestOrder() и createOrder(): в одном из методов выдели код, который повторяется в обоих методах, и нажми Ctrl+Alt+M, введи любое имя метода и нажми ОК. IDEA предложит заменить этот код во втором методе, подтверди.


Требования:
1. В классе Restaurant должна быть создана приватная статическая константа ORDER_CREATING_INTERVAL типа int со значением 100.
2. Класс RandomOrderGeneratorTask должен быть реализован в соответствии с условием задачи.
3. Класс TestOrder должен быть реализован в соответствии с условием задачи.
4. В классе Order должен быть создан метод initDishes инициализирующий dishes.
5. В конструкторе класса Order должен быть вызван метод initDishes.
 */

