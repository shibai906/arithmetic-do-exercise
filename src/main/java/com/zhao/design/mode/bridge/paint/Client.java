package com.zhao.design.mode.bridge.paint;

public class Client {

    public static void main(String[] args) {
        BrushPenAbstraction brushPen = new BigBrushPenRefinedAbstraction();
        ImplementerColor col = new OncreteImplementorRed();
        /**
         * 设置颜色
         */
        brushPen.setImplement(col);
        /**
         * 画画
         */
        brushPen.operationDraw();
    }

}
