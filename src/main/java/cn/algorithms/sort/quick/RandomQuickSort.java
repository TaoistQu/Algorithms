package cn.algorithms.sort.quick;

import cn.algorithms.util.ArrayUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:用荷兰国旗实现随机快排，减少时间复杂度
 * @Auther: TaoistQu
 * @Date: 2021/04/18/23:17
 */
public class RandomQuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L >= R) return;
        ArrayUtil.swap(arr, R, L + (int) (Math.random() * (R - L + 1)));
        int[] equalArea = NetherLandsFlag.netherlandsFlag(arr, L, R);
        process(arr, L, equalArea[0] - 1);
        process(arr, equalArea[1] + 1, R);
    }
}
