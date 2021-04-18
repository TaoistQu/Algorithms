package cn.algorithms.sort.quick;

import cn.algorithms.util.ArrayUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Auther: TaoistQu
 * @Date: 2021/04/18/23:01
 */
public class NetherlandsFlagQuickSort {
    /**
     * @param arr
     * @param L
     * @param R
     * @return 返回相等数组的左右边界索引数组
     */
    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L > R) return new int[]{-1, -1};
        if (L == R) return new int[]{L, R};
        int less = L - 1;
        int more = R;
        int index = L;
        while (index < more) {
            if (arr[index] == arr[R])
                index++;
            else if (arr[index] < arr[R]) {
                ArrayUtil.swap(arr, index++, ++less);
            } else ArrayUtil.swap(arr, index, --more);
        }
        ArrayUtil.swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        process(arr,0,arr.length-1);
    }

    public static void process(int[] arr,int L,int R){
        if(L >= R) return;
        int[] equalArea = netherlandsFlag(arr,L,R);
        process(arr, L, equalArea[0] - 1);
        process(arr, equalArea[1] + 1, R);
    }
}
