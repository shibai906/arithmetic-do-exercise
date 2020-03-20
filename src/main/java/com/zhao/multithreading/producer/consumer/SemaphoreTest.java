package com.zhao.multithreading.producer.consumer;

import java.util.concurrent.Semaphore;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-03-18 15:52
 **/
public class SemaphoreTest {

    int count = 0;
    final Semaphore notFull = new Semaphore(10);
    final Semaphore notEmpty = new Semaphore(0);
    final Semaphore mutex = new Semaphore(1);

    class Producer implements Runnable
    {
        @Override
        public void run()
        {
            for (int i = 0; i < 10; i++)
            {
                try
                {
                    notFull.acquire();//顺序不能颠倒，否则会造成死锁。
                    mutex.acquire();
                    count++;
                    System.out.println(Thread.currentThread().getName()
                            + "生产者生产，目前总共有" + count);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    mutex.release();
                    notEmpty.release();
                }

            }
        }
    }

    class Consumer implements Runnable
    {

        @Override
        public void run()
        {
            for (int i = 0; i < 10; i++)
            {
                try
                {
                    notEmpty.acquire();//顺序不能颠倒，否则会造成死锁。
                    mutex.acquire();
                    count--;
                    System.out.println(Thread.currentThread().getName()
                            + "消费者消费，目前总共有" + count);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    mutex.release();
                    notFull.release();
                }

            }

        }

    }

    public static void main(String[] args) throws Exception {
        SemaphoreTest test = new SemaphoreTest();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();

        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
    }
}
