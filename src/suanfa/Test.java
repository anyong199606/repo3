package suanfa;


import java.util.Random;
import java.util.UUID;

public class Test {
    public static void main(String[] args) {
        //时间复杂度，是计算排序的个数的平方
        //随机数目是n的，在rangeL和rangeR之间[rangeL,rangeR]
//        int[] ints = generateRandomArray(1000, 0, 10000);
        //进行选择排序
//        int[] ints1 = {7, 4, 0, 2, 6, 11, 44, 33, 77};
//        ints = insertionSort1(ints);
//        printArray(ints);
//        printArray(ints);
//        int[] ints2 = generateOrderArray(10, 2);
//        printArray(ints2);
        String s = UUID.randomUUID().toString();
        System.out.println(s);
    }

    private static boolean isSorted(int[] ints) {

        for (int i = 1; i < ints.length; i++)
            if (ints[i] < ints[i - 1])
                return false;

        return true;
    }

    //    private static int[] selectionSort(int[] ints) {
//
//        for (int i = 0; i < ints.length; i++) { // 5
//            int minIndex = i;
//            for (int j = i + 1; j < ints.length; j++) {//5 4 3 2 1
//                if (ints[j] < ints[minIndex]) {
//                    minIndex = j;
//                }
//            }
//            swap(ints, i, minIndex);
//        }
//
//        return ints;
//    }
    private static int[] selectionSort(int[] ints) {

        for (int i = 0; i < ints.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < ints.length; j++) {
                //就和设定的最小值比较
                if (ints[j] < ints[minIndex]) {
                    minIndex = j;
                }
            }
            swap(ints, i, minIndex);
        }
        return null;
    }

    public static int[] insertionSort(int[] ints) {
        for (int i = 1; i < ints.length; i++) {
            for (int j = i; j > 0 && ints[j] < ints[j - 1]; j--) {
                swap(ints, j, j - 1);
            }
        }
        return ints;
    }

    //性能版
    public static int[] insertionSort1(int[] ints) {
        for (int i = 1; i < ints.length; i++) {
            //定义一个变量保存新的值
            int temp = ints[i];
            int j;
            //能很快的终止内层循环,尤其是在有一定顺序的集合内进行排序
            for (j = i; j > 0 && temp < ints[j - 1]; j--) {
                ints[j] = ints[j - 1];
            }
            ints[j] = temp;
        }
        return ints;
    }

    //性能版
    public static void insertionSort(int[] ints, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            //定义一个变量保存新的值
            int temp = ints[i];
            int j;
            //能很快的终止内层循环,尤其是在有一定顺序的集合内进行排序
            for (j = i; j > l && ints[j - 1] > temp; j--) {
                ints[j] = ints[j - 1];
            }
            ints[j] = temp;
        }
    }

    //三次的数据交换
    public static void swap(int[] array, int i, int minIndex) {
        int temp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = temp;
    }

    public static int[] generateRandomArray(int n, int rangeL, int rangeR) {
        int[] ints = new int[n];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < n; i++) {
            ints[i] = Math.abs(random.nextInt() % (rangeR - rangeL + 1)) + rangeL;
        }
        return ints;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }

    public static int[] generateOrderArray(int n, int swapTimes) {
        Random random = new Random(System.currentTimeMillis());
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = i;
        }
        for (int i = 0; i < swapTimes; i++) {
            int index1 = Math.abs(random.nextInt() % n);
            int index2 = Math.abs(random.nextInt() % n);
            swap(ints, index1, index2);
        }
        return ints;
    }


}
