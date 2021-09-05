package cn.algorithms.sort;

import cn.algorithms.sort.heap.HeapSort;
import cn.algorithms.sort.radix.CountSort;
import cn.algorithms.sort.radix.RadixSort;
import cn.algorithms.util.ArrayUtil;

/**
 * 测试各种排序算法
 *
 * @author TaoistQu
 * @version 1.0
 * @date 2021/1/13 23:09
 */
public class TestSort {
    public static void main(String[] args) {
        int testTime = 500000;
        int maxValue = 100000;
        int maxSize = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            // int[] arr1 = ArrayUtil.generateRandomArray(maxSize, maxValue);
            int[] arr1 = ArrayUtil.generatePositiveRandomArray(maxSize, maxValue);
            int[] arr2 = ArrayUtil.copyArray(arr1);
            // BubbleSort.bubbleSort(arr1);
            // SelectionSort.selectionSort(arr1);
            //InsertionSort.insertionSort(arr1);
            //MergeSort.mergeSort1(arr1);
            //MergeSort.mergeSort2(arr1);
            // UnRecursiveQuickSort.quickSort(arr1);
            // HeapSort.heapBottom(arr1);
            //CountSort.countSort(arr1);
            RadixSort.radixSort(arr1);
            // HeapSort.heapTopSort(arr1);
            ArrayUtil.comparator(arr2);
            if (!ArrayUtil.isEqual(arr1, arr2)) {
                succeed = false;
                ArrayUtil.printArray(arr1);
                break;
            }
            if (i == testTime - 1)
                ArrayUtil.printArray(arr1);
        }
        System.out.println(succeed ? "Nice" : "Fucking fucked!");
    }
}
