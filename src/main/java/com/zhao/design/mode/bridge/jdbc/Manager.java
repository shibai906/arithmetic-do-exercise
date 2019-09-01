package com.zhao.design.mode.bridge.jdbc;

public abstract class Manager {

    private Driver driver;

    public Manager(Driver driver) {
        this.driver = driver;
    }

    public void getConnection() {
        driver.getConnection();
    }

    private void setDriver(Driver driver){
        this.driver = driver;
    }

}
