package Leetcode_datastructures.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



//Logic : Level order traversal same code.
// In this code, in else part we have written travelse left then right..
// so  right ka rightest in each level would be the last value to be touched in that particular level.
// so map me value jate rahege and for each level and last value would be rightest node at each level


public class p_199_Binary_Tree_Right_Side_View {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;

    }

    public List<Integer> rightSideView(TreeNode root) {
        int height = maxDepth(root);
        List<Integer> ansList = new ArrayList();

        if(height==0){
            return ansList;
        }

        Map<Integer,Integer> levelNodeVal = new HashMap();
        for(int i=1;i<=height;i++){
            putValOfGivenLevelInMap(root,i,i,levelNodeVal);
        }



        for(int i=1;i<=height;i++){
            ansList.add(levelNodeVal.get(i));
        }
        return ansList;
    }

    public void putValOfGivenLevelInMap(TreeNode root,int level,int trueLevel,Map<Integer,Integer> map1){
        if(root==null){
            return;
        }
        if(level==1){
            map1.put(trueLevel,root.val);
        }
        else if(level>1){
            putValOfGivenLevelInMap(root.left,level-1,trueLevel,map1);
            putValOfGivenLevelInMap(root.right,level-1,trueLevel,map1);
        }

    }
}
