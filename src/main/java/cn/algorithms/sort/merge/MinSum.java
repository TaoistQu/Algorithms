package cn.algorithms.sort.merge;

import cn.algorithms.util.ArrayUtil;

/**
 * 求小和
 * 求数组中每一个数右边有多少个数比它大
 *
 * @author TaoistQu
 * @version 1.0
 * @date 2021/4/17 20:48
 */
public class MinSum {
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for(int i =0;i<testTime;i++){
            int [] arr1 = ArrayUtil.generateRandomArray(maxSize,maxValue);
            int [] arr2 = ArrayUtil.copyArray(arr1);
            if(smallSum(arr1) != comparator(arr2)){
                succeed =false;
                ArrayUtil.printArray(arr1);
                ArrayUtil.printArray(arr2);
                break;
            }
        }
        System.out.println(succeed?"Nice!":"Fucking fucked");
    }

    /**
     * 核心方法
     *
     * @param arr
     * @return
     */
    public static int smallSum(int arr[]) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int arr[], int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    public static int merge(int arr[], int l, int m, int r) {
        int help[] = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        int res = 0;
        while (p1 <= m && p2 <= r) {
            res += arr[p1] < arr[p2] ? arr[p1] * (r - p2 + 1) : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l+i] = help[i];
        }
        return res;
    }

    /**
     * 用于测试
     * @param arr
     * @return
     */
    public static int comparator(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                res += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return res;
    }

}
