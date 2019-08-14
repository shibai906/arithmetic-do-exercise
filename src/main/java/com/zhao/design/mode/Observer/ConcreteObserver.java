package com.zhao.design.mode.Observer;

public class ConcreteObserver implements Observer {

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public void update(Subject subject) {
        // 获取目标对象的数据变化，同时更新当前观察者
        ConcreteSubject concreteSubject = (ConcreteSubject) subject;
        state = concreteSubject.getState();

    }
}
