package com.zhao.leetcode.bisai.bi148;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


/**
 * 实现支持下列接口的「快照数组」- SnapshotArray：
 *
 * SnapshotArray(int length) - 初始化一个与指定长度相等的 类数组 的数据结构。初始时，每个元素都等于 0。
 * void set(index, val) - 会将指定索引 index 处的元素设置为 val。
 * int snap() - 获取该数组的快照，并返回快照的编号 snap_id（快照号是调用 snap() 的总次数减去 1）。
 * int get(index, snap_id) - 根据指定的 snap_id 选择快照，并返回该快照指定索引 index 的值。
 */
public class SnapshotArray {


    List<TreeMap<Integer, Integer>> list = new ArrayList<>();
    int version = 0;
    public SnapshotArray(int length) {
        for(int i = 0 ; i < length ; i ++) {
            TreeMap<Integer,Integer> treeMap = new TreeMap<>();
            treeMap.put(version,0);
            list.add(treeMap);
        }
    }

    public void set(int index, int val) {
        list.get(index).put(version,val);
    }

    public int snap() {
        return version ++ ;
    }

    public int get(int index, int snap_id) {
        return list.get(index).floorEntry(snap_id).getValue();
    }



    /*List<TreeMap<Integer, Integer>> list = new ArrayList<>();
    int version = 0;

    public SnapshotArray(int length) {
        version = 0;
        for (int i = 0; i < length; i++) {
            TreeMap<Integer, Integer> t = new TreeMap<>();
            t.put(version, 0);
            list.add(t);
        }
    }

    public void set(int index, int val) {
        list.get(index).put(version, val);
    }

    public int snap() {
        int res = version;
        version ++;
        return res;
    }

    public int get(int index, int snap_id) {
        TreeMap<Integer, Integer> t = list.get(index);
        return t.floorEntry(snap_id).getValue();
    }*/

}
