package cn.algorithms.sort.merge;

import cn.algorithms.util.ArrayUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 计算数组中比右边大两倍的数的个数
 * https://leetcode.com/problems/reverse-pairs/
 * @Auther: TaoistQu
 * @Date: 2021/04/18/14:03
 */
public class BiggerThanRightTwice {
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("开始测试！！!");

        for (int i = 0; i < testTime; i++) {
            int[] arr1 = ArrayUtil.generateRandomArray(maxSize, maxValue);
            int[] arr2 = ArrayUtil.copyArray(arr1);
            if (biggerThanRightTwice(arr1) != comparator(arr2)) {
                ArrayUtil.printArray(arr1);
                System.out.println("Oops!");
                break;
            }
        }
        System.out.println("测试完成！！！");
      int[] test=  new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        int i = biggerThanRightTwice(test);
        System.out.println("i="+i);
    }

    public static int biggerThanRightTwice(int[] arr) {
        if (arr == null || arr.length < 2) return 0;
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int l, int r) {
        if (l == r) return 0;
        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int m, int r) {
        int ans = 0;
        int widowR = m + 1;
        //通过索引下标计数
        for (int i = l; i <= m; i++) {
            while ((widowR <= r) &&( arr[i] > ((long)arr[widowR] <<1))) {
                widowR++;
            }
            ans += widowR - m - 1;
        }
        int help[] = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r)
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        while (p1 <= m)
            help[i++] = arr[p1++];
        while (p2 <= r)
            help[i++] = arr[p2++];
        for (i = 0; i <help.length; i++) {
            arr[i + l] = help[i];
        }
        return ans;
    }

    public static int comparator(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > (arr[j] << 1)) ans++;
            }
        }
        return ans;
    }
}
