package com.zhao.leetcode.team;

/**
 * 地址： https://leetcode-cn.com/explore/learn/card/queue-stack/216/queue-first-in-first-out-data-structure/865/
 * 设计循环队列
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）
 * 原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，
 * 一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
 * 你的实现应该支持如下操作：
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 */
public class MyCircularQueue {
    int[] arr = null,opeArr = null;
    int size = 0,weizhi = 0 , opeSize = 0;


    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        arr = new int[k];
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (size < arr.length) {
            arr[size++] = value;
            return true;
        } else if( size - weizhi < arr.length) {
            if(opeArr == null) {
                opeArr = new int[arr.length];
                opeArr[opeSize ++] = value;
                return true;
            } else if(size - weizhi + opeSize < arr.length) {
                opeArr[opeSize ++] = value;
                return true;
            }
        }
        return false;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (weizhi == size && opeSize != 0) {
            arr = opeArr;
            opeArr = null;
            size = opeSize;
            opeSize = 0;
            weizhi = 1;
            return true;
        }
        if(weizhi < size) {
            weizhi ++ ;
            if(weizhi == size) {
                weizhi = 0;
                size = 0;
                if(opeArr != null) {
                    arr = opeArr;
                    size = opeSize;
                    opeArr = null;
                    opeSize = 0;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (size - weizhi > 0) {
            return arr[weizhi];
        }
        return -1;
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if(opeSize > 0) {
            return opeArr[opeSize - 1];
        }
        if(weizhi < size) {
            return arr[size - 1];
        }
        return -1;
    }
    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        if (size == weizhi) {
            return true;
        }
        return false;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        if (size - weizhi + opeSize == arr.length) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(2);
        queue.enQueue(4);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.Rear();
        queue.isFull();
        queue.deQueue();
        queue.enQueue(4);
        queue.Rear();
    }

}
