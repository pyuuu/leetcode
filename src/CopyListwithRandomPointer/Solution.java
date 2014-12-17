package CopyListwithRandomPointer;

import java.util.HashMap;
import java.util.Map;

/**
 * todo http://bbs.csdn.net/topics/390954800 在csdn里面问了一下为什么我的是runningtime error
 * https://oj.leetcode.com/problems/copy-list-with-random-pointer/
 * Created by xijueyp on 14-12-16.
 *
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 *
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;

        RandomListNode newListHead = new RandomListNode(0);
        RandomListNode realNewListHead = newListHead;
        RandomListNode oldListHead = head;
        Map<RandomListNode, RandomListNode> locationMap = new HashMap<RandomListNode, RandomListNode>();
        while (oldListHead!=null){
            newListHead.next = new RandomListNode(oldListHead.label);
            newListHead = newListHead.next;
            locationMap.put(oldListHead, newListHead);
            oldListHead = oldListHead.next;
        }
        // 最后会返回的节点
        realNewListHead = realNewListHead.next;

        oldListHead = head;
        newListHead = realNewListHead;
        while (oldListHead!= null && locationMap.get(oldListHead)==null){
            newListHead.random = locationMap.get(oldListHead);
            oldListHead = oldListHead.next;
            newListHead = newListHead.next;
        }

        return realNewListHead;
    }

    static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }

        void print(){
            RandomListNode a = this;
            while (a!=null){
                System.out.println(a.toString());
                a = a.next;
            }
        }

        @Override
        public String toString(){
            return label+" "+this.hashCode();
        }
    }

    public static void main(String ap[]){
        RandomListNode randomListNode = new RandomListNode(-1);
//        RandomListNode randomListNode1 = new RandomListNode(2);
//        randomListNode.next = randomListNode1;

        new Solution().copyRandomList(randomListNode).print();
    }
}


