package cn.dataStructures.tree.util;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Auther: TaoistQu
 * @Date: 2021/06/19/15:58
 */
public class PNode {
    public int value;
    public PNode left;
    public PNode right;
    public PNode parent;

    public PNode(int data) {
        value = data;
    }
}
