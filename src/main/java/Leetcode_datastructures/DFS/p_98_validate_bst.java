package Leetcode_datastructures.DFS;

import java.util.ArrayList;
import java.util.List;

public class p_98_validate_bst {

    //  Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    class Solution {

        public boolean isValidBST(TreeNode root) {
            if(root==null){
                return true;
            }if(root.left == null && root.right == null){
                return true;
            }

            List<Integer> numList = new ArrayList();
            inorder(root,numList);

            boolean flag = true;
            for(int i=0;i<numList.size()-1;i++){
                if(numList.get(i)>=numList.get(i+1)){
                    flag = false;
                    break;
                }
            }
            return flag;

        }

        public void inorder(TreeNode root,List<Integer> numList){
            if(root!=null){

                inorder(root.left,numList);

                numList.add(root.val);

                inorder(root.right,numList);


            }


        }
    }
}
