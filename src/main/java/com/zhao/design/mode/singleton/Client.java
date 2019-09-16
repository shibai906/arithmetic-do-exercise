package com.zhao.design.mode.singleton;

import java.lang.reflect.Constructor;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Client {

    public static void main(String[] args) throws Exception {

        /*Class<?> classLaySinleton = Class.forName("com.zhao.design.mode.singleton.LazySinleton");
        Constructor clas = classLaySinleton.getDeclaredConstructor();
        clas.setAccessible(true);
        LazySinleton lazySinleton1 = (LazySinleton) clas.newInstance();
        System.out.println(lazySinleton1);

        LazySinleton lazySinleton = LazySinleton.getInstance();
        System.out.println(lazySinleton);
        lazySinleton = LazySinleton.getInstance();
        System.out.println(lazySinleton);
        lazySinleton = LazySinleton.getInstance();
        System.out.println(lazySinleton);*/
        // 反射

        for(int i = 0 ; i < 15 ; i ++) {
            new Thread(() -> {
                try {
                    System.out.println(LazySinleton.getInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }


    }

}
