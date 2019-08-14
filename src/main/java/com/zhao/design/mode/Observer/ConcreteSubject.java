package com.zhao.design.mode.Observer;

/**
 * 具体目标对象（被观察者）
 */
public class ConcreteSubject extends Subject {

    private int state;
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObserver();
    }

}
