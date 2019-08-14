package com.zhao.design.mode.Observer;

import java.util.ArrayList;

/**
 * 观察者要观察的目标对象
 * @author 赵欢
 */
public abstract class Subject {

    protected ArrayList<Observer> observerList = new ArrayList<>();

    // 表示观察者目标对象（被观察者）开始观察
    public void registerObserver(Observer obs) {
        observerList.add(obs);
    }

    // 表示取消某观察者对目标对象(被观察者)的观察
    public void upRegisterObserver(Observer obs) {
        observerList.remove(obs);
    }

    // 当目标对象(被观察者)的状态发生变化时，及时更新观察者的状态
    public void notifyAllObserver() {
        for(Observer observer: observerList) {
            observer.update(this);
        }
    }


}
