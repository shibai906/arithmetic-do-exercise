package com.zhao.arithmetic.lianbiao.reverse;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-03-25 13:32
 **/
public class TestLa {

    public static void main(String[] args) {
        Node head=new Node(1);
        Node node=new Node(2);
        head.next=node;
        Node pre=node;
        node=new Node(3);
        pre.next=node;
        pre=node;
        node=new Node(4);
        pre.next=node;
        pre=node;
        node=new Node(5);
        pre.next=node;
        pre=node;
        Node tail=node;
        reverse(null,head);
        while (tail!=null){
            System.out.println(tail.val);
            tail=tail.next;
        }
    }

    private static Node reverse(Node pre,Node cur){
        if(cur.next==null){
            cur.next=pre;
            pre.next=null;
            return pre;
        }
        Node tail=reverse(cur,cur.next);
        tail.next=pre;
        if(pre!=null){
            pre.next=null;
        }
        return pre;
    }


}
class Node{
    public Node next;
    public int val;

    public Node(int Val){
        this.val=Val;
    }
}
