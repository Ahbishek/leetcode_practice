package DP;
/*
* You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses
 * have security system connected and it will automatically contact the police if two
 * adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house,
determine the maximum amount of money you can rob tonight without alerting the police.*/

/*Logic:
at each house : chori ka sum = house value + chorisum till adjacent ka adjacent house) or
                               house value +  chori sum till adjacet ke adjacne tka ajacent house.
//wrong solution

 */

public class p_213_house_robber2 {
    public int rob(int[] nums) {
        int []sumtill = new int[nums.length];
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        else if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        else if(nums.length==3){
            return Math.max(Math.max(nums[0],nums[1]),nums[2]);
        }


        sumtill[0]=nums[0];
        sumtill[1]=nums[1];
        sumtill[2]=nums[0]+nums[2];
        boolean []containsNode0 = new boolean[nums.length];
        containsNode0[0]=true;
        containsNode0[1]=false;
        containsNode0[2]=true;

        for(int i=3;i<nums.length;i++){
            sumtill[i] = nums[i];
            if(i!= nums.length-1) {
                if (sumtill[i - 2] > sumtill[i - 3]) {
                    sumtill[i] = sumtill[i] + sumtill[i - 2];
                    if (containsNode0[i - 2]) {
                        containsNode0[i] = true;
                    }
                } else {
                    sumtill[i] = sumtill[i] + sumtill[i - 3];
                    if (containsNode0[i - 3]) {
                        containsNode0[i] = true;
                    }
                }
            }else{
                if(containsNode0[i-2]) {
                    sumtill[i] = sumtill[i] + sumtill[i - 3];
                }else if(containsNode0[i-3]){
                    sumtill[i] = sumtill[i]  +sumtill[i-2];
                }
                else{
                    sumtill[i] += Math.max(sumtill[i-2],sumtill[i-3]);
                }

            }
           // sumtill[i] = nums[i] + Math.max(sumtill[i-2],sumtill[i-3]);
        }

        return Math.max(sumtill[nums.length-1],sumtill[nums.length-2]);
    }
}
