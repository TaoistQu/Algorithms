package cn.algorithms.sort;

import cn.algorithms.util.ArrayUtil;

/**
 * 测试冒泡排序时间复杂度 O(n^2)
 *
 * @author TaoistQu
 * @data 2020-07-27 00:00
 */
public class BubbleSort {
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
    }
}
