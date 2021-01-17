package cn.algorithms.xor;

import cn.algorithms.util.ArrayUtil;
import cn.algorithms.util.NumberUtil;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 如果一个数组中其他数都出现M次，这个数出现k次返回该数，不出现k次返回-1
 * 且满足 M >1 ,K < M
 * 找出，出现K次的数
 * 要求，额外空间复杂度O(1),时间复杂度O(N)
 *
 * @author TaoistQu
 * @version 1.0
 * @date 2021/1/17 23:19
 */
public class GetNumNotKM {
    public static void main(String[] args) {
        int kinds = 10;
        int range = 200;
        int testTime = 1000000;
        int max = 9;
        System.out.println("测试开始！！！");
        for (int i = 0; i < testTime; i++) {
            int a = (int) (Math.random() * max) + 1;
            int b = (int) (Math.random() * max) + 1;
            int k = Math.min(a, b);
            int m = Math.max(a, b);
            if (k == m) {
                m++;
            }
            int[] arr = randomArray(kinds, range, k, m);
            int ans1 = test(arr, k, m);
            int ans2 = onlyKTimes(arr, k, m);
            if (ans1 != ans2) {
                System.out.println("出错啦！！!");
            }
        }
        System.out.println("测试结束！！！");
    }

    /**
     * 如果一个数组中其他数都出现M次，这个数出现k次返回该数，不出现k次返回-1
     * * 且满足 M >1 ,K < M
     * * 找出，出现K次的数
     *
     * @param arr 给定数组
     * @param k   出现k次的
     * @param m   其余数出现的次数
     * @return 出现k次的那个数
     */
    public static int onlyKTimes(int[] arr, int k, int m) {
        int[] t = new int[32];
        //t[0] 0位置的1出现了几个
        //t[1] 1位置的1出现了几个
        for (int num : arr) {
            for (int i = 0; i < t.length; i++) {
                t[i] += (num >> i) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < t.length; i++) {
            if (t[i] % m == 0) {
                continue;
            }
            if (t[i] % m == k) {
                ans |= (1 << i);
            } else {
                return -1;
            }
        }

        if (ans == 0) {
            int count = 0;
            for (int num : arr) {
                if (num == 0) {
                    count++;
                }
            }
            if (count != k) {
                return -1;
            }
        }


        return ans;
    }

    /**
     * 对数器
     *
     * @param arr
     * @param k
     * @param m
     * @return
     */
    public static int test(int[] arr, int k, int m) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int num : map.keySet()) {
            if (map.get(num) == k) {
                return num;
            }
        }
        return -1;
    }

    public static int[] randomArray(int maxKinds, int range, int k, int m) {
        int kTimeNum = NumberUtil.randomValue(range);
        //真名天子出现的次数
        int times = Math.random() < 0.5 ? k : ((int) (Math.random() * (m - 1)));
        //2
        int numKinds = (int) (Math.random() * maxKinds) + 2;
        int[] arr = new int[times + (numKinds - 1) * m];
        int index = 0;
        for (; index < times; index++) {
            arr[index] = kTimeNum;
        }
        numKinds--;
        HashSet<Integer> set = new HashSet<>();
        set.add(kTimeNum);
        while (numKinds != 0) {
            int currNum = 0;
            do {
                currNum = NumberUtil.randomValue(range);
            } while (set.contains(currNum));
            set.add(currNum);
            numKinds--;
            for (int i = 0; i < m; i++) {
                arr[index++] = currNum;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            ArrayUtil.swap(arr, i, (int) (Math.random() * arr.length));
        }
        return arr;
    }
}
