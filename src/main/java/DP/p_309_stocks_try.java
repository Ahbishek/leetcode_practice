package DP;

public class p_309_stocks_try {
    public static int rob(int[] nums) {
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


        sumtill[0]=nums[0];
        sumtill[1]=nums[1];
        sumtill[2]=nums[0]+nums[2];

        for(int i=3;i<nums.length;i++){

            sumtill[i] = nums[i] + Math.max(sumtill[i-2],sumtill[i-3]);
        }

        return Math.max(sumtill[nums.length-1],sumtill[nums.length-2]);
    }

    public int maxProfit(int[] prices) {
        int [] nums =new int[prices.length-1];
        for(int i =0;i<prices.length-1;i++){
            nums[i] = prices[i+1] - prices[i];
        }
        return p_309_stocks_try.rob(nums);
    }
}
