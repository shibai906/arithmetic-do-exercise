package com.zhao.newInterest.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: zhaohuan1
 * @Date: 20-1-3
 * @Time: 下午6:00
 * @Description:
 */
public class TestStudent implements Runnable {

    private CyclicBarrier cyclicBarrier;
    private String name;
    public TestStudent(CyclicBarrier cyclicBarrier , String name) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;

    }

    @Override
    public void run() {
        System.out.println(name + "开始");

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + "完成");

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(name + "结束");
    }
}
