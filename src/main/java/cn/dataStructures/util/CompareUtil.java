package cn.dataStructures.util;

/**
 * 对数器工具类
 *
 * @author TaoistQu
 * @version 1.0
 * @date 2021/1/29 0:05
 */
public class CompareUtil {
    public static boolean isEqual(Integer o1, Integer o2) {
        if (o1 == null && o2 != null) {
            return false;
        }
        if (o1 != null && o2 == null) {
            return false;
        }
        if (o1 == null && o2 == null) {
            return true;
        }
        return o1.equals(o2);
    }
}
