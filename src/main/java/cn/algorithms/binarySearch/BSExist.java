package cn.algorithms.binarySearch;

import cn.algorithms.util.ArrayUtil;
import cn.algorithms.util.NumberUtil;

import java.util.Arrays;

/**
 * @author TaoistQu
 * @version 1.0
 * @date 2021/1/10 21:03
 */
public class BSExist {
    public static void main(String[] args) {
        int testTime = 50000;
        int maxSize = 10;
        int maxVale = 100;
        boolean succeed = true;
        for(int i = 0 ; i < testTime;i++){
            int [] arr = ArrayUtil.generateRandomArray(maxSize,maxVale);
            Arrays.sort(arr);
            int value = NumberUtil.randomValue(maxVale);
            if(ArrayUtil.testExit(arr,value) != exist(arr,value)){
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    public static boolean exist(int [] sortedArr,int num){
        if(sortedArr == null || sortedArr.length ==0){
            return false;
        }
        int  L =0;
        int R = sortedArr.length-1;
        int mid ;
        while (L<R){
            mid = L +((R-L)>>1);
            if(sortedArr[mid] == num){
                return true;
            }else if(sortedArr[mid] < num){
                L = mid+1;
            }else {
                R = mid-1;
            }
        }
        return sortedArr[L] == num;
    }
}
