package InsertionSortList;

/**
 * Created by xijueyp on 14-11-3.
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        int num =1;
        ListNode newList = head;
        head = head.next;

        while (head != null){
            ListNode index = newList;
            if (head.val < index.val){
                ListNode n = head;
                head = head.next;
                n.next = newList;
                newList = n;
                num++;
                continue;
            }

            int i=1;
            while (true){
                if (i==num){
                    index.next = head;
                    head = head.next;
                    break;
                }
                if (head.val < index.next.val){
                    ListNode listNode = index.next;
                    index.next = head;
                    head = head.next;
                    index.next.next = listNode;
                    break;
                }
                index = index.next;
                i++;
            }
            num++;
        }

        head = newList;
        for (int i=1 ;i!=num;i++){
            head = head.next;
        }
        head.next = null;

        return newList;
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
        ListNode l = s.insertionSortList(s.create(new int[]{}));
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