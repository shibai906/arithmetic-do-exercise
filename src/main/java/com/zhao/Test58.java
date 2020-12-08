package com.zhao;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-11-24 20:39
 * @description
 **/
public class Test58 {


    static volatile int num = 0;

    public static void main(String[] args) {
        Object obj = new Object();
        Thread tr1 = new Thread(() -> {
            synchronized (obj) {
                while (true) {
                    if(num % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "----" + num);
                        num ++;
                        obj.notify();
                    } else {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });


        Thread tr2 = new Thread(() -> {
            synchronized (obj) {
                while (true) {
                    if(num % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + "----" + num);
                        num ++;
                        obj.notify();
                    } else {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        });
        tr1.start();
        tr2.start();

    }

}
