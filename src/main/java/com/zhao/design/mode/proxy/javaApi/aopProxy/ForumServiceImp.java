package com.zhao.design.mode.proxy.javaApi.aopProxy;

public class ForumServiceImp implements ForumService {
    @Override
    public void insert() {
        System.out.println("插入了，疼不疼!");
    }

    @Override
    public void delete() {
        System.out.println("我拔出来了，你还要不要!");
    }
}
