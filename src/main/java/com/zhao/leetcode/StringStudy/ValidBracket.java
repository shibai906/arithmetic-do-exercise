package com.zhao.leetcode.StringStudy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidBracket {

    public static void main(String[] args) {
        System.out.println(isValid(""));
    }

    public static boolean isValid(String s) {
        if(s == null) {
            return false;
        }
        if(s.length() == 1) {
            return false;
        }
        if(s.length() == 0) {
            return true;
        }
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for(int i = 1 ; i < s.length() ; i ++) {
            if( !stack.isEmpty() ) {
                Character c = map.get(stack.peek());
                if( c != null &&c == s.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        if(stack.isEmpty()) {
            return true;
        }
        return false;
    }


}
