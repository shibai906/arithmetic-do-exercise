package com.zhao.multithreading.finaltest;

import com.sun.org.apache.xpath.internal.operations.Mod;

public class Model {

    final int i ;
    int j ;
    static Model model ;

    public Model() {
        i = 1;
        j = 2;
    }

    public static Model getModel() {
        model = new Model();
        return model;
    }

    public static void test() {
        Model mod = model;
        System.out.println("i = " + mod.i + ", j = " + mod.j);
    }

}
