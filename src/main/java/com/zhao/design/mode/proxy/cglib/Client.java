package com.zhao.design.mode.proxy.cglib;

import com.zhao.design.mode.proxy.javaApi.aopProxy.ForumServiceImp;

public class Client {

    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        ForumServiceImp forumServiceImp = (ForumServiceImp) proxy.getProxy(ForumServiceImp.class);
        forumServiceImp.insert();
        forumServiceImp.delete();
    }

}
