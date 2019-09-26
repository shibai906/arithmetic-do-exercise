package com.zhao.design.mode.proxy.javaApi.aopProxy;

import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        ForumService forumService = new ForumServiceImp();
        PerformanceHandler performanceHandler = new PerformanceHandler(forumService);

        ForumService proxy = (ForumService) Proxy.newProxyInstance(forumService.getClass().getClassLoader(),forumService.getClass().getInterfaces(),performanceHandler);

        proxy.insert();
        proxy.delete();

    }

}
