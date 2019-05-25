package hiringchALLENGES;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class TestClass {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scr =new Scanner(System.in);

        Integer size = Integer.parseInt(br.readLine().trim());

        List<String> arrTemp = new ArrayList<>(Arrays.asList(br.readLine().split(" ")));

        Map<Integer,List<Integer>> parentToChildList = new HashMap<>();

        List<Integer> active = new ArrayList<>();
        for(int i=0;i<arrTemp.size();i++){
            Integer x=Integer.parseInt(arrTemp.get(i));

            List<Integer>childList = parentToChildList.get(x);
            if(childList==null){
                parentToChildList.put(x,new ArrayList<Integer>());
                parentToChildList.get(x).add(i+1);
            }else{
                parentToChildList.get(x).add(i+1);

            }
            active.add(1);
        }

        Integer sizeDelete = Integer.parseInt(br.readLine().trim());
        List<String> delStringTemp = new ArrayList<>(Arrays.asList(br.readLine().split(" ")));
        List<Integer> delTemp = delStringTemp.stream().map( n -> Integer.parseInt(n)).collect(Collectors.toList());
            Collections.sort(delTemp);
         int count=0;

        if(sizeDelete == size){
            System.out.println(1);
            return;
        }

         for(int i=0;i<delStringTemp.size();i++) {

             int toBeDeleted =delTemp.get(i);
             int abc = active.get(toBeDeleted - 1);
             if (abc != 0) {
                 count++;
                 active.set(toBeDeleted-1, 0);
             }else{
                 continue;
             }
             if(toBeDeleted==1){
                 break;
             }
             Queue<Integer>listForCurrentNode = new PriorityQueue<>();
             listForCurrentNode.add(toBeDeleted);
             while (!listForCurrentNode.isEmpty()) {
                int n=listForCurrentNode.poll();

                if(parentToChildList.get(n)!=null){
                 parentToChildList.get(n).forEach( k -> {
                     active.set(k-1, 0);

                     listForCurrentNode.add(k);
                 });
                }

                  /*   childToParent.forEach((k, v) -> {

                         if (v == n) {

                             active.set(k-1, 0);

                             listForCurrentNode.add(k);

                         }
                     });*/

             }


         }


System.out.println(parentToChildList);
        System.out.println( count);

    }


}