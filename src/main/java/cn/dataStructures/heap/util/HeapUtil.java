package cn.dataStructures.heap.util;

import cn.algorithms.util.ArrayUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Auther: TaoistQu
 * @Date: 2021/05/16/17:25
 */
public class HeapUtil {
    /**
     * @param arr
     * @param index 给定的要插入的索引位置
     */
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[((index - 1) / 2)]) {
            ArrayUtil.swap(arr, index, (index - 1) / 2);
            index = (index - 1) >>> 1;
        }
    }

    /**
     * @param arr      堆数组
     * @param index    要开始modify的位置
     * @param heapSize 堆的大小
     */
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = (index << 1) + 1;
        while (left < heapSize) {
            int largest = (left + 1) < heapSize && arr[left + 1] > arr[left] ? (left + 1) : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            ArrayUtil.swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }
}
