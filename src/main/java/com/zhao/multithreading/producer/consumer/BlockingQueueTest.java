package com.zhao.multithreading.producer.consumer;

import java.util.UUID;
import java.util.concurrent.*;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-03-18 15:05
 **/
public class BlockingQueueTest {

    private static ExecutorService executor = new ThreadPoolExecutor(10,20,20, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10));


    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        executor.execute(new Producer(queue));
        executor.execute(new Consumer(queue));
    }


}

class Producer implements Runnable {

    BlockingQueue<String> queue;
    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        while (true) {
            try {
                queue.put(UUID.randomUUID().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
class Consumer implements Runnable {

    BlockingQueue<String> queue;
    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
