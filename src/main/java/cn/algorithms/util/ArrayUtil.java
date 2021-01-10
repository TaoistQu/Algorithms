package cn.algorithms.util;

import java.util.Arrays;

/**
 * @author TaoistQu
 * @data 2020-07-27 00:10
 */
public class ArrayUtil {
    /**
     * 交换数组两位置上的值 (这个地方有个坑，必须要两个数不相等才行)
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        /*arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];*/
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * 随机生成随机长度，随机值的数组
     * <p>
     * 对数器
     * <p>
     * 1，你想要测的方法a
     * 2，实现复杂度不好但是容易实现的方法b
     * 3，实现一个随机样本产生器
     * 4，把方法a和方法b跑相同的随机样本，看看得到的结果是否一样
     * 5，如果有一个随机样本使得比对结果不一致，打印样本进行人工干预，改对方法a和方法b
     * 6，当样本数量很多时比对测试依然正确，可以确定方法a已经正确。
     *
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        //Math.random() -> [0,1)
        //Math.random()*N ->[0,N)
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) ||
                (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
