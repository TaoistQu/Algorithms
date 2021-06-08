package cn.dataStructures.list.util;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Auther: TaoistQu
 * @Date: 2021/06/08/23:50
 */
public class ListUtil {
    /**
     * 打印链表
     *
     * @param node
     */
    public static void printLinkedList(Node node) {
        System.out.println("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
}
