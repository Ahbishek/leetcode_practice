package hiringchALLENGES;

import java.io.*;
import java.util.*;


public class TestHire {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        long[][] arr = new long[t][3];
        for(int i_arr=0; i_arr<t; i_arr++)
        {  String[] arr_arr = br.readLine().split(" ");
            for(int j_arr=0; j_arr<arr_arr.length; j_arr++)
            {
                arr[i_arr][j_arr] = Long.parseLong(arr_arr[j_arr]);
            }
        }
        int[] out_ = Solution(arr,t);
        for (int i_out_=0; i_out_<t; i_out_++)
        {
            System.out.println(out_[i_out_]);
        }
        wr.close();
        br.close();
    }
    static int[] Solution(long[][] arr,int n){
        // Write your code here
        long maxSize = -99;
        for(int i=0;i<n;i++){
            long num=arr[i][0];
            if(num>maxSize){
                maxSize=num;
            }
        }

        int [][]dparray = new int[(int)(maxSize+1)][(int)(maxSize+1)];


        for(int i=1;i<=maxSize;i++){
            for(int j=1;j<=i;j++){
                if(i==j){
                    dparray[i][j]=0;
                }
                else if((j-i)%3==0){
                    int diff = i-j;
                    double dcomp1 = (Math.log(diff)/Math.log(3));
                    int comp1=9999;
                    if(dcomp1%1==0){
                     comp1= (int)dcomp1;
                    }
                    int comp2=99999;
                    if((i-3)>=0){
                        comp2 = 1 + dparray[i-3][j];
                    }
                    dparray[i][j] = (int)Math.min(comp1,comp2);
                    dparray[j][i] = dparray[i][j];

                }else{
                    dparray[i][j]=-1;
                    dparray[j][i] = dparray[i][j];
                }

            }
        }

        for(int i =0;i<maxSize;i++){
            for(int j=0;j<maxSize;j++){
                System.out.print(dparray[i][j] + " ");
            }
            System.out.println("");
        }
int[]ans = new int[n];
        for(int i=0;i<n;i++){
            int num1 = (int)arr[i][1];
            int num2 = (int)arr[i][2];
            int num3 = dparray[num1][num2];
            ans[i]=num3;
        }

        System.out.println(dparray[3][30]);

        return ans;
    }



}