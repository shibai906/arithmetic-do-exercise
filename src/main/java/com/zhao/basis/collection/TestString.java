package com.zhao.basis.collection;

public class TestString {

    public static void main(String[] args) {
        testStringBuffer();
    }

    public static void testStringBuffer() {
        StringBuffer sb = new StringBuffer();
        sb.append("222");
//        StringBuilder
        System.out.println(sb.toString());
    }

}
