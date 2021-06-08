package cn.bit;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Auther: TaoistQu
 * @Date: 2021/06/09/0:51
 */
public class BitMap {
    private long[] bits;

    public BitMap(int max) {
        //需要多一个数 >>64 相当于除64
        bits = new long[(max + 64) >> 6];
    }

    public void add(int num) {
        bits[num >> 6] |= (1l << (num & 63));
    }

    public void delete(int num) {
        bits[num >> 6] &= ~(1l << (num & 63));
    }

    public boolean contains(int num) {
        return (bits[num >> 6] & (1l << (num & 63))) != 0;
    }

    public static void main(String[] args) {
        System.out.println("测试开始！");
        int max = 10000;
        BitMap bitMap = new BitMap(max);
        HashSet<Integer> set = new HashSet<>();
        int testTime = 10000000;
        for (int i = 0; i < testTime; i++) {
            int num = (int) (Math.random() * (max + 1));
            double decide = Math.random();
            if (decide < 0.333) {
                bitMap.add(num);
                set.add(num);
            } else if (decide < 0.666) {
                bitMap.delete(num);
                set.remove(num);
            } else {
                if (bitMap.contains(num) != set.contains(num)) {
                    System.out.println("Oops!");
                    break;
                }
            }
        }
        for (int num = 0; num <= max; num++) {
            if (bitMap.contains(num) != set.contains(num)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");
    }
}
