package cn.bit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Auther: TaoistQu
 * @Date: 2021/06/23/0:03
 */
public class BitOpt {
    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            int a = (int) (Math.random() * 20000) + 1;
            int b = (int) (Math.random() * 30000) + 1;
            int res = mult(a, b);
            if (res != (a * b)) {
                System.out.println("Oops!");
                break;
            }
        }
        System.out.println("Ok");

    }

    private static int mult(int a, int b) {
        int n = bits(a);
        int t = bits(b);
        int tmp = b;
        int[] res = new int[n + t];

        int w = 0;
        int c = 0;
        int x = 0;
        int y = 0;
        int index = 0;
        int i = 0;
        int j = 0;
        for (i = 0; i < n; i++) {
            c = 0;
            x = a - (a / 10) * 10;
            a /= 10;
            b = tmp;
            for (j = 0; j < t; j++) {
                y = b % 10;
                b /= 10;
                w = res[i + j] + x * y + c;
                c = w / 10;
                w = w % 10;
                res[i + j] = w;
                w = 0;
            }
            res[i + j] = c;
        }
        res[i + j - 1] = c;
        int ans = 0;
        int tt = 0;
        for (i = 0; i < n + t; i++) {
            tt = (int) Math.pow(10, i);
            //    printf("res-%d=%d ",i,res[i]);
            ans += tt * res[i];
        }
        return ans;
    }

    private static int bits(int a) {
        int res = 0;
        while (a > 0) {
            a /= 10;
            res++;
        }
        return res;
    }
}
