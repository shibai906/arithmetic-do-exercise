package com.zhao.teach;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-03-26 18:37
 * @description
 **/
public class Person {

    private int age ;
    private String name;
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    private int getTwoAge() {
        int towAge = age * 2;
        return towAge;
    }


}
