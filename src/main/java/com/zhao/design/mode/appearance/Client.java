package com.zhao.design.mode.appearance;

public class Client {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.methodA();
        facade.methodB();
    }

}
