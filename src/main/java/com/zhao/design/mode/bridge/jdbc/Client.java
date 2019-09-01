package com.zhao.design.mode.bridge.jdbc;

public class Client {

    public static void main(String[] args) {
        DriverManager driverManager = new DriverManager(new MysqlDriver());
        driverManager.getConnection();
        driverManager = new DriverManager(new OracleDriver());
        driverManager.getConnection();
    }

}
