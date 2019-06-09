package Leetcode_datastructures.DFS;

import java.util.*;
//failed solution
public class p_210_DFS_Course_Schedule_Optimized_Detect_Cycle_In_Directed_Graph_Slightly_modified_DFS {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        int m = prerequisites.length;
        if(m==0){
            int []nullArray = {};
            return nullArray;
        }
        Map<Integer,List<Integer>> adjMatrix  = new HashMap<>();
        Map<Integer,Integer> sortedTopo = new TreeMap<>();


        for(int i=0;i<m;i++) {
            int p = prerequisites[i][0];
            int q = prerequisites[i][1];

            //just add p with empty list // adjMatrix sathi
            adjMatrix.putIfAbsent(p, new ArrayList<>());
            sortedTopo.putIfAbsent(p,0);
            sortedTopo.putIfAbsent(q,0);
            sortedTopo.put(p,sortedTopo.get(p)+1);
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
        List<Integer> visitedOrder = new LinkedList<>();

        //find topo sort :



        sortedTopo.forEach( (key,list) -> {
           if(DFS_Cycle_Detection(key,adjMatrix.get(key),adjMatrix,ansistorStack,visitedOrder)){
               flag[0] = true;
           }
        });

        //flag is set to true if cycle is present.
        // all courses can be complete if cycle not found.
        //so if no cycle - return true
        // if cycle return false;
//print DFS



        //cycle
        if(flag[0]==true){
            int [] nullArray = {};
            return nullArray;
        }else{
            return visitedOrder.stream().mapToInt(i -> i).toArray();
        }

    }

    public static boolean DFS_Cycle_Detection(Integer node, List<Integer>valList, Map<Integer,List<Integer>> adjMatrix
            , Set<Integer> ansistorStack, List<Integer> visitedOrder){

        if(ansistorStack.contains(node)){
            return true;
        }

        //its not an ansistor and already visited so no cycle.
        //This is optimization.
        if(visitedOrder.contains(node)){
            return false;
        }

        ansistorStack.add(node);
        visitedOrder.add(node);

        for(int i=0;i<valList.size();i++) {
            List<Integer> tempList = adjMatrix.get(valList.get(i));

               if( DFS_Cycle_Detection(valList.get(i), tempList, adjMatrix, ansistorStack,visitedOrder) ){
                return true;
               }

        }

        // stack me add karte abh uske sabh children
        // and children ke children sabh visit keye and fer bhe loop nahe mela so
        //stack se remove
        ansistorStack.remove(node);
        return false;


    }

    public static void main(String []args){
       int[][]prerequisites = {{0,1}} ;
      System.out.println(findOrder(3,prerequisites));

    }
}
