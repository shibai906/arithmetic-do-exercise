package com.zhao.arithmetic.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSort {
    public static void main(String[] args) {

        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }

//		int[] arr = {4,6,2};

//		System.out.println(Math.pow(10, 3));
//		System.out.println(1001 % 100);
        // int[] arr = {4,2,3,6};
        // System.out.println((int)(102%(int)Math.pow(10, 3)/Math.pow(10, 2)));
        System.out.println(Arrays.toString(selectSort(arr)));

    }

    // 选择排序
    public static int[] selectSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    // 冒泡排序
    public static int[] bubblingSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    // 直接插入排序
    public static int[] directInterpositionSort(int[] arr) {

        int temp;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    System.arraycopy(arr, j, arr, j + 1, i - j);
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] myDirectInterpositionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[i];
                    // 注意下面这段代码，这里一定要着重计算
                    System.arraycopy(arr, j, arr, j + 1, i - j);
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    // 网上折半插入排序，简单明了
    public static int[] internetHalfInterpositionSort(int[] arr) {
        // 自己版
        int temp, min, max, mid;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            min = 0;
            max = i - 1;
            while (min <= max) {
                mid = (min + max) / 2;
                if (temp > arr[mid]) {
                    min = mid + 1;
                } else {
                    max = mid - 1;
                }
            }
            System.arraycopy(arr, min, arr, min + 1, i - min);
            arr[min] = temp;
        }

        /*
         * // 网络查找版 int n = a.length; int i,j; for(i=1;i<n;i++){ //
         * temp为本次循环待插入有序列表中的数 int temp = a[i]; int low=0; int high=i-1; //
         * 寻找temp插入有序列表的正确位置，使用二分查找法 while(low <= high){ //
         * 有序数组的中间坐标，此时用于二分查找，减少查找次数 int mid = (low+high)/2; //
         * 若有序数组的中间元素大于待排序元素，则有序序列向中间元素之前搜索，否则向后搜索 if(a[mid]>temp){ high =
         * mid-1; }else{ low = mid+1; } } // 元素后移，为插入temp做准备 System.arraycopy(a,
         * low, a, low + 1, i - low ); // 插入temp a[low] = temp; }
         */
        // 返回排序后的结果
        return arr;

    }

    public static int[] myInternetHalfInterpositionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int min = 0;
            int max = i - 1; // 这里有减一，下面操作是min，如果不减一，操作mid。牵扯到1的问题
            int mid = (max + min) / 2;
            while (min <= max) {
                mid = (max + min) / 2;
                if (arr[mid] > arr[i]) {
                    max = mid - 1;
                } else if (arr[mid] < arr[i]) {
                    min = mid + 1;
                } else {
                    break;
                }
            }
            System.arraycopy(arr, min, arr, min + 1, i - min);
            arr[min] = temp;
        }
        return arr;
    }

    // 自己折半插入排序 存在错误
    public static int[] halfInterpositionSort(int[] arr) {
        int temp = 0;
        int min;
        int max;
        int middle;
        if (arr[0] > arr[1]) {
            temp = arr[0];
            arr[0] = arr[1];
            arr[1] = temp;
        }
        for (int i = 2; i < arr.length; i++) {
            min = 0;
            max = i - 1;
            if (i % 2 == 0) {
                middle = (min + max) / 2;
                if (arr[i] >= arr[middle] && arr[i] <= arr[middle + 1]) {
                    temp = arr[i];
                    System.arraycopy(arr, middle + 1, arr, middle + 2, i - middle - 1);
                    arr[middle + 1] = temp;
                } else if (arr[i] < arr[middle]) {
                    if (middle <= min) {
                        temp = arr[i];
                        System.arraycopy(arr, min, arr, min + 1, i - min);
                        arr[min] = temp;
                    } else {
                        halfInterpositionSortRecursion(arr, middle, min, max, temp, i);
                    }
                } else if (arr[i] > arr[middle + 1]) {
                    if (middle + 1 >= max) {

                    } else {
                        halfInterpositionSortRecursion(arr, middle, middle + 1, max, temp, i);
                    }
                }
            } else {
                middle = (min + max) / 2;
                if (arr[middle] > arr[i] && arr[middle - 1] <= arr[i]) {
                    temp = arr[i];
                    System.arraycopy(arr, middle, arr, middle + 1, i - middle);
                    arr[middle] = temp;
                } else if (arr[middle] <= arr[i] && arr[middle + 1] >= arr[i]) {
                    temp = arr[i];
                    System.arraycopy(arr, middle + 1, arr, middle + 2, i - middle - 1);
                    arr[middle + 1] = temp;
                } else if (arr[i] < arr[middle - 1]) {
                    if (middle - 1 <= min) {
                        temp = arr[i];
                        System.arraycopy(arr, middle - 1, arr, middle, i - middle + 1);
                        arr[middle - 1] = temp;
                    } else {
                        halfInterpositionSortRecursion(arr, middle, min, middle - 1, temp, i);
                    }
                } else if (arr[i] > arr[middle + 1]) {
                    if (middle + 1 >= max) {
                    } else {
                        halfInterpositionSortRecursion(arr, middle, middle + 1, max, temp, i);
                    }
                }
            }
        }
        return arr;
    }

    // 折半插入自己写的递归方式，中间有错误
    private static void halfInterpositionSortRecursion(int[] arr, int middle, int min, int max, int temp, int i) {

        if ((i) % 2 == 0) {
            middle = (min + max) / 2;
            if (arr[i] >= arr[middle] && arr[i] <= arr[middle + 1]) {
                temp = arr[i];
                System.arraycopy(arr, middle + 1, arr, middle + 2, i - middle - 1);
                arr[middle + 1] = temp;

            } else if (arr[i] < arr[middle]) {
                if (middle <= min) {
                    temp = arr[i];
                    System.arraycopy(arr, min, arr, min + 1, i - min);
                    arr[min] = temp;

                } else {
                    halfInterpositionSortRecursion(arr, middle, min, middle, temp, i);
                }
            } else if (arr[i] > arr[middle + 1]) {
                if (middle + 1 >= max) {

                } else {
                    halfInterpositionSortRecursion(arr, middle, middle + 1, max, temp, i);
                }
            }
        } else {
            middle = (min + max) / 2;
            if (middle == 0) {
                if (arr[i] > arr[middle]) {
                    System.out.println(Arrays.toString(arr));
                    temp = arr[i];
                    System.arraycopy(arr, middle + 1, arr, middle + 2, i - middle - 1);
                    arr[middle + 1] = temp;
                } else {
                    temp = arr[i];
                    System.arraycopy(arr, 0, arr, 1, i);
                    arr[middle] = temp;
                }

            } else if (arr[middle] > arr[i] && arr[middle - 1] <= arr[i]) {
                temp = arr[i];
                System.arraycopy(arr, middle, arr, middle + 1, i - middle - 1);
                arr[middle] = temp;
                return;
            } else if (arr[middle] <= arr[i] && arr[middle + 1] >= arr[i]) {
                temp = arr[i];
                System.arraycopy(arr, middle + 1, arr, middle + 2, i - middle - 1);
                arr[middle + 1] = temp;
                return;
            } else if (arr[i] < arr[middle - 1]) {
                if (middle - 1 <= min) {
                    temp = arr[i];
                    System.arraycopy(arr, middle - 1, arr, middle, i - middle + 1);
                    arr[middle - 1] = temp;

                } else {
                    halfInterpositionSortRecursion(arr, middle, min, middle - 1, temp, i);
                }
            } else if (arr[i] > arr[middle + 1]) {
                if (middle + 1 >= max) {

                } else {
                    halfInterpositionSortRecursion(arr, middle, middle + 1, max, temp, i);
                }
            }
        }
    }

    public static int[] myMergerSort(int[] arr) {
        int min = 0;
        int max = arr.length - 1;
        myMergeSortRecursion(arr, min, max);
        return arr;

    }

    private static void myMergeSortRecursion(int[] arr, int min, int max) {
        if (min < max) {
            int mid = (min + max) / 2;
            myMergeSortRecursion(arr, min, mid);
            myMergeSortRecursion(arr, mid + 1, max);
            myMergeSortExchange(arr, min, mid, max);
        }
    }

    private static void myMergeSortExchange(int[] arr, int min, int mid, int max) {
        int temp[] = new int[max - min + 1]; // 这一这里，定义数组的时候，最大角标比数组长度小1
        int k = 0;
        int xiao = min;
        int da = mid + 1; // 注意这里，一定要加1
        while (xiao <= mid && da <= max) {
            if (arr[xiao] < arr[da]) {
                temp[k++] = arr[xiao++];
            } else
                temp[k++] = arr[da++];
        }
        for (int i = xiao; i <= mid; i++) {
            temp[k++] = arr[i];
        }
        for (int i = da; i <= max; i++) {
            temp[k++] = arr[da++];
        }
        System.arraycopy(temp, 0, arr, min, max - min + 1);
    }

    // 归并排序，就是分类
    public static int[] mergerSort(int[] arr) {

        int min = 0, max = arr.length - 1;
        mergeSortRecursion(arr, min, max);

        return arr;
    }

    // 这是归并排序中的递归算法
    private static void mergeSortRecursion(int[] arr, int min, int max) {

        int mid = 0;
        if (min < max) {
            mid = (min + max) / 2;
            mergeSortRecursion(arr, min, mid);
            mergeSortRecursion(arr, mid + 1, max);
            mergeSortExchange(arr, min, mid, max);
        }
    }

    // 这是归并排序中真真运算的地方
    private static void mergeSortExchange(int[] arr, int min, int mid, int max) {
        // 创建一个临时数组用来存储合并后的数据;
        int[] temp = new int[max - min + 1];

        int i = min;
        int j = mid + 1;
        int k = 0;

        // 处理这些判断的数，先把左面或者右面处理完
        while (i <= mid && j <= max) {
            if (arr[i] < arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }
        // 处理那些未处理完的部分
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= max) {
            temp[k++] = arr[j++];
        }
        // 把temp中的数值赋值到arr中
        System.arraycopy(temp, 0, arr, min, max - min + 1);

    }

    public static int[] myRadixSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int num = 1;
        while (max > 0) { // 注意这里如何创建，num的位数一定要获取正确
            max = max / 10;
            num++;
        }
        // 建立10个队列
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>(); // 这样建立List集合队列
        for(int i = 0 ; i < 10 ; i ++){  // 新建list集合加进去
            ArrayList<Integer> list = new ArrayList<>();
            lists.add(list);
        } // 字母比较多，一定要注意这里
        for(int i = 0 ; i < num ; i ++){
            for(int j = 0 ; j < arr.length ; j ++){  // 特别要注意这里，如何算出个十百的数，下面这个很简单
                int x = arr[j] % (int)Math.pow(10 , i + 1) / (int)Math.pow(10 , i);
                lists.get(x).add(arr[j]);
            }
            int count = 0;
            for(int z = 0 ; z < 10; z ++){
                ArrayList<Integer> l = lists.get(z);
                while(l.size() > 0){
                    arr[count++] = l.remove(0);
                }
            }
        }

        return arr;
    }

    // 基数排序
    public static int[] radixSort(int[] arr) {
        // 找到最大数，确定要排序几趟
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }
        // 判断位数
        int times = 0;
        while (max > 0) {
            max = max / 10;
            times++;
        }
        // 建立十个队列
        List<ArrayList<Integer>> alist = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> queue = new ArrayList<Integer>();
            alist.add(queue);
        }
        // arr[j] % (int) Math.pow(10, i+1) /(int)Math.pow(10, i); 可以求出不同位的余数

        // 进行times次分派和收集
        for (int i = 0; i < times; i++) {
            // 分配
            for (int j = 0; j < arr.length; j++) {
                int x = arr[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                alist.get(x).add(arr[j]);
            }
            // 从list集合中把数据取出来，存入到数组中
            int count = 0;
            for (int j = 0; j < 10; j++) {
                ArrayList<Integer> queue = alist.get(j);
                while (queue.size() > 0) {
                    arr[count++] = queue.remove(0);
                }
            }
        }
        return arr;
    }

    // 快速排序
    public static int[] rapidSort(int[] arr) {
        int start = 0, end = arr.length - 1;
        if (arr.length <= 1) {
            return arr;
        }
        quickSort(arr, start, end);
        return arr;
    }

    public static int[] myRapidSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        myQuickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void myQuickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int xiao = start;
        int da = end;
        while (xiao < da) {
            for (; da > xiao; da--) {
                if (arr[xiao] > arr[da]) {
                    swap(arr, da, xiao);
                    xiao++; // 这里就让少判断一次
                    break;
                }
            }
            for (; xiao < da; xiao++) {
                if (arr[da] < arr[xiao]) {
                    swap(arr, da, xiao);
                    da--; // 这里是为了配合元素
                    break;
                }
            }
        }
        myQuickSort(arr, start, xiao);
        myQuickSort(arr, xiao + 1, end);
    }

    // 快速排序递归方法
    private static void quickSort(int[] arr, int start, int end) {

        if (start == end) {
            return;
        }
        int i = start;
        int j = end;
        while (i < j) {
            for (; j > i; j--) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                    break;
                }
            }
            for (; i < j; i++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                    break;
                }
            }
        }
        quickSort(arr, start, i);
        quickSort(arr, i + 1, end);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    // 希尔排序
    /*
     * 它是一种插入排序的快速的排序算法，它采用的是交换不相邻元素以对数组的局部进行排序 并最终用插入排序将局部有序的数组排序。
     * 它的思想是使数组中任意间隔为h的元素都是有序的，这样的数组被称为h有序数组。
     * 一个h有序数组就是h个互相独立的有序数组编制在一起组成的一个数组，在进行排序时，如果h很大
     * ，我们就将元素移动到很远的地方，为实现更小的h有序创造方便。
     *
     */

    public static int[] myShellSrot(int[] arr) {
        int h = 1;
        // 这个数可以随便给,因为下面有个绝对排序在照看着程序。
        while (h * 3 < arr.length / 3)
            h = h * 3;
        while (h >= 1) {
            if (h == 1) { // 下面这些是为了保证最后一次彻底排序速度
                for (int i = 1; i < arr.length; i++) {
                    for (int j = 0; j < i; j++) {
                        if (arr[j] > arr[i]) {
                            int temp = arr[i];
                            System.arraycopy(arr, j, arr, j + 1, i - j);
                            arr[j] = temp;
                            break;
                        }
                    }
                }
            } else {
                for (int i = h; i < arr.length; i++) {
                    for (int j = i; j >= h && j < arr.length; j -= h) {
                        if (arr[j] < arr[j - h]) {
                            int temp = arr[j];
                            arr[j] = arr[j - h];
                            arr[j - h] = temp;
                        }
                    }
                }
            }
            h = h / 3;
        }
        return arr;
    }

    public static int[] shellSort(int[] arr) {
        int h = 1;
        // 按h * 3 + 1得到增量序列的最大值
        while (h * 3 + 1 < arr.length / 3)
            h = h * 3 + 1;
        // 进行增量查找和排序
        while (h >= 1) {
            for (int i = h; i < arr.length; i++) {
                for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h) {
                    int temp = arr[j];
                    arr[j] = arr[j - h];
                    arr[j - h] = temp;
                }
            }
            h = h / 3;
        }
        return arr;
    }

    // 堆排序
    /*
     * 其实先给层次排序，排成完全二叉树，大小固定，然后在取第一个往后面放
     */
    public static int[] pileSort(int[] arr) {

        myBuildMaxHeap(arr);
        return arr;
    }

    private static void myBuildMaxHeap(int[] arr) {
        // 记录最大值，等会要记录堆的长度
        int heapsize = arr.length;
        if (arr == null || arr.length == 1) {
            return;
        }
        // 然后先排一次序，让父元素都大于左右元素，特别要注意这里
        // 这里是从底层然后一步往高走的
        for (int i = heapsize / 2 - 1; i >= 0; i--) {
            myMaxify(arr, i, heapsize);
        }
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[0];
            arr[0] = arr[heapsize - 1];
            arr[heapsize - 1] = temp;
            heapsize--;
            // maxify(0,heapsize,arr);
            myMaxify(arr, 0, heapsize);
        }

    }

    private static void myMaxify(int[] arr, int i, int heapsize) {
        int left = Left(i);
        int right = Right(i);
        int parent = i;
        if (left >= heapsize) { // 如过left超了，一定没有right
            return;
        }
        if (arr[left] > arr[i]) {
            parent = left;
        }
        if (right < heapsize && arr[right] > arr[parent]) {
            parent = right; // 这个方法不能向上面哪样是因为判断了，有可能导致少执行一步
        }
        if (parent == i || parent >= heapsize) {
            return; // i的位置确定，就不用换
        }
        int temp = arr[parent];
        arr[parent] = arr[i];
        arr[i] = temp;
        myMaxify(arr, parent, heapsize); // 确保，每一层的父元素都最大，不是通过递归来能成一样的
    }

    private static void buildMaxHeap(int[] arr) {
        int heapsize = arr.length;
        for (int j = heapsize / 2 - 1; j >= 0; j--) {

            maxify(j, heapsize, arr);
        }
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[0];
            arr[0] = arr[heapsize - 1];
            arr[heapsize - 1] = temp;
            heapsize--;
            maxify(0, heapsize, arr);
        }

    }

    private static void maxify(int i, int heapsize, int[] heap) {

        int left = Left(i);
        int right = Right(i);
        int largest;
        if (left < heapsize && heap[left] > heap[i]) {
            largest = left;
        } else
            largest = i;
        if (right < heapsize && heap[right] > heap[largest])
            largest = right;
        if (largest == i || largest >= heapsize) {
            return;
        }
        int temp = heap[i];
        heap[i] = heap[largest];
        heap[largest] = temp;
        maxify(largest, heapsize, heap);
    }

    private static int Left(int i) {
        return 2 * (i + 1) - 1; // 因为是从零开始，进过判断就需要比一开始的要多加一个1
    }

    private static int Right(int i) {
        return 2 * (i + 1);
    }
}
