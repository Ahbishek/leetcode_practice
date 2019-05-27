package Leetcode_Algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class MedianArray {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
 // slower than 60% solutions/ solution accepted all test passed.
        int num1len=nums1.length;
        int  num2len=nums2.length;

        if (num1len == 0 && num2len == 1) {
            return nums2[0];
        } else if (num1len == 1 && num2len == 0) {
            return nums1[0];
        }
        int countLimit = (num1len+num2len+1)/2;

        int l=0;
        int r=0;
        int a=0;
        int b=0;
        int count=0;

        while(l<num1len && r<num2len && count<=countLimit){

            if(nums1[l]<nums2[r]){
                b=a;
                a=nums1[l];
                l++;
                count++;
            }
            else{
                b=a;
                a=nums2[r];
                r++;
                count++;
            }
        }
        while(l<num1len && count<=countLimit){
            b=a;
            a=nums1[l];
            l++;
            count++;

        }
        while(r<num2len && count<=countLimit){
            b=a;
            a=nums2[r];
            r++;
            count++;

        }

        int totallen=num1len+num2len;
        System.out.println("a " + a);
        System.out.println("b " + b);
        double result = (totallen%2)==0 ? (double) (a+b)/2:b;
        return result;

    }

    public static double findMedianSortedArraysWorstTry(int[] nums1, int[] nums2){

        //worst solution  only refer for java syntax
        ArrayList<Integer> biggerArray = new ArrayList<>();

        ArrayList<Integer> a1 = (ArrayList<Integer>) Arrays.stream(nums1).boxed().collect(Collectors.toList());

        ArrayList<Integer> a2 = (ArrayList<Integer>) Arrays.stream(nums2).boxed().collect(Collectors.toList());
        biggerArray.addAll(a1);
        biggerArray.addAll(a2);

        biggerArray.forEach(System.out::println);
        Collections.sort(biggerArray);
        double result=0;
        int arraylen=biggerArray.size();
        if(arraylen==1){
            result=biggerArray.get(0);
        }
        else{
            if(arraylen%2==0){
             result = (double)  (biggerArray.get(arraylen/2) + biggerArray.get((arraylen-1)/2))/2;
            }else{
                result = (biggerArray.get(arraylen/2));
            }


        }
        return result;
    }

    public  static  void  main(String[] args){

        int array1[]={2};
        int array2[]={1,2,3};
        System.out.println( MedianArray.findMedianSortedArrays(array1,array2));
        System.out.println( MedianArray.findMedianSortedArraysWorstTry(array1,array2));
    }
}
