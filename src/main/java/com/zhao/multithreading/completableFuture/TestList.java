package com.zhao.multithreading.completableFuture;

import lombok.Synchronized;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-03-17 17:11
 **/
public class TestList {

    private static ExecutorService service = new ThreadPoolExecutor(10,20,20, TimeUnit.MINUTES, new ArrayBlockingQueue<>(1000));
    static volatile int i ;

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        safetyThreadByCompletableFuture();

    }

    static void safetyThreadByCompletableFuture() throws ExecutionException, InterruptedException {
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < 100 ; i ++) {
            list.add(i + 1);
        }
        List<CompletableFuture<Integer>> newList = new ArrayList<>();
        list.stream().forEach( a ->newList.add(CompletableFuture.supplyAsync(() -> a + 1,service)));

        int total = 0;
        for(CompletableFuture<Integer> future : newList) {
            total += future.get();
        }
        System.out.println(total);

    }

    static void safetyThread() throws InterruptedException {
        CopyOnWriteArrayList<Integer> newList = new CopyOnWriteArrayList();
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < 100 ; i ++) {
            list.add(i + 1);
        }
        list.parallelStream().forEach(a -> newList.add(a));
        Thread.sleep(1100);
        int total = 0 ;
        for(int i : newList) {
            total += i;
        }
        System.out.println(total);
    }

    static void noSafetyThread() throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < 100 ; i ++) {
            list.add(i + 1);
        }
        List<Integer> newList = new ArrayList<>();
        list.parallelStream().forEach(a -> newList.add(a));
        Thread.sleep(1100);
        int total = 0 ;
        for(Integer i : newList) {
            if(i == null) {
                System.out.println("大家好，我是null");
            } else
                total += i;
        }
        System.out.println(total);
    }

}
