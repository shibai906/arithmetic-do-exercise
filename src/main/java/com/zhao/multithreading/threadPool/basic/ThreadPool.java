package com.zhao.multithreading.threadPool.basic;

public interface ThreadPool<Job extends Runnable> {

    // 执行一个job，这个Job需要实现Runnable
    void execute(Job job);
    // 关闭线程池
    void shutDown();
    // 减少工作者线程
    void removeWorker(int num);
    // 增加工作者线程
    void addWorker(int num);
    // 得到正在等待执行的任务数量
    int getJobSize();

}
