package DP;

public class p_338_couting_Set_bits {
    class Solution {
        public int[] countBits(int num) {
            int []sol = new int[num+1];

            if(num>=0){sol[0]=0;};
            if(num>=1){sol[1]=1;};
            if(num>=2){sol[2]=1;};

            for(int i=3;i<=num;i++){
                sol[i]= 1 + sol[(i&(i-1))];
            }
            return sol;
        }
    }
}
