package Leetcode_datastructures.DFS;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class p_797_DFS_All_Path_Source_To_Target_Anssiterconcept_applied {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        int m = graph.length;
        if(m==0){
            return new ArrayList<>();
        }

        Set<Integer> ansister =  new LinkedHashSet<>();
        List<List<Integer>> mainAns = new ArrayList();

        DFS(0,graph[0],graph,ansister,mainAns);
        return mainAns;
    }


    public void DFS(int src,int[] adjList,int[][]graph,Set<Integer> ansister,List<List<Integer>> mainAns){

        ansister.add(src);
        if(src==graph.length-1){
            List<Integer> minianswer = ansister.stream().collect(Collectors.toList());
            mainAns.add(minianswer);
        }

        for(int i=0;i<graph[src].length;i++){

            if(!ansister.contains(graph[src][i])){
                DFS(graph[src][i],graph[src],graph,ansister,mainAns);

            }

        }

        ansister.remove(src);


    }
}
