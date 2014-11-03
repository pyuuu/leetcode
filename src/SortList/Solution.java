package SortList;

/**
 * Created by xijueyp on 14-11-2.
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 类归并排序
 */
public class Solution {

    public ListNode sortList(ListNode head) {
        if (head == null )
            return null;
        if(head.next == null) return head;
        Queue<Node> queue = new LinkedList<Node>();
        int count = 0;
        while(head!=null){
            queue.offer(new Node(head, 1));
            head = head.next;
            count ++;
        }

        while(queue.size()>1){
            Node n1 = queue.poll();
            Node n2 = queue.poll();
            queue.offer( new Node(merger(n1.listNode, n2.listNode, n1.num, n2.num), n1.num+n2.num));
        }
        ListNode tail = queue.poll().listNode;
        ListNode h = tail;
        while(count!=1){
            tail = tail.next;
            count --;
        }
        tail.next = null;
        return h;
    }

    // 返回合并后的头结点  num是合并后的链表总长度
    public ListNode merger(ListNode first, ListNode second, Integer num1, Integer num2) {

        ListNode head;
        if (biggerThan(first, second) >= 0) {
            head = first;
            first = first.next;
            num1 --;
        }
        else {
            head = second;
            second = second.next;
            num2--;
        }
        ListNode next = head;
        while(num1>0 && num2>0){
            if (biggerThan(first, second) > 0){
                next.next = first;
                first = first.next;
                num1 --;
            }
            else {
                next.next = second;
                second = second.next;
                num2 --;
            }
            next = next.next;
        }

        while (num1 > 0) {
            next.next = first;
            first = first.next;
            next = next.next;
            num1--;
        }
        while (num2 > 0){
            next.next = second;
            second = second.next;
            next = next.next;
            num2 --;
        }

        return head;
    }

    int biggerThan(ListNode listNode1, ListNode listNode2){
        return listNode1.val - listNode2.val;
    }

    ListNode create(int []ints){
        ListNode head = new ListNode(0);
        ListNode re = head;
        for (int i:ints){
            head.next = new ListNode(i);
            head = head.next;
        }
        return re.next;
    }

    public void print(ListNode h) throws CloneNotSupportedException {
        ListNode q = h;
        while (q!=null){
            System.out.println(q.val);
            q = q.mclone().next;
        }
    }

    public static void main(String a[]) throws CloneNotSupportedException {
        Solution s = new Solution();
        ListNode l = s.sortList(s.create(new int[]{}));
        s.print(l);
    }
}

class Node{
    ListNode listNode;
    int num;
    Node(ListNode listNode, int num){
        this.listNode = listNode;
        this.num = num;
    }
}

class ListNode implements Cloneable {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode mclone() throws CloneNotSupportedException {
        return (ListNode)super.clone();
    }
}



//
//public class Solution {
//
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        // Note: The Solution object is instantiated only once and is reused by each test case.
//        ListNode rt = new ListNode(0);
//        ListNode h = rt;
//
//        while( l1 != null && l2 != null){
//            if(l1.val < l2.val){
//                rt.next = l1;
//                l1 = l1.next;
//            }else{
//                rt.next = l2;
//                l2 = l2.next;
//            }
//
//            rt = rt.next;
//        }
//
//        if(l1 != null) rt.next = l1;
//        else rt.next = l2;
//
//
//        return h.next;
//
//
//    }
//
//    public ListNode sortList(ListNode head) {
//        if(head == null) return null;
//        if(head.next == null) return head;
//
//        ListNode fast = head.next;
//        ListNode slow = head;
//
//        while(fast != null && fast.next != null){
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        ListNode h2 = slow.next;
//        slow.next = null;
//
//        return mergeTwoLists(sortList(head), sortList(h2));
//    }
//
//        public static void main(String a[]) throws CloneNotSupportedException {
//        Solution s = new Solution();
//        ListNode l = s.sortList(s.create(new int[]{}));
//        s.print(l);
//    }
//
//    ListNode create(int []ints){
//        ListNode head = new ListNode(0);
//        ListNode re = head;
//        for (int i:ints){
//            head.next = new ListNode(i);
//            head = head.next;
//        }
//        return re.next;
//    }
//
//    public void print(ListNode h) throws CloneNotSupportedException {
//        ListNode q = h;
//        while (q!=null){
//            System.out.println(q.val);
//            q = q.mclone().next;
//        }
//    }
//
//}