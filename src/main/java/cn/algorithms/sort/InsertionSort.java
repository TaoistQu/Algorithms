package cn.algorithms.sort;

import cn.algorithms.util.ArrayUtil;

/**
 * 插入排序
 * @author TaoistQu
 * @version 1.0
 * @date 2021/1/13 23:17
 */
public class InsertionSort {
    /**
     *
     * @param arr 要排序数组
     */
    public static void insertionSort(int[] arr){
        if(arr == null || arr.length<2){
            return;
        }
        for(int i = 1;i <arr.length;i++){ //保证0~i上有序
            for (int j = i-1;j >= 0 && arr[j] >arr[j+1];j--){ //确保从0~i位置上交换后还要有序
                ArrayUtil.swap(arr,j,j+1);
            }
        }
    }
}
