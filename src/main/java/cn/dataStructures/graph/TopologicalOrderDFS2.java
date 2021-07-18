package cn.dataStructures.graph;

import cn.dataStructures.graph.util.DirectedGraphNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 最大深度，如果X的最大深度大与Y的最大深度大x就在Y前
 * @Auther: TaoistQu
 * @Date: 2021/07/18/23:42
 */
public class TopologicalOrderDFS2 {
    /**
     * 当前点的深度
     */
    public static class Record {
        public DirectedGraphNode node;
        public int deep;

        public Record(DirectedGraphNode n, int d) {
            node = n;
            deep = d;
        }
    }

    public static class MyComparator implements Comparator<Record> {

        @Override
        public int compare(Record o1, Record o2) {
            return o2.deep - o1.deep;
        }
    }

    public static ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        HashMap<DirectedGraphNode, Record> order = new HashMap<>();
        for (DirectedGraphNode cur : graph) {
            f(cur, order);
        }
        ArrayList<Record> recordArr = new ArrayList<>();
        for (Record r : order.values()) {
            recordArr.add(r);
        }
        recordArr.sort(new MyComparator());
        ArrayList<DirectedGraphNode> ans = new ArrayList<>();
        for (Record r : recordArr) {
            ans.add(r.node);
        }
        return ans;
    }

    public static Record f(DirectedGraphNode cur, HashMap<DirectedGraphNode, Record> order) {
        if (order.containsKey(cur)) {
            return order.get(cur);
        }
        int follow = 0;
        for (DirectedGraphNode next : cur.neighbors) {
            follow = Math.max(follow, f(next, order).deep);
        }
        Record ans = new Record(cur, follow + 1);
        order.put(cur, ans);
        return ans;
    }
}
