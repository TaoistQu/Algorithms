package cn.algorithms.sort;

import cn.algorithms.util.ArrayUtil;

/**
 * 测试冒泡排序时间复杂度 O(n^2)
 *
 * @author TaoistQu
 * @data 2020-07-27 00:00
 */
public class BubbleSort {
    public static void main(String[] args) {
        int testTime = 50000;
        int maxValue = 100;
        int maxSize = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = ArrayUtil.generateRandomArray(maxSize, maxValue);
            int[] arr2 = ArrayUtil.copyArray(arr1);
            bubbleSort(arr1);
            ArrayUtil.comparator(arr2);
            if (!ArrayUtil.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice" : "Fucking fucked!");
        int[] arr = ArrayUtil.generateRandomArray(maxSize, maxValue);
        ArrayUtil.printArray(arr);
        bubbleSort(arr);
        ArrayUtil.printArray(arr);
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int arr[]) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j]  >arr[j+1]) {
                    ArrayUtil.swap(arr, j, j + 1);
                }
            }
        }
       /* for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    ArrayUtil.swap(arr, i, i + 1);
                }
            }
        }*/
    }
}
