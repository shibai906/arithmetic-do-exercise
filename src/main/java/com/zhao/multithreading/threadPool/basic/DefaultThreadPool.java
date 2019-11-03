package com.zhao.multithreading.threadPool.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {

    // 线程池最大限制数
    private static final int MAX_WORKER_NUMBERS = 10;
    //线程池默认的数量
    private static final int DEFAULT_WORKER_NUMBERS = 5;
    // 线程池最小的数量
    private static final int MIN_WORKER_NUMBERS = 1;
    // 这是一个工作列表，将会向里面插入工作
    private final LinkedList<Job> jobs =new LinkedList<>();
    // 工作者列表
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<>());
    // 工作者线程的数量
    private int worker = DEFAULT_WORKER_NUMBERS;
    // 线程编号生成
    private AtomicLong threadNum = new AtomicLong();

    public DefaultThreadPool() {
        initializeWorkers(worker);
    }

    public DefaultThreadPool(int num) {
        int worker = num > MAX_WORKER_NUMBERS ? MAX_WORKER_NUMBERS : num < MIN_WORKER_NUMBERS ? MIN_WORKER_NUMBERS : num;
        initializeWorkers(worker);
    }

    @Override
    public void execute(Job job) {
        if(job != null) {
            // 添加一个工作，然后进行通知
            synchronized (jobs) {
                jobs.add(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void shutDown() {
        for(Worker worker : workers ) {
            worker.shutdown();
        }
    }

    @Override
    public void removeWorker(int num) {
        synchronized (jobs) {
            num = worker - num < MIN_WORKER_NUMBERS ? worker - MIN_WORKER_NUMBERS : num;
            int count = 0 ;
            for(int i = 0 ; i < num ; i ++) {
                workers.remove(0).shutdown();
            }
            this.worker -= num;

        }
    }

    @Override
    public void addWorker(int num) {
        synchronized (jobs) {
            // 限制新增数量不能超过最大值
            num = num + worker > MAX_WORKER_NUMBERS ? MAX_WORKER_NUMBERS - worker : num;
            initializeWorkers(num);
            this.worker += num;
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    // 初始化线程工作者
    private void initializeWorkers(int num) {
        for (int i = 0 ; i < num ; i ++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker,"ThreadPool-Worker-" + threadNum.incrementAndGet());
            thread.start();
        }
    }

    class Worker implements Runnable {

        // 是否工作
        private volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                Job job = null ;
                synchronized (jobs) {
                    // 如果列表是空的，那么就wait
                    while (jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            // 感知到外部对WorkerThread的中断操作，返回
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                }
                // 取出一个job
                job = jobs.removeFirst();
                if(jobs!=null){
                    job.run();
                }
            }

        }

        public void shutdown() {
            running = false;
        }

    }

}
