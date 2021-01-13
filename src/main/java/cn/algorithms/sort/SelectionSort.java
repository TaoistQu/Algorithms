package cn.algorithms.sort;

import cn.algorithms.util.ArrayUtil;

/**
 * @author TaoistQu
 * @version 1.0
 * @date 2021/1/13 23:00
 */
public class SelectionSort {
    /**
     * 选择排序
     * // 0 ~ N-1  找到最小值，在哪，放到0位置上
     * 	// 1 ~ n-1  找到最小值，在哪，放到1 位置上
     * 	// 2 ~ n-1  找到最小值，在哪，放到2 位置上
     * @param arr
     */
    public static void selectionSort(int[] arr){
        if(arr == null || arr.length<2){
            return;
        }
        for(int i = 0;i<arr.length-1;i++){
            int minIndex =i;
            for(int j =i+1;j<arr.length;j++){
                minIndex = arr[j] <arr[minIndex] ? j : minIndex;
            }
            ArrayUtil.swap(arr,i,minIndex);
        }
    }
}
