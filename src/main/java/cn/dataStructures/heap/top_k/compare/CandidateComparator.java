package cn.dataStructures.heap.top_k.compare;

import cn.dataStructures.heap.top_k.pojo.Customer;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Auther: TaoistQu
 * @Date: 2021/06/04/0:50
 */
public class CandidateComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.getBuy() != o2.getBuy() ? (o2.getBuy() - o1.getBuy()) : (o1.getEnterTime() - o2.getEnterTime());
    }
}


