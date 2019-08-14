package com.zhao.design.mode.Observer;

public class Client {

    public static void main(String[] args) {

        // 创建具体的目标对象（被观察者）
        ConcreteSubject concreteSubject = new ConcreteSubject();
        // 创建多个具体观察者
        ConcreteObserver obs1 = new ConcreteObserver();
        ConcreteObserver obs2 = new ConcreteObserver();
        ConcreteObserver obs3 = new ConcreteObserver();
        // 让观察者观察目标对象(被观察者)的数据
        concreteSubject.observerList.add(obs1);
        concreteSubject.observerList.add(obs2);
        // 改变某个目标对象(被观察者)的数据
        concreteSubject.setState(10);
        // 观察者数据是否与被观察者数据变化一致
        System.out.println("观察者obs1:" + obs1.getState());
        System.out.println("观察者obs2:" + obs2.getState());
        System.out.println("观察者obs3:" + obs3.getState());

    }

}
