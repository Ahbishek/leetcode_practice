package DP;

import java.util.*;
import java.util.stream.Collectors;

public class p_40_combination_sum2 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
List<List<Integer>> result = new ArrayList<>();

if(target<0){
    return new ArrayList<>();
}


        List<List<Integer>> []dparray = new ArrayList [target+1];
        Arrays.sort(candidates);

        for(int i=0;i<=target;i++){

            List<List<Integer>> listfori = new ArrayList<>();
            for(int j=0;j<candidates.length;j++){
                int num = candidates[j];
                if(num>i){
                    //do nothing
                }else if( num ==i){
                    listfori.add(Arrays.asList(num));
                }else{
                    int diff = i-num;
//                    int positionOfDiff= Arrays.binarySearch(candidates,diff);
                    if(true) {

                        List<List<Integer>> listforDiff = dparray[diff];
                        if (listforDiff.isEmpty()) {
                            //do nothing
                        } else {
                            listforDiff.forEach(minnilist -> {
                                List<Integer> copyminni = new ArrayList<>(minnilist);
                                copyminni.add(num);
                                if(Collections.binarySearch(minnilist,num)<0){
                                listfori.add(copyminni);
                                }
                            });
                        }
                    }
                }

            }
            dparray[i] = listfori;
        }

        Set<List<Integer>> listSet = new HashSet<>();
        dparray[target].forEach( n -> {Collections.sort(n); listSet.add(n);});


    return listSet.stream().collect(Collectors.toList());
    }


    public  static void main(String[] args){

        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;

       List<List<Integer>> ans =  combinationSum2(candidates,target);

       /* Set<List<Integer>> res = new HashSet<>();
        ans.forEach( n -> {
            Integer [] ar = new Integer[n.size()];
            n.toArray(ar);
            res.add(Arrays.asList(ar));
        });*/

        ans.forEach(System.out::print);

    }
}
