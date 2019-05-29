package Leetcode_datastructures.DFS;

public class p_114_Flatten_Binary_Tree_To_LinkedListLike_inPlace {
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {

    public void flatten(TreeNode root){
        flatten2(root);
    }
    public TreeNode flatten2(TreeNode root) {

        if(root==null){
            return root;
        }
        if(root.left == null && root.right == null){
            return root;
        }

        TreeNode leftl = flatten2(root.left);
        TreeNode rightl = flatten2(root.right);
        TreeNode dummyLeftL = leftl;

        if(leftl!=null){
            while(leftl.right!=null){
                leftl= leftl.right;
            }
            leftl.right=rightl;
            root.right=dummyLeftL;
            root.left = null;
        }

        return root;

    }
}
