package com.zhao.design.mode.singleton;

public class LazySinleton {

    private static volatile LazySinleton sinleton ;

    private LazySinleton() throws Exception {
        if(sinleton != null) {
            throw new Exception();
        }
    }

    public static LazySinleton getInstance() throws Exception {
        if(sinleton == null) {
            synchronized (LazySinleton.class) {
                if(sinleton == null) {
                    sinleton = new LazySinleton();
                }
            }
        }
        return sinleton;
    }


}
