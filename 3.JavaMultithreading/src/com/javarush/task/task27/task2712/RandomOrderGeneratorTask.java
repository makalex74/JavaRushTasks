package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Order;
import javafx.scene.control.Tab;

import java.util.ArrayList;
import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> tablets = new ArrayList<>();
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int k = (int) Math.random() * tablets.size();
                Tablet expectedTablet = tablets.get(k);
                expectedTablet.createTestOrder();

                Thread.sleep(interval);
            }
        } catch (InterruptedException e) {
        }


    }
}

/*
2. В отдельном классе создай таск (Runnable) RandomOrderGeneratorTask. Этот таск должен:
2.1. Хранить список всех планшетов
2.2. Используя Math.random выбирать случайный планшет.
2.3. У RandomOrderGeneratorTask должен быть только один единственный метод.
2.4. Генерировать случайный заказ каждые ORDER_CREATING_INTERVAL миллисекунд для планшета из п.2.2. (не печатай стек-трейс)

 */
