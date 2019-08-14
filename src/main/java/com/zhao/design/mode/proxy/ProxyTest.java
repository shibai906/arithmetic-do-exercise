package com.zhao.design.mode.proxy;

public class ProxyTest {

    public static void main(String[] args) {

        Printable proxy = new ProxyPrinter();
        proxy.setPrinterName("zhaohuan");
        System.out.println("此时代理的名字为：" + proxy.getPrinterName());
        System.out.println("==遇到代理处理不了的工作，我要通知服务器过来做");
        proxy.print("hello,world!");
        System.out.println("=======");
        proxy.setPrinterName("zhaodalong");
        System.out.println("此时代理的名字为：" + proxy.getPrinterName());
        proxy.print("hello,my country!");

    }

}
