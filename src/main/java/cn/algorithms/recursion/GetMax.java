package cn.algorithms.recursion;

import cn.algorithms.util.ArrayUtil;

/**
 * 测试递归
 *
 * @author TaoistQu
 * @version 1.0
 * @date 2021/1/30 22:46
 */
public class GetMax {

    public static void main(String[] args) {
        int[] arr = ArrayUtil.generateRandomArray(30, 100);
        int max = getMax(arr);
        System.out.println(max);
    }

    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }
}
