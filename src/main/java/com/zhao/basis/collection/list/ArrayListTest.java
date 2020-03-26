package com.zhao.basis.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-01-12 23:05
 **/
public class ArrayListTest {

    public static void main(String[] args) {
//        List<String> toArray = new ArrayList<>();
//        toArray.add("wode");
        ArrayList<String> list = new ArrayList<>();
        list.add("我爱你");
        list.add("我爱你");
        list.add("我爱你");
        list.add(null);
        list.get(1);
        list.indexOf("我爱你");
        list.add(1,"康译文");
        Object[] obj = new Object[0];
        System.out.println(obj.length);
    }


}
