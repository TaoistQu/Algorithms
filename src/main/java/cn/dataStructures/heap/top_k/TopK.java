package cn.dataStructures.heap.top_k;

import cn.dataStructures.heap.top_k.compare.CandidateComparator;
import cn.dataStructures.heap.top_k.compare.DaddyComparator;
import cn.dataStructures.heap.top_k.pojo.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Auther: TaoistQu
 * @Date: 2021/06/04/0:46
 */
public class TopK {
    /**
     * 用直接的方式实现
     *
     * @param arr
     * @param op
     * @param k
     * @return
     */
    public List<List<Integer>> compare(int[] arr, boolean[] op, int k) {
        HashMap<Integer, Customer> map = new HashMap<>();
        ArrayList<Customer> cands = new ArrayList<>();
        ArrayList<Customer> daddy = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int id = arr[i];
            boolean buyOrRefund = op[i];
            if (!buyOrRefund && !map.containsKey(id)) {
                ans.add(getCurAns(daddy));
                continue;
            }
            if (!map.containsKey(id)) {
                map.put(id, new Customer(id, 0, 0));
            }
            Customer c = map.get(id);
            if (buyOrRefund) {
                c.setBuy(c.getBuy() + 1);
            } else {
                c.setBuy(c.getBuy() - 1);
            }
            if (c.getBuy() == 0) {
                map.remove(id);
            }

            if (!cands.contains(c) && !daddy.contains(c)) {
                c.setEnterTime(i);
                if (daddy.size() < k) {
                    daddy.add(c);
                } else {
                    cands.add(c);
                }
            }
            cleanZeroBuy(cands);
            cleanZeroBuy(daddy);
            cands.sort(new CandidateComparator());
            daddy.sort(new DaddyComparator());
            move(cands, daddy, k, i);
            ans.add(getCurAns(daddy));
        }
        return ans;
    }

    private void move(ArrayList<Customer> cands, ArrayList<Customer> daddy, int k, int time) {
        if (cands.isEmpty()) {
            return;
        }
        if (daddy.size() < k) {
            Customer c = cands.get(0);
            c.setEnterTime(time);
            daddy.add(c);
            cands.remove(c);
        } else {
            if (cands.get(0).getBuy() > daddy.get(0).getBuy()) {
                Customer oldDaddy = daddy.get(0);
                daddy.remove(0);
                Customer newDaddy = cands.get(0);
                cands.remove(0);
                oldDaddy.setEnterTime(time);
                newDaddy.setEnterTime(time);
                daddy.add(newDaddy);
                cands.add(oldDaddy);
            }
        }
    }

    private List<Integer> getCurAns(ArrayList<Customer> daddy) {
        List<Integer> ans = new ArrayList<>();
        for (Customer c : daddy) {
            ans.add(c.getId());
        }
        return ans;
    }

    private void cleanZeroBuy(ArrayList<Customer> list) {
        List<Customer> noZero = new ArrayList<>();
        for (Customer c : list) {
            if (c.getBuy() != 0) {
                noZero.add(c);
            }
        }
        list.clear();
        for (Customer c : noZero) {
            list.add(c);
        }
    }
}
