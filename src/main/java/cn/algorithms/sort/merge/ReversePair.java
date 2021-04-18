package cn.algorithms.sort.merge;

import cn.algorithms.util.ArrayUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 求一个数组中的逆序对 当一个数组中右边的数比左边的数小时就构成一个逆序对
 *
 * @Auther: TaoistQu
 * @Date: 2021/04/18/0:16
 */
public class ReversePair {
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("开始测试！！!");
        for (int i = 0; i < testTime; i++) {

            int[] arr1 = ArrayUtil.generateRandomArray(maxSize, maxValue);
            int[] arr2 = ArrayUtil.copyArray(arr1);

            if (reversePairs(arr1) != comparator(arr2)) {
                System.out.println("Oops!");
                ArrayUtil.printArray(arr1);
                ArrayUtil.printArray(arr2);
                break;
            }
        }
        System.out.println("测试完成！！！");
    }

    public static int reversePairs(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = help.length - 1;
        int p1 = m;
        int p2 = r;
        int res = 0;
        while (p1 >= l && p2 > m) {
            res += arr[p1] > arr[p2] ? (p2 - m) : 0;
            help[i--] = arr[p1] > arr[p2] ? arr[p1--] : arr[p2--];
        }
        while (p1 >= l) {
            help[i--] = arr[p1--];
        }
        while (p2 > m)
            help[i--] = arr[p2--];
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return res;
    }

    public static int comparator(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) ans++;
            }
        }
        return ans;
    }

}
