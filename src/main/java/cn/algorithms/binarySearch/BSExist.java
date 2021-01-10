package cn.algorithms.binarySearch;
/**
 * @author TaoistQu
 * @version 1.0
 * @date 2021/1/10 21:03
 */
public class BSExist {
    public static void main(String[] args) {

    }

    public static boolean exist(int [] sortedArr,int num){
        if(sortedArr == null || sortedArr.length ==0){
            return false;
        }
        int  L =0;
        int R = sortedArr.length;
        int mid = L + ((R-L)>>1);
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
