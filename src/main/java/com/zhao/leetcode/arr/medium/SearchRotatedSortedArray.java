package com.zhao.leetcode.arr.medium;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-06-24 11:43
 * @description SpinMin 题的升级版
 * 题目： Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *      (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *      You are given a target value to search. If found in the array return its index, otherwise return -1.
 *      You may assume no duplicate exists in the array.
 * 难点： 在于判断，左右界线判断特别复杂
 **/
public class SearchRotatedSortedArray {

    public static void main(String[] args) {
        int arr[] = { 4 , 5 , 6 , 7 , 8, 0 , 1 , 2};
        SearchRotatedSortedArray sortedArray = new SearchRotatedSortedArray();
        System.out.println(sortedArray.search(arr,0));
    }

    public int search(int arr[], int target) {
        if(arr == null || arr.length == 0) {
            return -1;
        }
        int min = 0 , max = arr.length - 1;
        int mid = (max + min) / 2;
        if(arr[mid] == target){
            return mid;
        }
        while ( max > min) {
            if(arr[mid] > arr[max]) {
                if(arr[max] < arr[min] && arr[max] >= target) {
                    min = mid + 1;
                } else {
                    max = mid ;
                }
            }
            if(arr[mid] < arr[max]) {
                if(arr[mid] < target) {
                    min = mid + 1 ;
                } else if(target > arr[max]) {
                    return -1;
                } else {
                    max = mid;
                }

            }
            mid = (max + min) /2 ;
            if(arr[mid] == target){
                return mid;
            }
        }
        return arr[mid];
    }

}
