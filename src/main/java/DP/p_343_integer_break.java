package DP;

public class p_343_integer_break {
    class Solution {
        public int integerBreak(int n) {
            int []res =new int[n+1];
            res[0]=0;
            if(n==2) return 1;
            if(n==3)  return 2;
            if(n>=1)res[1]=1;
            if(n>=2)res[2]=2;
            if(n>=3)res[3]=3;
            if(n>=4)res[4]=4;

            for(int i=5;i<=n;i++){
                res[i]=-99;
            }
            for(int i=5;i<=n;i++){

                for(int j=1;j<i;j++){
                    res[i] = Math.max(res[i],res[j]*res[i-j]);
                }
            }

            return res[n];
        }
    }
}
