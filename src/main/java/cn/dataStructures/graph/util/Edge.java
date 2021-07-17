package cn.dataStructures.graph.util;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Auther: TaoistQu
 * @Date: 2021/07/17/19:24
 */
public class Edge {
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
