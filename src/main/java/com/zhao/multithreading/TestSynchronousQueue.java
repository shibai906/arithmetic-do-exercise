package com.zhao.multithreading;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestSynchronousQueue {

    public static void main(String[] args) throws InterruptedException {

        LinkedTransferQueue<Character> synchronousQueue = new LinkedTransferQueue<>();
        new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                synchronousQueue.put((char) ('a' + i));
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 26; i++) {
                System.out.println(synchronousQueue.poll());
            }
        }).start();

    }

}
