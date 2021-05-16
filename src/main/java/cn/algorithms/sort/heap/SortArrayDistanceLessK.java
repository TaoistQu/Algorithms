package cn.algorithms.sort.heap;

import cn.algorithms.util.ArrayUtil;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 利用小根堆对一个局部有序数组排序，即元素移动距离不会大于k
 * @Auther: TaoistQu
 * @Date: 2021/05/16/23:00
 */
public class SortArrayDistanceLessK {
    /**
     * @param arr
     * @param k
     */
    public static void sortArrayDistanceLessK(int[] arr, int k) {
        if (k == 0) return;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        //先将k范围以内的元素加入到小根堆中
        for (; index <= Math.min(arr.length - 1, k - 1); index++) {
            heap.add(arr[index]);
        }
        //将k以后的元素加入到小根堆中，并将堆顶元素依次弹出到数组中
        int i = 0;
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        //将剩余的全弹回数组
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }

    //for test
    public static void comparator(int[] arr, int k) {
        Arrays.sort(arr);
    }

    public static int[] randomArrayNoMoveMoreK(int maxSize, int maxValue, int k) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
        }
        Arrays.sort(arr);
        boolean[] isSwap = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int j = Math.min(i + (int) (Math.random() * (k + 1)), arr.length - 1);
            if (!isSwap[i] && !isSwap[j]) {
                isSwap[i] = true;
                isSwap[j] = true;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println("test begin");
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int k = (int) (Math.random() * maxSize) + 1;
            int[] arr = randomArrayNoMoveMoreK(maxSize, maxValue, k);
            int[] arr1 = ArrayUtil.copyArray(arr);
            int[] arr2 = ArrayUtil.copyArray(arr);
            sortArrayDistanceLessK(arr1, k);
            comparator(arr2, k);
            if (!ArrayUtil.isEqual(arr1, arr2)) {
                succeed = false;
                System.out.println("K : " + k);
                ArrayUtil.printArray(arr);
                ArrayUtil.printArray(arr1);
                ArrayUtil.printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
