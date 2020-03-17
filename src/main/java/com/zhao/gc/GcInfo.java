package com.zhao.gc;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-03-15 10:51
 * 此事例是查看GC信息的
 * VM参数： -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=8145728
 **/
public class GcInfo {

    private static final int _1Mb = 1024 * 1024;

    public static void main(String[] args) throws InterruptedException {
        objectToEden();
    }

    public static void objectToEden() {
        byte[] all1,all2,all3,all4,all5,all6;
        all1 = new byte[2 * _1Mb];
        all2 = new byte[2 * _1Mb];
        all3= new byte[2 * _1Mb];
        all4 = new byte[2 * _1Mb];
        all5= new byte[2 * _1Mb];
        all6= new byte[4 * _1Mb];
    }

}
