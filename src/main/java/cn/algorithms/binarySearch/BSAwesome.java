package cn.algorithms.binarySearch;

import cn.algorithms.util.ArrayUtil;

/**
 * 二分法找无须数组的局部最小
 * @author TaoistQu
 * @version 1.0
 * @date 2021/1/14 22:08
 */
public class BSAwesome {
    public static void main(String[] args) {
        int  maxSize = 20;
        int maxValue = 10;
        int[] array = ArrayUtil.generateRandomArray(maxSize, maxValue);
        int lessIndex = getLessIndex(array);
        System.out.println(lessIndex);
        ArrayUtil.printArray(array);
    }
    public static int getLessIndex(int[] arr){
        if(arr == null || arr.length==0){
            return -1;
        }
        if(arr.length == 1 || arr[0] < arr[1]){
            return 0;
        }
        if(arr[arr.length-1] < arr[arr.length-2])
            return arr.length-1;
        int left = 1;
        int right = arr.length-2;
        int mid=0;
        while (left<right){
            mid = (left+right)>>1;
            if(arr[mid] > arr[mid-1]){
                right = mid-1;
            }else if(arr[mid] > arr[mid+1]){
                left = mid+1;
            }else {
                return mid;
            }
        }
        return left;
    }
}
