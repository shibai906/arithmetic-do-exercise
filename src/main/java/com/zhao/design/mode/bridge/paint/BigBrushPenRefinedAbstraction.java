package com.zhao.design.mode.bridge.paint;

public class BigBrushPenRefinedAbstraction extends BrushPenAbstraction {
    @Override
    public void operationDraw() {
        System.out.println("Big and" + imp.bepaint() + "drawing");
    }
}
