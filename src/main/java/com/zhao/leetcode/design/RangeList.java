package com.zhao.leetcode.design;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-05-14 11:07
 * @description
 **/
public class RangeList {
    List<List<Integer>> result = null;
    public RangeList() {
        result = new ArrayList<>();
    }
    public void add(List<Integer> list) {
        verParams(list);
        if (result.size() == 0) {
            result.add(list);
        }
        if (result.get(0).get(0) > list.get(1)) {
            result.add(0, list);
        }
        if (result.get(result.size() - 1).get(1) < list.get(0)) {
            result.add(list);
        }
        int start = getMid(list.get(0));
        int end = getMid(list.get(1));
/*        if (start == -1 && end == -1) {
            result.clear();
            result.add(list);
        }*/
        int minNum = list.get(0);
        if (start != -1) {
            List<Integer> minList = result.get(start);
            if (minList.get(1) >= minNum) {
                minNum = minList.get(0);
            } else {
                start ++;
            }
        } else {
            start = 0;
        }
        int maxNum = list.get(1);
        if (end != -1) {
            List<Integer> maxList = result.get(end);
            if (maxList.get(1) >= maxNum) {
                maxNum = maxList.get(1);
            }
        } else {
            end = result.size() - 1;
        }
        for (int i = start; i <= end; i ++) {
            result.remove(start);
        }
        result.add(start, this.getNewList(minNum, maxNum));
    }

    /**
     * 使用二分法找出目标值位置
     * 返回值为目标值位置
     * @param num
     * @return
     */
    public int getMid(int num) {
        int n = result.size() - 1, start = 0, end = n;
        if (num > result.get(n).get(1) || num < result.get(0).get(0)) {
            return -1;
        }
        if (result.get(end).get(0) <= num) {
            return end;
        }
        end --;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (result.get(mid).get(0) <= num && result.get(mid + 1).get(0) > num) {
                return mid;
            }
            if (result.get(mid).get(1) < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    private void verParams(List<Integer> list) {
        if (list == null || list.size() != 2 || list.get(0) > list.get(1)) {
            throw new RuntimeException("参数异常");
        }
    }

    public void remove(List<Integer> list) {
        verParams(list);
        if (result.get(0).get(0) > list.get(1)) {
            return;
        }
        if (result.get(result.size() - 1).get(1) < list.get(0)) {
            return;
        }
        int start = getMid(list.get(0));
        int end = getMid(list.get(1));
        int minNum = list.get(0);
        if (start != -1) {
            List<Integer> minList = result.get(start);
            if (minList.get(1) > minNum && minList.get(0) < minNum) {
                result.add(start, this.getNewList(minList.get(0), minNum));
                if (end != -1) {
                    end ++;
                }
                start ++;
            }

        } else {
            start = 0;
        }
        int maxNum = list.get(1);
        if (end != -1) {
            List<Integer> maxList = result.get(end);
            if (maxList.get(1) > maxNum) {
                result.add(end + 1, this.getNewList(maxNum, maxList.get(1)));
            } else {
//                end ++;
            }
        } else {
            end = result.size() - 1;
        }
        for (int i = start; i <= end; i ++) {
            result.remove(start);
        }
    }

    private List<Integer> getNewList(int min, int max) {
        List<Integer> result = new ArrayList<>();
        result.add(min);
        result.add(max);
        return result;
    }

    public void print() {
        if (result.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (List<Integer> list : result) {
            sb.append("[").append(list.get(0)).append(", ").append(list.get(1)).append(")").append(" ");
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }

    public static void main(String[] args) {
        RangeList rangeList = new RangeList();
        rangeList.add(rangeList.getNewList(1,3));
        rangeList.print();
        rangeList.add(rangeList.getNewList(6,9));
        rangeList.print();
        rangeList.add(rangeList.getNewList(4,5));
        rangeList.print();
        rangeList.add(rangeList.getNewList(3,4));
        rangeList.print();
        rangeList.remove(rangeList.getNewList(2,7));
        rangeList.print();
        rangeList.add(rangeList.getNewList(6, 8));
        rangeList.print();
        rangeList.remove(rangeList.getNewList(7,8));
        rangeList.print();
        rangeList.remove(rangeList.getNewList(6,9));
        rangeList.print();
        rangeList.add(rangeList.getNewList(100, 200));
        rangeList.print();
        rangeList.add(rangeList.getNewList(30, 80));
        rangeList.print();
        rangeList.add(rangeList.getNewList(1, 44));
        rangeList.print();
    }

}
