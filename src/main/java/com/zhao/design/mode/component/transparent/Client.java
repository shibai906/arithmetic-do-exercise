package com.zhao.design.mode.component.transparent;

public class Client {

    public static void main(String[] args) {
        MobileComponent root = new MobileComposite("小米");
        MobileComponent c2 = new MobileComposite("苹果");
        MobileComponent c1 = new MobileComposite("华为");

        MobileComponent s1 = new SpecifyMobile("垃圾Mate系列");
        MobileComponent s2 = new SpecifyMobile("垃圾P系列");
        MobileComponent s3 = new SpecifyMobile("iphone系列");
        MobileComponent s4 = new SpecifyMobile("iphone se 系列");

        root.addChild(c1);
        root.addChild(c2);

        c1.addChild(s1);
        c1.addChild(s2);
        c2.addChild(s3);
        c2.addChild(s4);

        root.printStruct(" ");
    }

}
