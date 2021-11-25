package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SpeedTest {
    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids){
        Date startTimestamp = new Date();
        for (String str: strings) {
            ids.add(shortener.getId(str));
        }
        Date endTimestamp = new Date();
        return endTimestamp.getTime() - startTimestamp.getTime();
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        Date startTimestamp = new Date();
        for (Long num: ids) {
            strings.add(shortener.getString(num));
        }
        Date endTimestamp = new Date();
        return endTimestamp.getTime() - startTimestamp.getTime();

    }

    @Test
    public void testHashMapStorage(){
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();

        for (int i = 0; i < 10000; ++i) {
            origStrings.add(Helper.generateRandomString());
        }

        Set<Long> ids1 = new HashSet<>();
        Set<String> strings1 = new HashSet<>();
        long stringToIdTime1 = getTimeToGetIds(shortener1, origStrings, ids1);
        long idToStringTime1 = getTimeToGetStrings(shortener1, ids1, strings1);

        Set<Long> ids2 = new HashSet<>();
        Set<String> strings2 = new HashSet<>();
        long stringToIdTime2 = getTimeToGetIds(shortener2, origStrings, ids2);
        long idToStringTime2 = getTimeToGetStrings(shortener2, ids2, strings2);

        org.junit.Assert.assertTrue("stringToIdTime1 > stringToIdTime2", stringToIdTime1 > stringToIdTime2);
        assertEquals(idToStringTime1, idToStringTime2, 30);
    }
}