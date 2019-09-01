package com.zhao.design.mode.bridge.jdbc;

public class MysqlDriver implements Driver {
    @Override
    public void getConnection() {
        System.out.println("mysql数据库连接");
    }
}
