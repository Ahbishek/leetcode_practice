package Leetcode_Algo;

import java.util.*;

public class MaxLengthOfSubarray {
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();

        int start = 0,
                end = 0;
        // [start, end]
        while(start < n && end < n){
            if( !set.contains(s.charAt(end))){
                set.add( s.charAt(end++));
                max = Math.max( max, end-start);
            }else{
                set.remove( s.charAt(start++));
            }
        }

        return max;
    }


    public  static  void  main(String[] args){

       System.out.println( MaxLengthOfSubarray.lengthOfLongestSubstring("abxzxbcd"));
    }
}
