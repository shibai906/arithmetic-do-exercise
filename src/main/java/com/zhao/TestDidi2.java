package com.zhao;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-11-30 16:03
 * @description
 *  1 - 100亿    删除一个数字，剩下的数乱序，找出删除的数字
 *
 *  api   日调用量1亿次，   每次处理都会通过随机i计算i的阶乘， 可能大、可能小。      i的范围  ——》
 **/
public class TestDidi2 {

    int semaphoreInt = 15;
    ThreadPoolExecutor tpe = new ThreadPoolExecutor(15, 20, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<>(100));
    Semaphore semaphore = new Semaphore(semaphoreInt);

    public static void main(String[] args) {

        TestDidi2 didi2 = new TestDidi2();
        System.out.println(didi2.fun2(10, 0, 0));

    }

    public int fun2(int num, int add, int jisuan) {
        if(add == 0) {
            add = 1;
        }
        if(jisuan == 0) {
            jisuan = 1;
        }

        for(int i = jisuan ; i <= num ; i ++) {
            add = jisuan(i, add);
        }
        return add;
    }

    private int jisuan(int num, int add) {
        return num * add;
    }



}
