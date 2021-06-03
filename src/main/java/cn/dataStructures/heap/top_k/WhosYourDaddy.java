package cn.dataStructures.heap.top_k;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Auther: TaoistQu
 * @Date: 2021/06/04/0:54
 */

import cn.dataStructures.heap.HeapGreater;
import cn.dataStructures.heap.top_k.compare.CandidateComparator;
import cn.dataStructures.heap.top_k.compare.DaddyComparator;
import cn.dataStructures.heap.top_k.pojo.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 用加强堆实现TopK问题
 */
public class WhosYourDaddy {
    private HashMap<Integer, Customer> customers;
    private HeapGreater<Customer> candHeap;
    private HeapGreater<Customer> daddyHeap;
    private final int daddyLimit;

    public WhosYourDaddy(int limit) {
        customers = new HashMap<>();
        candHeap = new HeapGreater<>(new CandidateComparator());
        daddyHeap = new HeapGreater<>(new DaddyComparator());
        daddyLimit = limit;
    }

    public List<List<Integer>> topK(int[] arr, boolean[] op, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        WhosYourDaddy who = new WhosYourDaddy(k);
        for (int i = 0; i < arr.length; i++) {
            who.operate(i, arr[i], op[i]);
            ans.add(who.getDaddies());
        }
        return ans;
    }

    /**
     * 获取当前操作后的获奖名单列表
     *
     * @return
     */
    private List<Integer> getDaddies() {
        List<Customer> customers = daddyHeap.getAllElements();
        List<Integer> ans = new ArrayList<>();
        for (Customer c : customers) {
            ans.add(c.getId());
        }
        return ans;
    }

    /**
     * 完成每一次操作的过程
     *
     * @param time
     * @param id
     * @param buyOrRefund
     */
    private void operate(int time, int id, boolean buyOrRefund) {
        if (!buyOrRefund && !customers.containsKey(id)) {
            return;
        }
        if (!customers.containsKey(id)) {
            customers.put(id, new Customer(id, 0, 0));
        }
        Customer c = customers.get(id);
        if (buyOrRefund) {
            c.setBuy(c.getBuy() + 1);
        } else {
            c.setBuy(c.getBuy() - 1);
        }
        if (c.getBuy() == 0) {
            customers.remove(id);
        }
        if (!candHeap.contains(c) && !daddyHeap.contains(c)) {
            c.setEnterTime(time);
            if (daddyHeap.size() < daddyLimit) {
                daddyHeap.push(c);
            } else {
                candHeap.push(c);
            }
        } else if (candHeap.contains(c)) {
            if (c.getBuy() == 0) {
                candHeap.remove(c);
            } else {
                candHeap.resign(c);
            }
        } else {
            if (c.getBuy() == 0) {
                daddyHeap.remove(c);
            } else {
                daddyHeap.resign(c);
            }
        }
        daddyMove(time);
    }

    private void daddyMove(int time) {
        if (candHeap.isEmpty()) {
            return;
        }
        if (daddyHeap.size() < daddyLimit) {
            Customer p = candHeap.pop();
            p.setEnterTime(time);
            daddyHeap.push(p);
        } else {
            if (candHeap.peek().getBuy() > daddyHeap.peek().getBuy()) {
                Customer oldDaddy = daddyHeap.pop();
                Customer newDaddy = candHeap.pop();
                oldDaddy.setEnterTime(time);
                newDaddy.setEnterTime(time);
                daddyHeap.push(newDaddy);
                candHeap.push(oldDaddy);
            }
        }
    }


}
