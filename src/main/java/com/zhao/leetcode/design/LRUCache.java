package com.zhao.leetcode.design;

import java.util.LinkedHashMap;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-05-15 17:10
 * @description
 **/
public class LRUCache {

    LinkedHashMap<Integer, Integer> linkedHashMap = null;
    int capacity = 0;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        linkedHashMap = new LinkedHashMap(capacity);
    }

    public int get(int key) {
        if (!linkedHashMap.containsKey(key)) {
            return -1;
        }
        int value = linkedHashMap.get(key);
        linkedHashMap.remove(key);
        linkedHashMap.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (linkedHashMap.containsKey(key)) {
            linkedHashMap.remove(key);
            linkedHashMap.put(key, value);
            return;
        }
        if (linkedHashMap.size() == capacity) {
            linkedHashMap.remove(linkedHashMap.entrySet().iterator().next().getKey());
        }
        linkedHashMap.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,6);
        lruCache.put(1,2);
        lruCache.put(2,3);
        lruCache.put(3,3);
        lruCache.get(2);
    }

}
