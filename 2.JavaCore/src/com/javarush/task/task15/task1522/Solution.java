package com.javarush.task.task15.task1522;

/* 
Закрепляем паттерн Singleton
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        /*readKeyFromConsoleAndInitPlanet();
        readKeyFromConsoleAndInitPlanet();
        readKeyFromConsoleAndInitPlanet();
        readKeyFromConsoleAndInitPlanet();
        readKeyFromConsoleAndInitPlanet();*/
    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static{
        try {
            readKeyFromConsoleAndInitPlanet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String planetStr = reader.readLine();
        if (planetStr.equals(Planet.EARTH) || planetStr.equals(Planet.MOON) || planetStr.equals(Planet.SUN)) {
            if (planetStr.equals(Planet.EARTH))
              thePlanet = Earth.getInstance();
            else if (planetStr.equals(Planet.MOON))
                thePlanet = Moon.getInstance();
            else if (planetStr.equals(Planet.SUN))
                thePlanet = Sun.getInstance();
        } else thePlanet = null;
        /*System.out.println(thePlanet);*/
    }
}
