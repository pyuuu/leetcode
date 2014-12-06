package IntersectionofTwoLinkedLists;

/**
 *
 problem describe:
 Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists:

 A:          a1 → a2
                     ↘
                     c1 → c2 → c3
                     ↗
 B:     b1 → b2 → b3
 begin to intersect at node c1.


 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.
 Credits:
 Special thanks to @stellari for adding this problem and creating all test cases.

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
 * Created by xijueyp on 14-12-6.
 *
 * 解题敲门：从不相同的两个链表中找出相同的部分来入手
 * 根据两个链表的长度，最后的部分一定是相同的（长度则相同），那么如果一个链表比另一个链表长，那么长处来的这一个部分就一定不是重合的部分
 * ！！
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode countNoteA = headA;
        ListNode countNoteB = headB;

        int sizeA = 0;
        int sizeB = 0;

        while (countNoteA != null) { sizeA++; countNoteA = countNoteA.getNext(); }
        while (countNoteB != null) { sizeB++; countNoteB = countNoteB.getNext(); }

        while (sizeA > sizeB){
            headA = headA.getNext();
            sizeA --;
        }
        while (sizeA < sizeB){
            headB = headB.getNext();
            sizeB --;
        }

        while (headA != null && headB != null && (headA != headB)){
            headA = headA.getNext();
            headB = headB.getNext();
        }

        return headA;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }

    public ListNode getNext() {
        return next;
    }
}