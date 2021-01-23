package cn.algorithms.dataStructures.mylist;

/**
 * @author TaoistQu
 * @version 1.0
 * @date 2021/1/24 0:38
 */
public class DoubleNode<T>{
    public T value;
    public DoubleNode last;
    public DoubleNode next;

    public DoubleNode(T data) {
        value = data;
    }
}
