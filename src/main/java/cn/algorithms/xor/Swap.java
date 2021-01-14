package cn.algorithms.xor;

/**
 *   异或运算：相同为0，不同为1
 *   同或运算：相同以1，不同为0
 *   能长时间记住的概率接近0%
 *
 *   所以，异或运算就记成无进位相加！
 *   0 1 1 0
 *   0 1 0 0
 *   0 0 1 0

 *  异或运算的性质
 *   1) 0^N == N      N^N == 0
 *   2)异或运算满足交换律和结合率
 *   上面的两个性质用无进位相加来理解就非常的容易
 * @author TaoistQu
 * @version 1.0
 * @date 2021/1/14 23:25
 */
public class Swap {
    /**
     * 交换数组两位置上的值 (这个地方有个坑，必须要两个数不在同一位置才行)
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        /*arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];*/
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
