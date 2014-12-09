package BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xijueyp on 14-12-9.
 */
public class Solution {


    List<Integer> result = new ArrayList<Integer>();

    public List<Integer> postorderTraversal(TreeNode root) {
        doPostorderTraversal(root);
        return result;
    }

    public void doPostorderTraversal(TreeNode root){
        if (root == null) return;

        if (root.getLeft() != null) doPostorderTraversal(root.getLeft());
        if (root.getRight() != null) doPostorderTraversal(root.getRight());
        result.add(root.getVal());
    }

    public static void main(String ap[]){
        TreeNode treeNode = new TreeNode(1);
        treeNode.setRight(new TreeNode(2));
        treeNode.getRight().setLeft(new TreeNode(3));
        System.out.println(new Solution().postorderTraversal(treeNode));
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
