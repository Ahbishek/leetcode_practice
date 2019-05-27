package Leetcode_DP;

public class p_62_Unique_paths {
    public int uniquePaths(int m, int n) {

        if(m==0 && n==0){
            return 1;
        }

        int [][]arr =new int[n][m];

        for(int i=0;i<m;i++){
            arr[0][i] = 1;
        }

        for(int i=0;i<n;i++){
            arr[i][0] = 1;
        }

        for(int i=1;i<n;i++){

            for(int j=1;j<m;j++){

                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }

        return arr[n-1][m-1];

    }
}