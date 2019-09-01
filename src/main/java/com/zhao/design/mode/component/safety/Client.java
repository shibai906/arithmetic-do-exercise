package com.zhao.design.mode.component.safety;

public class Client {

    public static void main(String[] args) {
        MobileComposite root = new MobileComposite("小米");
        MobileComposite c2 = new MobileComposite("苹果");
        MobileComposite c1 = new MobileComposite("华为");

        SpecifyMobile s1 = new SpecifyMobile("垃圾Mate系列");
        SpecifyMobile s2 = new SpecifyMobile("垃圾P系列");
        SpecifyMobile s3 = new SpecifyMobile("iphone系列");
        SpecifyMobile s4 = new SpecifyMobile("iphone se 系列");

        root.addChild(c1);
        root.addChild(c2);

        c1.addChild(s1);
        c1.addChild(s2);
        c2.addChild(s3);
        c2.addChild(s4);

        root.printStruct(" ");
    }

}
