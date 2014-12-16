package MergekSortedLists;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by xijueyp on 14-12-10.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 *
 * https://oj.leetcode.com/problems/merge-k-sorted-lists/
 *
 * 第一次计算：使用列表遍历，超时
 * 思路：
 * 时间的消耗有两点:1. 每一轮的排序 2. 一个list当中如果已经没有节点了，但是还是会每一轮都要遍历
 * 针对上面的问题，首先使用一个最小堆，每一轮的比较就可以变成 log(n)，而且只要是一个list变成null，就不加入最小堆。
 * 这样上面的效率问题就解决了
 *
 */
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists==null||lists.size()==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int x, ListNode next) {
        val = x;
        next = this.next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}