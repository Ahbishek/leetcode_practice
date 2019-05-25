package Algo;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeeSum {

    public static void twoSum(int[] nums,int currI, int target,Set<List<Integer>> mainSet) {
        int len=nums.length;
        int left=currI+1;int right=len-1;
        while(left<right){

            if(nums[left]+nums[right]==target){
                Integer[] abc =  new Integer[3];
                abc[0] =nums[currI];
                abc[1]=nums[left];
                abc[2]=nums[right];
                mainSet.add(Arrays.asList(abc));
         //arrays.asList se add keya toh set me duplication ka khayal rakaha jata,
                // new LinkedList<integer> se nahe hota ..ye imp hei java mei

                left++;
                right--;


            }
            else if(nums[left]+nums[right]<target){
                left++;
            }else{
                right--;
            }
        }
    }

    public  static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len=nums.length;
        Set<List<Integer>> mainSet = new HashSet<>();
        for(int i=0;i<len-2;i++){
                twoSum(nums, i, 0 - nums[i], mainSet);
        }
        return mainSet.stream().collect(Collectors.toList());
    }

    public  static  void  main(String[] args){
        int a[]={-1, 0, 1, 2, -1, -4};
        System.out.println( ThreeeSum.threeSum(a));
    }
}
