package cn.bit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 位运算实现 加减乘除
 * @Auther: TaoistQu
 * @Date: 2021/06/09/1:22
 */
public class BitAddMinusMultiDiv {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;
        //int sum = bitAdd(3, 5);

        int minus = bitMinus(a, a);
        System.out.println(minus);
    }

    /**
     * 二进制的加法，将数的无进位信息加上进位信息
     *
     * @param a
     * @param b
     * @return
     */
    public static int bitAdd(int a, int b) {
        int sum = 0;
        while (b != 0) {
            sum = a ^ b;   //a与b无进位相加的信息
            b = (a & b) << 1; //进位信息
            a = sum;
        }
        return sum;
    }

    public static int bitMinus(int a, int b) {
        return bitAdd(a, negNum(b));
    }

    public static int negNum(int n) {
        return bitAdd(~n, 1);
    }

    /**
     * 二进制实现乘法
     *
     * @param a
     * @param b
     * @return
     */
    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = bitAdd(res, a);
            }
            a <<= 1;
            b >>>= 1;  //无符号右移，为了避免补符号位的 “1”
        }
        return res;
    }

    /**
     * 计算一般的除法运算
     *
     * @param a
     * @param b
     * @return 返回除的结果
     */
    public static int div(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 30; i >= 0; i = bitMinus(i, 1)) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = bitMinus(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    public static int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        } else if (a == Integer.MIN_VALUE) {
            if (b == negNum(1)) {
                return Integer.MAX_VALUE;
            } else {
                int c = div(bitAdd(a, 1), b);
                return bitAdd(c, div(bitMinus(a, multi(c, b)), b));
            }
        } else {
            return div(a, b);
        }
    }

    public static boolean isNeg(int a) {
        return a < 0;
    }
}
