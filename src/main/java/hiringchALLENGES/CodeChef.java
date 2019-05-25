package hiringchALLENGES;

/* package codechef; // don't place package name! */

import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{/*
2
2 3
1 1
3 7
4 2 2
*/
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
Math.min(2,3);
        Scanner scr =  new Scanner(System.in);
        int n = scr.nextInt();

        for(int i=0;i<n;i++){

            int nume = scr.nextInt();
            int banana =scr.nextInt();
            int sum=0;
            for(int j =0;j<nume;j++){
                sum =  sum + scr.nextInt();
            }
            if(banana>=sum){
                System.out.println("Yes");

            }
            else{
                System.out.println("No");
            }
        }

    }

}
