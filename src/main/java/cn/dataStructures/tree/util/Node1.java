package cn.dataStructures.tree.util;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Auther: TaoistQu
 * @Date: 2021/06/05/20:25
 */
public class Node1 {
    public int pass;
    public int end;
    public Node1[] nexts;

    public Node1() {
        pass = 0;
        end = 0;
        nexts = new Node1[26];
    }

}
