package com.zhao;

import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.objects.Global.print;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-09-09 18:04
 * @description
 **/
public class TestMaiMai {

    List<String> list = new ArrayList<>();
    public List<String> sort(String str) {
        if(str == null) {
            return null;
        }
        char[] chars = str.toCharArray();

        char[] newChar = new char[chars.length];

        getSort(newChar , chars , 0);
        return this.list;
    }

    public void getSort(char[] chars , char[] newChar , int start) {
        for(int i = 0 ; i < chars.length ; i ++) {

        }

    }




}
