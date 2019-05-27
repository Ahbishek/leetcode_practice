package Leetcode_DP;

public class p_64_min_path_sum {
    public int minPathSum(int[][] grid) {
int n = grid.length;
int m = grid[0].length;

int [][]arr =new int[n][m];
arr[0][0]=grid[0][0];

if(m==0 && n==0){
    return grid[0][0];
}

for(int i=1;i<m;i++){
    arr[0][i] = arr[0][i-1] + grid[0][i];
}

        for(int i=1;i<n;i++){
            arr[i][0] = arr[i-1][0] + grid[i][0];
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
            arr[i][j] = grid[i][j] + Math.min(arr[i-1][j],arr[i][j-1]);
            }
        }

        return arr[n-1][m-1];

    }

}
