package com.zhao;


import java.util.Arrays;
import java.util.Map;

public class TestJava {


    public static void main(String[] args) {
        // nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        TestJava testJava = new TestJava();
        int arr[] = new int[]{1,2,3,0,0,0};
        testJava.merge(arr, 3, new int[]{2,5,6}, 3);

        System.out.println(Arrays.toString(arr));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (nums1 == null || nums2 == null) {
            return;
        }
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 != m + n || n2 != n) {
            throw new RuntimeException("输入有误");
        }
        int i =n1 - 1;
        for (;  m > 0 && n > 0; ) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[i --] = nums1[ --m];
            } else {
                nums1[i--] = nums2[--n];
            }
        }
        for (int j = m - 1; j >= 0; j --) {
            nums1[i --] = nums1[j];
        }
        for (int j = n - 1; j >= 0; j --) {
            nums1[i --] = nums2[n];
        }
    }




}



