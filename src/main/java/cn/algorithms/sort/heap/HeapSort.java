package cn.algorithms.sort.heap;

import cn.algorithms.util.ArrayUtil;
import cn.dataStructures.heap.util.HeapUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Auther: TaoistQu
 * @Date: 2021/05/16/17:30
 */
public class HeapSort {
    /**
     * 使用从上到下的形式创建大根堆
     *
     * @param arr 要排序数组
     */
    public static void heapTopSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            HeapUtil.heapInsert(arr, i);
        }
        int heapSize = arr.length;
        ArrayUtil.swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            HeapUtil.heapify(arr, 0, heapSize);
            ArrayUtil.swap(arr, 0, --heapSize);
        }
    }

    /**
     * 使用从下至上的形式创建堆 可以减少创建堆的时间复杂度
     *
     * @param arr
     */
    public static void heapBottom(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            HeapUtil.heapify(arr, i, arr.length);
        }
        int heapSize = arr.length;
        ArrayUtil.swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            HeapUtil.heapify(arr, 0, heapSize);
            ArrayUtil.swap(arr, 0, --heapSize);
        }
    }
}
