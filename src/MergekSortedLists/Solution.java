package MergekSortedLists;

import java.util.List;

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
 * todo
 */
public class Solution {

    boolean c(int a ,int b){
        return a<b;
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        ListNode result = null;

        for (ListNode listNode:lists){
            if (listNode == null)
                continue;
            ListNode index = listNode.next;
            listNode.next = new ListNode(listNode.getVal(), listNode.getNext());
            listNode.getNext().setNext(index);
        }

        while (true){
            // todo 怎么都需要遍历之后修改 list 中的对应值，所以必须要做的就是 for(;;) 形式的循环
            // todo 如果是ArrayList的话效率应该不会有什么问题
            for (ListNode listNode:lists){
                if (listNode == null) continue;

                if (result == null || c(result.getVal(), listNode.getNext().getVal())){
                    result = listNode;
                }
            }



        }

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