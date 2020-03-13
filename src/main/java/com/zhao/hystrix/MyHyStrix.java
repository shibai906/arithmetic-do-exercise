package com.zhao.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.function.Supplier;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-03-09 15:51
 **/
public class MyHyStrix<R> extends HystrixCommand<R> {
    private String name ;
    Supplier<R> mainMethod;
    Supplier<R> fallback;
    protected MyHyStrix(String name , Supplier<R> mainMethod , Supplier<R> fallback ) {
        super(HystrixCommandGroupKey.Factory.asKey(name));
        this.name = name ;
        this.mainMethod = mainMethod;
        this.fallback = fallback;
    }

    @Override
    protected R run() throws Exception {
        return mainMethod.get();
    }

    @Override
    protected R getFallback() {
        return fallback.get();
    }
}
