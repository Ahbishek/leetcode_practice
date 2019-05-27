package Leetcode_Algo;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CombinationsOfString {

    public static void permute(char c[],int l,int r){

       // int i;
        if(l==r){
            System.out.println(String.valueOf(c));
        }

        for(int i=l;i<=r;i++){


                swap(c,l,i);
                permute(c,l+1 ,r);
                swap(c,l,i);

        }
    }

    private static void swap(char[] c, int l, int i) {
    char temp =c[l];
    c[l]=c[i];
    c[i]=temp;
    }

    public static void main(String args[]){
        permute(new String("()()()()()").toCharArray(),0,9);
        permuteString(new String[]{"word","best","ocean"},0,2);
String abc="";


    }



    public static void permuteString(String c[],int l,int r){

        // int i;
        if(l==r){
            System.out.println(Arrays.stream(c).collect(Collectors.joining("")));
        }

        for(int i=l;i<=r;i++){


            swap2(c,l,i);
            permuteString(c,l+1 ,r);
            swap2(c,l,i);

        }
    }

    private static void swap2(String[] c, int l, int i) {
        String temp =c[l];
        c[l]=c[i];
        c[i]=temp;
    }
}
