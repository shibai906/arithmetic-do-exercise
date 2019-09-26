package com.zhao.multithreading.threadfactory;

public class WorkRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("complete a task");
    }
}
