package Leetcode_datastructures.DFS;

import java.util.*;

public class p_207_DFS_Course_Schedule_Detect_Cycle_In_Directed_Graph_Slightly_modified_DFS {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        int m = prerequisites.length;
        if(m==0){
            return true;
        }
        Map<Integer,List<Integer>> adjMatrix  = new HashMap<>();

        for(int i=0;i<m;i++) {
            int p = prerequisites[i][0];
            int q = prerequisites[i][1];

            //just add p with empty list // adjMatrix sathi
            adjMatrix.putIfAbsent(p, new ArrayList<>());
            if (adjMatrix.get(q) == null) {
                List<Integer> aList = new ArrayList();
                aList.add(p);
                adjMatrix.put(q, aList);
            } else {
                adjMatrix.get(q).add(p);
            }
        }



        boolean []flag ={false};
        Set<Integer> ansistorStack = new HashSet<>();

        adjMatrix.forEach( (key,list) -> {
           if(DFS_Cycle_Detection(key,list,adjMatrix,ansistorStack)){
               flag[0] = true;
           }
        });

        //flag is set to true if cycle is present.
        // all courses can be complete if cycle not found.
        //so if no cycle - return true
        // if cycle return false;
        return !flag[0];



    }

    public static boolean DFS_Cycle_Detection(Integer node, List<Integer>valList, Map<Integer,List<Integer>> adjMatrix, Set<Integer> ansistorStack){

        if(ansistorStack.contains(node)){
            return true;
        }

        ansistorStack.add(node);

        for(int i=0;i<valList.size();i++) {
            List<Integer> tempList = adjMatrix.get(valList.get(i));
            if (tempList != null) {
               if( DFS_Cycle_Detection(valList.get(i), tempList, adjMatrix, ansistorStack) ){
                return true;
               }
            }
        }

        // stack me add karte abh uske sabh children
        // and children ke children sabh visit keye and fer bhe loop nahe mela so
        //stack se remove
        ansistorStack.remove(node);
        return false;


    }

    public static void main(String []args){
       int[][]prerequisites = {{1,0} , {2,1}} ;
       boolean canFinish = canFinish(3,prerequisites);

    }
}
