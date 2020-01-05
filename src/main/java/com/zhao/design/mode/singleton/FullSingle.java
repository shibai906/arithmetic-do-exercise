package com.zhao.design.mode.singleton;

import java.io.Serializable;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-01-05 21:24
 **/
public class FullSingle implements Serializable,Cloneable{

    public static FullSingle fullSingle ;

    private FullSingle() {

    }

    public static FullSingle getInstance() {
        if(fullSingle == null) {
            synchronized (LazySinleton.class) {
                if(fullSingle == null) {
                    fullSingle = new FullSingle();
                }
            }
        }
        return fullSingle;
    }

    @Override
    protected FullSingle clone() throws CloneNotSupportedException {
        return fullSingle;
    }
    private Object readResolve() {
        return fullSingle;
    }

}
