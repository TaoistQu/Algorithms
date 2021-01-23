package cn.algorithms.dataStructures.mylist;

/**
 * @author TaoistQu
 * @version 1.0
 * @date 2021/1/24 0:33
 */
public class Node<T> {
    public T value;
    public Node<Integer> next;

    public Node(T data) {
        value = data;
    }
}
