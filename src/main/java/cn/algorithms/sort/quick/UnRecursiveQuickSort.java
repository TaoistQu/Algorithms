package cn.algorithms.sort.quick;

import cn.algorithms.util.ArrayUtil;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Auther: TaoistQu
 * @Date: 2021/04/18/23:33
 */
public class UnRecursiveQuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int N = arr.length;
        ArrayUtil.swap(arr, (int) (Math.random() * N), N - 1);
        int[] equalArea = NetherLandsFlag.netherlandsFlag(arr, 0, N - 1);
        int el = equalArea[0];
        int er = equalArea[1];
        Stack<Op> stack = new Stack<>();
        stack.push(new Op(0, el - 1));
        stack.push(new Op(er + 1, N - 1));
        while (!stack.isEmpty()) {
            Op op = stack.pop();
            if (op.l < op.r) {
                ArrayUtil.swap(arr, op.l + (int) (Math.random() * (op.r - op.l + 1)), op.r);
                equalArea = NetherLandsFlag.netherlandsFlag(arr, op.l, op.r);
                el = equalArea[0];
                er = equalArea[1];
                stack.push(new Op(op.l, el - 1));
                stack.push(new Op(er + 1, op.r));
            }
        }
    }

    public static class Op {
        public int l;
        public int r;

        public Op(int left, int right) {
            l = left;
            r = right;
        }
    }
}
