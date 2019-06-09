package Leetcode_datastructures.DFS;

import java.util.*;
import java.util.stream.Collectors;
//failed solution
public class p_332_reconstrcut_itineray {
     static Set<String> orderSet = new TreeSet<>();
    public  static List<String> findItinerary(List<List<String>> tickets) {

        Map<String,List<String>> adjMatrix = new HashMap();


        for(int i=0;i<tickets.size();i++){

            String key = tickets.get(i).get(0);
            String val = tickets.get(i).get(1);
            adjMatrix.putIfAbsent(key,new ArrayList());
            adjMatrix.get(key).add(val);

        }

        Map<String,Boolean> visitedMap = new HashMap();
        if(adjMatrix.get("JFK")!=null){
        DFS("JFK",adjMatrix.get("JFK"),adjMatrix,visitedMap,"");
        }
        String answercoma = orderSet.stream().findFirst().orElse("");
        orderSet = new TreeSet<>();
        return  Arrays.stream(answercoma.split(",")).collect(Collectors.toList());
    }


    public static void DFS(String node,List<String> vlist,Map<String,List<String>> adjMatrix,Map<String,Boolean>visitedMap,String parent){

        visitedMap.put(node,true);
        String pathTillNow;
        if(parent.isEmpty()){
            pathTillNow = node;
        }else{
            pathTillNow= parent+","+node;
        }

        if(vlist == null || vlist.size() == 0){
            orderSet.add(pathTillNow);
        }
        for(int i=0;i<vlist.size();i++){
            String tempnode = vlist.get(i);
            if(visitedMap.get(tempnode)==null){
                List<String> tempList = adjMatrix.get(tempnode);
                DFS(tempnode,tempList,adjMatrix,visitedMap,pathTillNow);
            }

        }

    }

    public  static void main(String ars[]){
   //     String []arr =  {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
    }
}
