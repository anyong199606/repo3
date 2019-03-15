package mergeSort;


import suanfa.Test;

import java.util.Date;

public class M {

    public static void main(String[] args) {
        //20
        //16
        System.out.println("归并排序");
        int[] ints = Test.generateRandomArray(100000000, 0, 300000000);
        M m = new M();
        System.out.println("开始时间:" + new Date());
        m.mergeSort(ints);
        System.out.println("结束时间:" + new Date());
//        System.out.println("插入排序");
//        System.out.println("开始时间:" + new Date());
//        ints = Test.generateRandomArray(1000000, 0, 1000000);
//        Test.insertionSort1(ints);
//        System.out.println("结束时间:" + new Date());
    }

    /**
     * 用户调用的方法
     */
    public void mergeSort(int[] arr) {
        mergeSort(arr, arr.length - 1);
    }

    private void mergeSort(int[] arr, int n) {
        mergeSort(arr, 0, n);
    }

    /**
     * 进行数组的归并
     *
     * @param arr
     * @param l
     * @param r
     */
    private void mergeSort(int[] arr, int l, int r) {
//        if (l >= r)
//            return;
        if (r - l  <=15){
            Test.insertionSort(arr,l,r);
            return;
        }
        //取到每次的重点
        int mid = (l + r) / 2;
        //递归左边的数组数据
        mergeSort(arr, l, mid);
        //递归右边的数组数据
        mergeSort(arr, mid + 1, r);
        //如果arr[mid] > arr[mid + 1],(l r区间为2)当数组被切分只有一个数据的时候,那么会把两两进行排序
        //(l r区间为4)这里的mid就是第一次被切分成一个数据的时候两个分割数组的中点A,B(这两个数组的值是排好序的)
        //如果arr[mid] > arr[mid + 1]说明分B数组的值比A数组的值大,需要进行排序,如果不是,那么就跳过
        if (arr[mid] > arr[mid + 1])
            //进行数组的排序
            merge(arr, l, mid, r);
    }

    private void merge(int[] arr, int l, int mid, int r) {
        //先创建出这次截取的数组的长度
        int[] tempArr = new int[r - l + 1];
        //存下l,r区间范围内的arr数组的数据
        for (int i = l; i <= r; i++) {
            tempArr[i - l] = arr[i];
        }
        //进行排序
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {

            if (i > mid) {
                arr[k] = tempArr[j - l];
                j++;
            } else if (j > r) {
                arr[k] = tempArr[i - l];
                i++;
            } else if (tempArr[i - l] < tempArr[j - l]) {
                arr[k] = tempArr[i - l];
                i++;
            } else {
                arr[k] = tempArr[j - l];
                j++;
            }

        }
    }

}
