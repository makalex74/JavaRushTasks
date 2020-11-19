package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager instance;
    private AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager() {

    }

    public static StatisticAdvertisementManager getInstance() {
        if (instance == null) {
            instance = new StatisticAdvertisementManager();
        }
        return instance;
    }

    public List<Advertisement> getVideoSet(boolean isActive) {
        List<Advertisement> resultList = new ArrayList<>();
        for (Advertisement advertisement:storage.list()) {
            if (advertisement.isActive() && isActive) {
                resultList.add(advertisement);
            } else if (!advertisement.isActive() && !isActive) {
                resultList.add(advertisement);
            }
        }
        return resultList;
    }
}
