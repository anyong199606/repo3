package mergeSort;


import suanfa.Test;

import java.util.Date;
import java.util.Random;

public class QuickSort {
    Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {

        System.out.println("快速排序");
        int[] ints = Test.generateOrderArray(20000, 0);
//        int[] ints = Test.generateRandomArray(50000000, 0, 50000000);
        QuickSort quickSort = new QuickSort();
        System.out.println("开始时间:" + new Date());
        quickSort.quickSort(ints);
        System.out.println("结束时间:" + new Date());

//        System.out.println("归并排序");
//        ints = Test.generateRandomArray(50000000, 0, 50000000);
//        M m = new M();
//        System.out.println("开始时间:" + new Date());
//        m.mergeSort(ints);
//        System.out.println("结束时间:" + new Date());
//
//        System.out.println("插入排序");
//        System.out.println("开始时间:" + new Date());
//        ints = Test.generateRandomArray(50000000, 0, 50000000);
//        Test.insertionSort1(ints);
//        System.out.println("结束时间:" + new Date());

    }

    public void quickSort(int[] arr) {
        quickSort(arr, arr.length);
    }

    private void quickSort(int[] arr, int length) {
        quickSort(arr, 0, length - 1);
    }

    //正式开始快排
    private void quickSort(int[] arr, int l, int r) {

        if (l >= r)
            return;
//        if (r - l <= 15) {
//            Test.insertionSort(arr, l, r);
//            return;
//        }

        int pos = partition2(arr, l, r);
        //递归左边
        quickSort(arr, l, pos - 1);
        //递归左边
        quickSort(arr, pos + 1, r);
    }

    private int partition2(int[] arr, int l, int r) {
        //先定义一个比较的值,一般是当前范围的第一个值
        //为了防止出现整个数组都是排好顺序的值，那么就要随机选择一个下标的数据
        int a = Math.abs(random.nextInt() % (r - l + 1)) + l;
        Test.swap(arr, a, l);
        int v = arr[l];

        //arr[L+1,i)<arr[L]    arr(j   r]>arr[L]
        int j = r;
        int i = l + 1;
        while (true) {
            while (i <= r && arr[i] < v) {
                i++;
            }
            while (j >= l + 1 && arr[j] > v) {
                j--;
            }
            if (i > j) break;
            //交换数据
            Test.swap(arr, i, j);
            i++;
            j--;
        }
        Test.swap(arr, l, j);
        return j;
    }

    private int partition(int[] arr, int l, int r) {
        //先定义一个比较的值,一般是当前范围的第一个值
        //为了防止出现整个数组都是排好顺序的值，那么就要随机选择一个下标的数据
//        int a = Math.abs(random.nextInt() % (r - l + 1)) + l;
//        Test.swap(arr, a, l);
        int v = arr[l];
        //arr[l+1    j]   arr[j+1     i) 在开始的时候都不能存在
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            //arr[i]比当前的v的值还要小，那么就要和j下一个下标的值交换位置，并且j++
            if (arr[i] < v) {
                Test.swap(arr, i, j + 1);
                j++;
            }
        }
        //交换 l 和 j下标所对应的值
        Test.swap(arr, l, j);
        return j;
    }

}
