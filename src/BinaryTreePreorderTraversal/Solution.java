package BinaryTreePreorderTraversal;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * Created by xijueyp on 14-12-9.
 */
public class Solution {


    List<Integer> result = new LinkedList<Integer>();

    public List<Integer> preorderTraversal(TreeNode root) {
        doPreorderTraversal(root);
        return result;
    }

    public void doPreorderTraversal(TreeNode root){
        if (root == null) return;

        result.add(root.getVal());

        if (root.getLeft() != null) doPreorderTraversal(root.getLeft());
        if (root.getRight() != null) doPreorderTraversal(root.getRight());
    }

    public static void main(String ap[]){
        TreeNode treeNode = new TreeNode(1);
        treeNode.setRight(new TreeNode(2));
        treeNode.getRight().setLeft(new TreeNode(3));
        System.out.println(new Solution().preorderTraversal(treeNode));
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