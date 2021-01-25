package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlType(name = "shop")
@XmlRootElement
public class Shop {
    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData = new String[]{"String1", "String2", "String3", "String4", "String5", "String \"6\"", "String & 7", "String <8>", ""};

    public Shop() {
    }

    //@XmlType(name = "goods")
    //@XmlRootElement
    public static class Goods {
        List<String> names;

        public Goods() {
            names = new ArrayList<>();
        }
    }

    @Override
    public String toString() {
        return "Shop{" +
                "goods=" + goods +
                ", count=" + count +
                ", profit=" + profit +
                ", secretData=" + (secretData == null ? null : Arrays.asList(secretData)) +
                '}';
    }
}

