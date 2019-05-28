package Leetcode_datastructures;

public class p_112_path_sum_solvedUsingPreorder {
         public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
         TreeNode(int x) { val = x; }
      }

      public static boolean mainFlag = false;

        public boolean hasPathSum(TreeNode root, int sum) {
            int target = sum;
            if(root==null){
                return false;
            }

            preorder(root,target,0);
            Boolean dummy = mainFlag;
            //multiple test case call this so reset to false and copied value in another //variable
            mainFlag = false;
            return dummy;
        }

        public void preorder(TreeNode root,int target,int sum){

            if(root!=null ){

                if(root.left==null && root.right ==null){
                    sum = sum + root.val;
                    if(sum==target){
                        mainFlag = true;
                        return;
                    }
                }

                preorder(root.left,target,sum+root.val);
                preorder(root.right,target,sum+root.val);



            }

        }

}
