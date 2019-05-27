package Leetcode_Algo;

import java.util.*;

public class MaxPrefix {

    public static String longestCommonPrefixWorst(String[] strs) {
        if(strs.length==1){
            return strs[0];
        }else if (strs.length==0){
            return "";
        }

       Integer alen = Arrays.stream(strs).map(n -> n.length() ).min(Comparator.comparing(Integer::valueOf)).get();
      // find the minlen by iterating each string and minn logic instead of streams and you get fasterst solution


       int count=0;
       StringBuilder sb =new StringBuilder("");
        while (count < alen) {
        Character a = new Character(strs[0].charAt(count));
            boolean flag = false;

            for (int i = 0; i < strs.length; i++) {
                if (a != strs[i].charAt(count)) {
                    flag = false;
                    break;
                } else {
                    flag = true;
                }
            }

            if(flag){
                sb.append(a.charValue());
            }else{
                break;
            }

            count++;
        }
       return  sb.toString();
}



    public  static  void  main(String[] args){
        String[] argss = {"flower","flow","flight"};
        System.out.println( MaxPrefix.longestCommonPrefixWorst(argss));
    }
}
