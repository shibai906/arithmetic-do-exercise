package com.zhao.multithreading.join.join1;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new ThreadJoin1("赵欢"));
        Thread thread2 = new Thread(new ThreadJoin1("谁谁谁"));
        thread1.start();
        thread1.join();

        thread2.start();

    }

}
