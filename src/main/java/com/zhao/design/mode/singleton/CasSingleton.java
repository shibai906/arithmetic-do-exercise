package com.zhao.design.mode.singleton;

import java.util.concurrent.atomic.AtomicReference;

public class CasSingleton {

    private static final AtomicReference<CasSingleton> INSTANCE = new AtomicReference<CasSingleton>();

    private CasSingleton() {

    }

    public static CasSingleton getInstance() {
        for(;;) {
            CasSingleton singleton = INSTANCE.get();
            if(singleton != null) {
                return singleton;
            }
            singleton = new CasSingleton();
            if(INSTANCE.compareAndSet(null, singleton)) {
                return singleton;
            }
        }
    }


}
