package com.zhao.multithreading.threadPool.basic;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        DefaultThreadPool defaultThreadPool = new DefaultThreadPool();
        for(int i = 0 ; i < 10 ;i ++) {
            defaultThreadPool.execute(new Job(i));
        }

        Thread.sleep(1000);

        defaultThreadPool.shutDown();

    }

    static class Job implements Runnable{

        String name = "zhaohuan";
        int i = 0 ;
        public Job (int i) {
            this.i = i;
        }

        @Override
        public void run() {
            for(int i = 0 ; i < 100 ; i ++) {
                System.out.println(name + "-" + this.i + "-" + i);
            }
        }
    }

}
