package com.zhao.newInterest.barrier;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: zhaohuan1
 * @Date: 20-1-3
 * @Time: 下午6:00
 * @Description:
 */
public class Client {

    public static void main(String[] args) {
        ExecutorService service = new ThreadPoolExecutor(5,10,1, TimeUnit.MINUTES,new ArrayBlockingQueue<>(10));
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        service.execute(new TestStudent(cyclicBarrier,"赵欢"));
        service.execute(new TestStudent(cyclicBarrier,"赵达龙"));
        service.execute(new TestStudent(cyclicBarrier,"赵有钱"));
        service.shutdown();
    }

}
