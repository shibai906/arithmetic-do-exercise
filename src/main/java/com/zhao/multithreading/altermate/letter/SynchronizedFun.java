package com.zhao.multithreading.altermate.letter;

import java.sql.Statement;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-03-17 17:48
 **/
public class SynchronizedFun {
    static volatile Character start = 'a';
    static Object object = new Object();
    static Object A = new Object();
    static Object B = new Object();
    static ReentrantLock lock = new ReentrantLock();
    static Condition conA = lock.newCondition();
    static Condition conB = lock.newCondition();

    static AtomicInteger atomicInteger = new AtomicInteger('a');           //  需要注意的是，这里必须是对象

    public static void main(String[] args) {
    }

    public static void testPrintLock() {
        Thread a = new Thread(() -> {
            lock.lock();
            while (start <= 'z') {
                if (start % 2 == 1) {
                    System.out.println("a------------:" + start);
                    start++;
                    conB.signal();
                }
                try {
                    conA.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.unlock();
        });
        a.start();
        Thread b = new Thread(() -> {
            lock.lock();
            while (start <= 'z') {
                if (start % 2 == 0) {
                    System.out.println("b:" + start);
                    start++;
                    conA.signal();
                }
                try {
                    conB.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.unlock();

        });
        b.start();
    }

    public static void testPrintSynchronizedClass() {
        new Thread(new ThreadSynchronized(atomicInteger, 'z', 0, new String("a--------"), object)).start();
        new Thread(new ThreadSynchronized(atomicInteger, 'z', 1, new String("b"), object)).start();
    }

    public static void testPrintSynchronized() {
        Thread a = new Thread(() -> {
            synchronized (object) {
                while (start <= 'z') {
                    if (start % 2 == 1) {
                        System.out.println("a------------:" + start);
                        start++;
                        object.notify();
                    }
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        a.start();
        Thread b = new Thread(() -> {
            synchronized (object) {
                while (start <= 'z') {
                    if (start % 2 == 0) {
                        System.out.println("b:" + start);
                        start++;
                        object.notify();
                    }
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

        });
        b.start();

    }

}

class ThreadSynchronized implements Runnable {
    private Character start;
    private char end;
    private int yushu;
    private String name;
    private Object object;
    private AtomicInteger atomicInteger;

    public ThreadSynchronized(AtomicInteger atomicInteger, char end, int yushu, String name, Object object) {
        this.atomicInteger = atomicInteger;
        this.end = end;
        this.yushu = yushu;
        this.name = name;
        this.object = object;
    }


    @Override
    public void run() {
        synchronized (object) {
            while (atomicInteger.get() <= end) {
                if (atomicInteger.get() % 2 == yushu) {
                    System.out.println(name + ":" + (char) atomicInteger.get());
                    atomicInteger.incrementAndGet();
                    object.notify();
                }
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
