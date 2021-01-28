package cn.dataStructures.util;

/**
 * @author TaoistQu
 * @version 1.0
 * @date 2021/1/24 0:38
 */
public class DoubleNode<T>{
    public T value;
    public DoubleNode<T> last;
    public DoubleNode<T> next;

    public DoubleNode(T data) {
        value = data;
    }
}
