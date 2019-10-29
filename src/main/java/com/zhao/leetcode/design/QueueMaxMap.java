package com.zhao.leetcode.design;

import com.zhao.leetcode.linked.Node;

import java.util.Map;
import java.util.TreeMap;

public class QueueMaxMap {

    Node head ;
    Node opeHead ;

    TreeMap<Integer,Integer> map = new TreeMap<>();

    public void push(int value) {
        if(head == null) {
            head = new Node(value);
            opeHead = head;
        } else {
            opeHead.next = new Node(value);
        }
        map.put(value,map.getOrDefault(value,0) + 1);
    }

    public int pop() {
        if(head == null) {
            throw new RuntimeException("此队列中无元素");
        }
        int value = head.val;
        int num = map.get(value);
        num = num == 0 ? map.remove(value) : map.put(value,num - 1);
        return value;
    }

    public int getMax() {
        if(head == null) {
            throw new RuntimeException("此队列中无元素");
        }
        return map.lastKey();
    }



}
