package com.zhao.newInterest.guavaCache;

import com.google.common.cache.*;
import com.google.common.collect.ImmutableMap;
import com.sun.org.apache.xalan.internal.xsltc.dom.CachedNodeListIterator;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: zhaohuan1
 * @Date: 19-12-20
 * @Time: 上午11:22
 * @Description:
 */

/**
 * 查询LoadingCache 的权威方法是用get(K) 。如果已经换存了值，就会直接返回；如果没有，就会使用CacheLoader 来往缓存中自动导入一个新值。
 * 因为CacheLoader 会抛出Exception ，LoadingCache.get(K)可能会抛出ExecutionException 。
 * 你也可以用getUnchecked(K) ，它在UncheckedExecutionException 中包装了所有的UncheckedExecutionException ，
 * 但是，如果CacheLoader 抛出了 checked exceptions的话，会导致奇怪的行为发生。
 *
 */
public class TestClient {

    private static Cache<Object, Object> allCache = CacheBuilder.newBuilder().maximumSize(100).build();

    private static LoadingCache<String,String> allLoadingCache = CacheBuilder.newBuilder().maximumSize(100).build(new CacheLoader<String, String>() {
        @Override
        public String load(String s) throws Exception {
            return "key-" + s;
        }
    });

    private static ExecutorService service = new ThreadPoolExecutor(10,10,0, TimeUnit.MINUTES, new LinkedBlockingQueue<>(100));

    public static void main(String[] args) throws ExecutionException {

        System.out.println(600000000 / 1000 / 60 / 60 /24);
        LoadingCache<String,String> cache = CacheBuilder.newBuilder().build(new CacheLoader<String, String>() {
            @Override
            public String load(String s) throws Exception {
                return "key-" + s;
            }
        });
        System.out.println(cache.get("你好"));
//        cache.put("你好","你不好");
//        cache.
        cache.put("11","22");
        System.out.println(cache.getIfPresent("11"));
        System.out.println(cache.getIfPresent("你好"));
        System.out.println(allLoadingCache.getUnchecked("赵欢"));
        ImmutableMap<String, String> map = cache.getAll(cache.asMap().keySet());
        if(map.containsKey("你好")) {
            System.out.println(0);
        }
    }

    public static void testCacheLoader() {
    }

    public static void testGuauaCache() {

        for(int i = 0 ; i < 100 ; i ++) {
            service.execute(() ->{
                try {
                    System.out.println(allCache.get("key", new Callable<String>() {
                        @Override
                        public String call() throws Exception {
                            return  "key" + Thread.currentThread().getName() ;
                        }
                    }));
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });
        }
    }




}
