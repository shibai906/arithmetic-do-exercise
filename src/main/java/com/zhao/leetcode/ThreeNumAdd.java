package com.zhao.leetcode;

import java.util.ArrayList;


public class ThreeNumAdd {
    public static void main(String[] args) {

        threeSum(new int[]{0,0,0},2);
    }

    public static java.util.List<java.util.List<Integer>> threeSum(int[] nums) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        java.util.Set<Integer> jia = new java.util.HashSet<>();
        java.util.Set<Integer> jian = new java.util.HashSet<>();
        boolean flagLing = false;
        java.util.Set<Integer> chongfuJia = new java.util.HashSet<>();
        java.util.Set<Integer> chongfuJian = new java.util.HashSet<>();
        int lingjiShu = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                int num = jia.size();
                jia.add(nums[i]);
                if (jia.size() == num) {
                    chongfuJia.add(nums[i]);
                }
            } else if (nums[i] < 0) {
                int num = jian.size();
                jian.add(nums[i]);
                if (jian.size() == num) {
                    chongfuJian.add(nums[i]);
                }
            } else {
                lingjiShu++;
                flagLing = true;
            }
        }
        if (lingjiShu > 2) {
            result.add(setList(0, 0, 0));
        }
        Integer[] jianArr = new Integer[jian.size()];
        jianArr = jian.toArray(jianArr);
        Integer[] jiaArr = new Integer[jia.size()];
        jiaArr = jia.toArray(jiaArr);
        for (Integer numJia : jiaArr) {
            for (int i = 0; i < jianArr.length; i++) {
                if (numJia + jianArr[i] < 0) {
                    break;
                }
                if (numJia + jianArr[i] == 0) {
                    if (flagLing) {
                        result.add(setList(0, numJia, jianArr[i]));
                    }
                    break;
                }
                if (numJia % 2 == 0 && numJia >> 1 == -jianArr[i]) {
                    for (Integer chonJian : chongfuJian) {
                        if (jianArr[i] == chonJian) {
                            result.add(setList(numJia, chonJian, chonJian));
                            break;
                        }
                    }
                }
                for (int j = i + 1; j < jianArr.length; j++) {
                    if (numJia + jianArr[i] + jianArr[j] == 0) {
                        result.add(setList(numJia, jianArr[i], jianArr[j]));
                    }
                }
            }
        }

        for (Integer numJian : jianArr) {
            for (int i = 0; i < jiaArr.length; i++) {
                if (numJian % 2 == 0 && numJian >> 1 == -jiaArr[i]) {
                    for (Integer chongJia : chongfuJia) {
                        if (chongJia == jiaArr[i]) {
                            result.add(setList(chongJia, chongJia, numJian));
                            break;
                        }
                    }
                }
                for (int j = i + 1; j < jiaArr.length; j++) {
                    if (j == jiaArr.length) {
                        break;
                    }
                    if (numJian + jiaArr[i] + jiaArr[j] == 0) {
                        result.add(setList(numJian, jiaArr[i], jiaArr[j]));
                    }
                }
            }
        }

        return result;
    }

    public static java.util.List<Integer> setList(int num1, int num2, int num3) {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        list.add(num1);
        list.add(num2);
        list.add(num3);
        return list;
    }

    public static java.util.List<java.util.List<Integer>> threeSum(int[] nums, int nnnnnnnnn) {
        java.util.List<java.util.List<Integer>> list = new ArrayList<>();
        if(nums.length < 3) {
            return list;
        }
        java.util.Arrays.sort(nums);

        for(int i = 0 ; i < nums.length ; i ++) {
            if(nums.length - i < 3) {
                break;
            }
            if(nums[i] > 0) {
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1;
            while(l < r) {
                int num = nums[i] + nums[l] + nums[r] ;
                if(num == 0 ) {
                    list.add(java.util.Arrays.asList(nums[i],nums[l],nums[r]));
                    while (l < r && nums[l] == nums[l + 1] ) {
                        l ++ ;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r -- ;
                    }
                    l ++ ;
                    r -- ;
                } else if (num > 0) {
                    r -- ;
                } else {
                    l ++ ;
                }
            }
        }
        return list;

    }


}
