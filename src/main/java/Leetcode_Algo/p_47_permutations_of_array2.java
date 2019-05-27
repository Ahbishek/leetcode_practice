package Leetcode_Algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p_47_permutations_of_array2 {

    public static void permute(int[] a, int l, int r, List<List<Integer>> res){

        if(l==r){
           List<Integer> abc =  Arrays.stream(a).boxed().collect(Collectors.toList());
            res.add(abc);
        }

        for(int i=l;i<=r;i++){

            swap(a,l,i);
            permute(a,l+1,r,res);
            swap(a,l,i);
        }
    }

    private static void swap(int[] a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }

    public static void main(String []args){
        List<List<Integer>> result = new ArrayList();

        int[]a = {1,1,3};
        permute(a,0,2,result);
    }

}
