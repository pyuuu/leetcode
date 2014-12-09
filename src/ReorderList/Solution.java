package ReorderList;

/**
 *
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 *
 * https://oj.leetcode.com/problems/reorder-list/
 *
 * Created by xijueyp on 14-12-9.
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head==null) return;
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow, cur = slow.next;
        if(cur!=null){
            ListNode tmp = cur.next;
            cur.next = null;
            cur = tmp;
        }
        while(cur!=null){
            ListNode tmp = cur.next;
            cur.next = mid.next;
            mid.next = cur;
            cur = tmp;
        }
        ListNode left = head, right = mid.next;
        while(right!=null){
            mid.next = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = mid.next;
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
}