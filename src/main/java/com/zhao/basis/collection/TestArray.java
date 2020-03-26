package com.zhao.basis.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-01-12 23:17
 **/
public class TestArray {


     List<Object> list = new ArrayList<>();
     int num = 0;
    volatile  int i = 0;
     ExecutorService service = new ThreadPoolExecutor(100,100,1, TimeUnit.DAYS,new ArrayBlockingQueue<>(100));

    public static void main(String[] args) {
        TestArray testArray = new TestArray();

        for(; testArray.i < 100 ; testArray.i ++) {
            new Thread(() -> {
                try {
                    if(testArray.i % 2 == 1) {
                        testArray.put(testArray.i);
                    } else {
                        System.out.println(testArray.remove());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }).start();
        }


    }

    public void put(Object obj) throws InterruptedException {
        synchronized (list) {
            if(i == 99) {
                return;
            }
            while (list.size() == 10) {
                list.wait();
            }
            list.add(obj);
            list.notify();

        }
    }

    public Object remove() throws InterruptedException {
        synchronized (list) {
            if(i == 99) {
                return 0;
            }
            while (list.size() == 0) {
                list.wait();
            }
            Object result = list.remove(0);
            list.notify();
            return result;


        }
    }




}
