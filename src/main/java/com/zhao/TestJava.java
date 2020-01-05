package com.zhao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestJava {

    static long tatal = 0 ;
    static ReentrantReadWriteLock readWriteLock =new ReentrantReadWriteLock();
    static Lock redLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();
    static volatile boolean flag = true;
    static volatile char print = 'a';
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException, NoSuchAlgorithmException, IOException {

        System.out.println("你好");
//        URL url = new URL("https://ts.market.mi-img.com/download/MifiMp/MifiMp/058c72488116040942bf838730f096d2c9898bfee/1.xlsx");
//        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//        InputStream in = urlConnection.getInputStream();
//        System.out.println(in.read());
//
//
//        System.out.println();
//
//        List<String> list = new ArrayList<>();
//        list.add("/1.xlsx");
//        list.add("/1.xls");
//        list.add("/1.csv");
//        String str = "str" ;
//        str += "/1." + "xlsx";
//        System.out.println(str);
//        System.out.println(list.contains( "/1." + "xlsx"));

//        System.out.println((1|2) & 1);
//
//        Long integer = new Long(34);
//        System.out.println(integer.toString(1,2));
//
//        System.out.println(System.currentTimeMillis());

/*        System.out.println("c5a01733977a2d1797abced1e81305b1".equals("c5a01733977a2d1797abced1e81305b1"));

        InputStream in = new FileInputStream("/home/work/log/1.zip");
        int iAvail = in.available();
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bytes = new byte[iAvail];
        in.read(bytes);
        System.out.println(new String(bytes,1,10));
        md.update(bytes);
        byte[] digest = md.digest();//此处得到的是md5加密后的byte类型值

        int i;
        StringBuilder sb = new StringBuilder();
        for (int offset = 0; offset < digest.length; offset++) {
            i = digest[offset];
            if (i < 0)
                i += 256;
            if (i < 16)
                sb.append(0);
            sb.append(Integer.toHexString(i));//通过Integer.toHexString方法把值变为16进制
        }

        System.out.println(new String(bytes,1,10));
        System.out.println(sb.toString());*/

/*        Optional<JSONObject> optional = Optional.ofNullable(JSON.parseObject("{\"image\":\"miuifile://MifiMp/097c65edd406d888426fb4c3d4cbfd1337e4218a2\",\"stat\":{\"screen_area\":\"profile_item_finan_icon\",\"element_id\":\"理财_705\",\"element_position\":\"2\"},\"type\":\"icon\",\"title\":\"理财\",\"target\":{\"title\":\"借钱\",\"loginRequired\":false,\"url\":\"https://api.jr.mi.com/app/home?from=local&id=fund\"}}"));
        System.out.println(optional.map(jsonObject1 -> jsonObject1.getString("title")).orElse(""));*/

 /*       List<Integer> list = new ArrayList<>();
        for(int i = 1 ; i < 1000000000 ; i ++) {
            list.add(i);
        }
        long startTime = System.currentTimeMillis();

        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> {
          list.parallelStream().forEach( integer ->  tatal = integer + tatal);
          return tatal;
        }).exceptionally( e -> {
            e.printStackTrace();
            return 0L;});
        long endStartTime = System.currentTimeMillis();
        future.get(60, TimeUnit.MILLISECONDS);
        System.out.println(future.get() + "----" + tatal + ", 时间：" + (endStartTime - startTime));*/
/*        tatal = 0 ;
        long startTime = System.currentTimeMillis();
        list.stream().forEach(integer -> tatal = integer + tatal);
        long endStartTime = System.currentTimeMillis();
        System.out.println(tatal + ", 时间：" + (endStartTime - startTime));*/
    }

    private static void testFlag() {
        new Thread(() -> {
            while (print <= 'z') {
                if(flag) {
                    System.out.println(Thread.currentThread().getName() + "--------" + print ++);
                    flag = false;
                }
            }
        }).start();
        new Thread(() -> {
            while (print <= 'z') {
                if(!flag) {
                    System.out.println(Thread.currentThread().getName() + "--------" + print ++);
                    flag = true;
                }
            }
        }).start();
    }

    private static void testReadWriteLock() {
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(() -> {
            while (print <= 'z') {
                if((print - 'a') % 2 == 0 ) {
                    redLock.lock();
                    System.out.println(Thread.currentThread().getName() + "--------" + print ++);
                    redLock.unlock();
                }
            }
        });
        service.submit(() -> {
            while (print <= 'z') {
                if((print - 'a') % 2 == 1 ) {
                    writeLock.lock();
                    System.out.println(Thread.currentThread().getName() + "--------" + print ++);
                    writeLock.unlock();
                }
            }
        });
        service.shutdown();
    }

    private static void testSynchronized(String[] args) {
        new Thread(() ->{
            synchronized (args) { // 锁的名称
                while (print <= 'z') {
                    if((print - 'a') % 2 == 0 ) {
                        System.out.println(Thread.currentThread().getName() + "--------" + print ++);
                        args.notify();
                    } else {
                        try {
                            args.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
        new Thread(() ->{
            synchronized (args) { // 锁的名称
                while (print <= 'z') {
                    if((print - 'a') % 2 == 1 ) {
                        System.out.println(Thread.currentThread().getName() + "--------" + print ++);
                        args.notify();
                    } else {
                        try {
                            args.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }

}
