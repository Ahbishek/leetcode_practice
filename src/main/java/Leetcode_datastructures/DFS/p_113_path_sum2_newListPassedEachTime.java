package Leetcode_datastructures.DFS;

import java.util.ArrayList;
import java.util.List;

public class p_113_path_sum2_newListPassedEachTime {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

        public static boolean mainFlag = false;
        public static List<List<Integer>> mainList = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int sum) {

            int target = sum;
            if(root==null){
                return mainList;
            }

            preorder(root,target,0,new ArrayList<Integer>());
            List<List<Integer>> dummyList = new ArrayList();
            dummyList.addAll(mainList);
            mainList= new ArrayList();
            return dummyList;
        }



        public void preorder(TreeNode root,int target,int sum, List<Integer> myList){

            if(root!=null ){

                if(root.left==null && root.right ==null){
                    sum = sum + root.val;
                    myList.add(root.val);

                    if(sum==target){
                        mainList.add(myList);
                    }
                }

                List<Integer> li = new ArrayList(myList);
                li.add(root.val);
                List<Integer> ri = new ArrayList(myList);
                ri.add(root.val);
                preorder(root.left,target,sum+root.val,li);
                preorder(root.right,target,sum+root.val,ri);



            }

        }

}
