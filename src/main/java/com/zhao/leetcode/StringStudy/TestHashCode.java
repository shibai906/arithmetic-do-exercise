package com.zhao.leetcode.StringStudy;

import java.util.HashMap;

public class TestHashCode {

    public static void main(String[] args) {
        String s= "";
        System.out.println(s.hashCode());
        HashMap hashMap = new HashMap();
        hashMap.put("zhao","huan");
        hashMap.put(null,null);
        hashMap.put("zhao1","huan");
        hashMap.put("zhao2","huan");
        hashMap.put("zhao3","huan");
        hashMap.put("zhao4","huan");
        hashMap.put("zhao5","huan");
        hashMap.put("zhao6","huan");
        hashMap.put("zhao7","huan");
        hashMap.put("zhao8","huan");
        hashMap.put("zhao9","huan");
        hashMap.put("zhao10","huan");
        hashMap.put("zhao11","huan");
    }

}
