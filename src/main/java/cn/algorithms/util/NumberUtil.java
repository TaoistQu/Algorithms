package cn.algorithms.util;

/**处理数值的工具类
 * @author TaoistQu
 * @version 1.0
 * @date 2021/1/14 0:02
 */
public class NumberUtil {
    /**
     * 随机生成一个绝对值介于 maxValue之间的数
     * @param maxValue 最大绝对值
     * @return 返回生成的这个数
     */
    public static int randomValue(int maxValue){
        return (int)((maxValue+1)*Math.random()) - (int)((maxValue+1)*Math.random());
    }
}
