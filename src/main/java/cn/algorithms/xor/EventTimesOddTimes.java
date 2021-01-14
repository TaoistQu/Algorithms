package cn.algorithms.xor;

/**
 * 异或操作
 * @author TaoistQu
 * @version 1.0
 * @date 2021/1/15 0:25
 */
public class EventTimesOddTimes {
    /**
     * arr中，只有一种数，出现奇数次
     * @param arr
     */
    public static void printOddTimesNum1(int[] arr){
        int eor = 0;
        for(int i=0;i<arr.length;i++){
            eor ^= arr[i];
        }
        System.out.println(eor);
    }
    public static void printOddTimesNum2(int[] arr){
        int eor = 0;
        for(int i = 0;i<arr.length;i++){
            eor ^= arr[i];
        }
        // eor = a ^ b
        // eor != 0
        // eor必然有一个位置上是1
        //011001000
        //000001000
        int rightOne = eor & (~eor+1);// 提取出最右的1   取反加1在与自身作与运算
        int onlyOne = 0;
        for(int  i =0;i<arr.length;i++){
            if((arr[i] & rightOne) != 0){
                onlyOne ^= arr[i];
            }
        }
        //eor  为两个异或的结果  onlyOne 为其中一个  eor ^ onlyOne 为另一个
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

    /**
     * 提取一个数字二进制中1的个数
     * @param N
     * @return
     */
    public static int bit1Counts(int N) {
        int count = 0;
        while (N!=0){
            //计算出最右边的 1
            int rightOne = N & (~N+1);
            count++;
            //抹掉最右边的 1
            N ^= rightOne;
        }
        return count;
    }
}
