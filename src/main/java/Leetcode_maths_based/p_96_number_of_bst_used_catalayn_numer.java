package Leetcode_maths_based;

public class p_96_number_of_bst_used_catalayn_numer {
}
class Solution {
    public int numTrees(int n) {

        //2nCn/(n+1);
        long abc =  bf(2*n,n)/(n+1);
        return (int)abc;

    }

    long bf(int n,int k){

        if(k>n-k){
            k = n-k;
        }

        long res=1;
        for(int i=0;i<k;i++){
            res = res * (n-i);
            res =res / (i+1);
        }
        return res;
    }
}