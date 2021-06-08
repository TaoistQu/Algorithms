package cn.bit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 将一个数打印成二进制
 * @Auther: TaoistQu
 * @Date: 2021/06/07/23:14
 */
public class PrintBit {
    public static void main(String[] args) {
        int num = Integer.MIN_VALUE;


        int b = 12396;
        int c = ~b;
        int d = 4 | 5;

        //     System.out.println(d);

        //  print(4);
        //   print(5);
        //   print(d);

        int a = Integer.MIN_VALUE;
        int x = 5;
        int y = ~x + 1;
        System.out.println(y);
        print(a);
        print(a >> 1);
        print(a >>> 1);
        System.out.println(a >>> 1);
        print(64);
        print(63);
        int jj = 89;
        System.out.println(jj % 64);
        System.out.println(jj & 63);

    }

    /**
     * 打印一个数的二进制形式
     *
     * @param num
     */
    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }
}
