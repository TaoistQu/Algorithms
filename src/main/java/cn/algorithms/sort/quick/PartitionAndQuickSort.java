package cn.algorithms.sort.quick;

import cn.algorithms.util.ArrayUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 用荷兰国旗问题解决快速排序
 * @Auther: TaoistQu
 * @Date: 2021/04/18/20:25
 */
public class PartitionAndQuickSort {

    /**
     * <= x  >x
     * 将数组中的元素按照以数组组后一元素为分界值进行划分，
     * 将小于等于最后值的划分在左边，大于最后值的划分在右边
     *
     * @param arr 要被划分的数组
     * @param L   左边区域
     * @param R   右边区域
     * @return 返回小于等于右边界索引
     */
    public static int partition(int[] arr, int L, int R) {
        if (L > R) return -1;
        if (L == R) return L;
        int lessEqual = L - 1;
        int index = L;
        while (index < R) {
            if (arr[index] <= arr[R]) {
                ArrayUtil.swap(arr, index, ++lessEqual);
            }
            index++;
        }
        ArrayUtil.swap(arr, ++lessEqual, R);
        return lessEqual;
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        process(arr, 0, arr.length - 1);
    }
    public static void process(int[] arr,int L,int R){
        if(L >=R) return;
        int m= partition(arr,L,R);
        process(arr,L,m-1);
        process(arr,m+1,R);
    }
}
