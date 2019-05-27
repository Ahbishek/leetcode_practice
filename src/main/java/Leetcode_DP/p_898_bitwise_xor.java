package Leetcode_DP;

import java.util.HashSet;
import java.util.Set;

public class p_898_bitwise_xor {
    public static int subarrayBitwiseORs(int[] A) {

        int []xora =new int[A.length];
        xora[0]=0;
        Set<Integer> nums = new HashSet();
        for(int i=1;i<A.length;i++){
            xora[i] = xora[i-1] ^ A[i];
            nums.add(A[i]);
        }


        for(int i=0;i<A.length;i++){
            for(int j=i+1;j<A.length;j++){
                nums.add(xora[i]^xora[j]);
            }
        }
        System.out.println(nums);
        return nums.size();

    }
    public static void main(String[] args){
        int []a = {1,1,2};
        subarrayBitwiseORs(a);

    }
}
