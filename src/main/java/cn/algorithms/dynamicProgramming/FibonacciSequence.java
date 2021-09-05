package cn.algorithms.dynamicProgramming;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 斐波拉契数列
 * @Auther: TaoistQu
 * @Date: 2021/09/05/16:27
 */
public class FibonacciSequence {
    public static int f(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }

        return f(n - 1) + f(n - 2);
    }

    public static void main(String[] args) {
        int result = f(6);
        System.out.println(result);
    }
}
