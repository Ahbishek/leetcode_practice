package Algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TwoSums {
    public int[] twoSum(int[] nums, int target) {

        int len=nums.length;
        int a[]=new int[2];

        Map<Integer,Integer> numArrayMap = new HashMap();
        for(int i=0;i<len;i++){
            numArrayMap.put(nums[i],i);
        }
        for(int i=0;i<len;i++){
            if(numArrayMap.containsKey(target-nums[i])){
                int value=numArrayMap.get(target-nums[i]);
                if(value !=i){
                    a[0]=i;
                    a[1]=value;
                    break;
                }
            }
        }
        return a;
    }
    public static void main(String args[]){

    }
}
