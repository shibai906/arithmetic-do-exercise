package com.zhao.design.mode.bridge.paint;


public abstract class BrushPenAbstraction {


    /**
     * 保留对颜色的引用
     */
    protected ImplementerColor imp ;

    /**
     * 每种笔都有自己的实现
     */
    public abstract void operationDraw();

    public void setImplement(ImplementerColor imp) {
        this.imp = imp;
    }

}
