package com.zhao.newInterest.optionalTest;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: zhaohuan1
 * @Date: 19-12-24
 * @Time: 下午2:53
 * @Description:
 */
@Data
public class TestModel {

    private String name;
    private int age;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
