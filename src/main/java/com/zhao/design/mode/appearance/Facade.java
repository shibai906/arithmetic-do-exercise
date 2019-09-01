package com.zhao.design.mode.appearance;

public class Facade {

    private SubSystem1 subSystem1;
    private SubSystem2 subSystem2;
    private SubSystem3 subSystem3;
    private SubSystem4 subSystem4;
    private SubSystem5 subSystem5;
    private SubSystem6 subSystem6;

    public Facade() {
        subSystem1 = new SubSystem1();
        subSystem2 = new SubSystem2();
        subSystem3 = new SubSystem3();
        subSystem4 = new SubSystem4();
        subSystem5 = new SubSystem5();
        subSystem6 = new SubSystem6();
    }

    public void methodA() {
        subSystem1.m1();
        subSystem3.m3();
        subSystem5.m5();
    }

    public void methodB() {
        subSystem2.m2();
        subSystem4.m4();
        subSystem6.m6();
    }

}
