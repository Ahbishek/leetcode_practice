package DP;

public class p_63_unique_path3 {


        public int uniquePathsWithObstacles(int[][] obstacleGrid) {


            int n = obstacleGrid.length;
            int m = obstacleGrid[0].length;

            if(m ==0 && n ==0){
                return 0;
            }

            int [][]arr =new int[n][m];

            for(int i=0;i<m;i++){
                if (obstacleGrid[0][i] == 1) {
                    arr[0][i] = 0;
                }else{

                    if(i==0){
                        arr[0][i]=1;
                    }else{
                        arr[0][i] = arr[0][i-1];
                    }
                }
            }

            for(int i=0;i<n;i++){
                if (obstacleGrid[i][0] == 1) {
                    arr[i][0] = 0;
                }else{
                    if(i==0){
                        arr[0][i]=1;
                    }else{
                        arr[i][0] = arr[i-1][0];}
                }
            }

            for(int i=1;i<n;i++) {
                for (int j = 1; j < m; j++) {

                    if (obstacleGrid[i][j] == 1) {
                        arr[i][j] = 0;
                    } else {
                        arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                    }
                }
            }

            return arr[n-1][m-1];
        }

}
