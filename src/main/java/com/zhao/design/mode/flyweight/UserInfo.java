package com.zhao.design.mode.flyweight;

public class UserInfo {

    private String name;
    private String phoneNumber;

    public UserInfo(String name,String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
