package Leetcode_DP;/*Problem 279
* Given a positive integer n,
* find the least number of
 * perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
*
* */


public class P_279_PerfectSquare_DP {
    public int numSquares(int n) {

        int sqrtN = (int)Math.sqrt(n);
        int sqrtN2 = sqrtN * sqrtN;
        int t =n+1;

        int [][]arr = new int[sqrtN][n+1];

        //allocate the array
//int** arr = new int*[sqrtN];
//for(int i = 0; i < sqrtN; i++)
        //   arr[i] = new int[n+1];


        for(int i=0;i<n+1;i++){
            arr[0][i] = i;
        }

        for(int i=1;i<sqrtN;i++){
            arr[i][0] = 0;
        }

        for(int i=1;i<sqrtN;i++){
            int i2 =i+1;
            for(int j=1;j<n+1;j++){

                if(j<(i2*i2)){
                    arr[i][j]=arr[i-1][j];
                }else{
                    //System.out.println("j " + j + " i2 " + i2*i2);
                    int m = 1 + arr[i][j-(i2*i2)];
                    int n2 = arr[i-1][j];
                    arr[i][j] = (int)Math.min(m,n2);
                }



            }

        }
        int answer = arr[sqrtN-1][n];

        //  for(int i = 0; i < sqrtN ; i++)
        //       delete[] arr[i];
        //   delete[] arr;

        return answer;

    }


}