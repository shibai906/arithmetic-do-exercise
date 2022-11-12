package com.zhao;

import java.util.LinkedHashMap;
import java.util.Set;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-09-28 10:38
 * @description
 **/
public class Test {

    LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap();
    int size;
    public Test(int size) {
        this.size = size;
    }

    public void put(String key, String value) {

        if (linkedHashMap.containsKey(key)) {
            linkedHashMap.remove(key);
        } else if (linkedHashMap.size() <= size) {
            Set<String> set = linkedHashMap.keySet();
            linkedHashMap.remove(set.iterator().next());
        }
        linkedHashMap.put(key,value);
    }

    public String get(String key) {
        if (linkedHashMap.containsKey(key)) {
            String value = linkedHashMap.get(key);
            linkedHashMap.remove(key);
            linkedHashMap.put(key, value);
            return value;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {


    }


}

