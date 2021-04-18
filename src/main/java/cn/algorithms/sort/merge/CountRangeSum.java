package cn.algorithms.sort.merge;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 这道题直接在leetcode测评：
 * https://leetcode.com/problems/count-of-range-sum/
 * @Auther: TaoistQu
 * @Date: 2021/04/18/16:01
 */
public class CountRangeSum {
    public static int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) return 0;
        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        return process(sum, 0, sum.length - 1, lower, upper);
    }

    public static int process(long[] sum, int L, int r, int lower, int upper) {
        if (L == r) {
            return sum[L] >= lower && sum[r] <= upper ? 1 : 0;
        }
        int m = L + ((r - L) >> 1);
        return process(sum, L, m, lower, upper) + process(sum, m + 1, r, lower, upper)
                + merge(sum, L, m, r, lower, upper);
    }

    public static int merge(long[] sum, int L, int m, int r, int lower, int upper) {
        int ans = 0;
        int windowL = L;
        int windowR = L;
        for (int i = m + 1; i <= r; i++) {
            long min = sum[i] - upper;
            long max = sum[i] - lower;
            while (windowR <= m && sum[windowR] <= max)
                windowR++;
            while (windowL <= m && sum[windowL] < min)
                windowL++;
            ans += windowR - windowL;
        }
        long help[] = new long[r - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r)
            help[i++] = sum[p1] <= sum[p2] ? sum[p1++] : sum[p2++];
        while (p1 <= m)
            help[i++] = sum[p1++];
        while (p2 <= r)
            help[i++] = sum[p2++];
        for (i = 0; i < help.length; i++) {
            sum[L + i] = help[i];
        }
        return ans;
    }
}
