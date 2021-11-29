package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    OriginalRetriever originalRetriever;
    LRUCache<Long, Object> lruCache = new LRUCache<>(10);

    public CachingProxyRetriever(Storage storage) {
        this.originalRetriever = new OriginalRetriever(storage);
    }

    @Override
    public Object retrieve(long id) {
        Object resultObject = lruCache.find(id);
        if (resultObject == null) {
            resultObject = originalRetriever.retrieve(id);
            lruCache.set(id, resultObject);
        } else {
            System.out.println("Getting a value for id #" + id + " from LRUCache...");
        }
        return resultObject;
    }
}