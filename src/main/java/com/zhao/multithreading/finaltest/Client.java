package com.zhao.multithreading.finaltest;

public class Client {

    public static void main(String[] args) {

         new Thread(()-> {
            Model.getModel();
        }).start();

        new Thread(()-> {
            Model.test();
        }).start();
    }

}
