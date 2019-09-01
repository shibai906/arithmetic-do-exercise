package com.zhao.design.mode.flyweight;

public abstract class Address {
    public abstract String getType();

    public void display(UserInfo userInfo) {
        System.out.println("\nName is " + userInfo.getName() + ", phone number is " + userInfo.getPhoneNumber() + ", and type is " + getType());
    }

}
