package com.zhao.design.mode.proxy;

public class Printer implements Printable {

    String name;

    public Printer(String name) {
        this.name = name;
        heavyWork();
        System.out.println("生成打印机实例成功...");
    }

    private void heavyWork() {
        System.out.println("本人：" + name);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setPrinterName(String name) {
        this.name = name;
    }



    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String word) {
        System.out.println("打印机" + name + "正在打印...");
        System.out.println(word);
        System.out.println("打印完成！");
    }
}
