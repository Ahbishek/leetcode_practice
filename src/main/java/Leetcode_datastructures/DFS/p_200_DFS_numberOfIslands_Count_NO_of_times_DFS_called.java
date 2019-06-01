package Leetcode_datastructures.DFS;

public class p_200_DFS_numberOfIslands_Count_NO_of_times_DFS_called {

    //instead of maintaining visited array , we are changing 1 to * so that it is marked as visited/
    public int numIslands(char[][] grid) {

        int count = 0;
        int m = grid.length;

        if(m==0){
            return 0;
        }
        int n = grid[0].length;
        for(int i=0;i<grid.length;i++){

            for(int j=0;j<grid[0].length;j++){

                if(grid[i][j]!= '*' && grid[i][j] != '0'){
                    DFS(i,j,grid,m,n);
                    count++;
                }
            }
        }
        return count;
    }

    public void DFS(int i,int j,char[][] grid,int m ,int n){

        if( (i<0 || i>=m) || ( j<0 || j>=n)){
            return;
        }
        if(grid[i][j] == '*'  || grid[i][j] == '0'){
            return;
        }


        grid[i][j]= '*';
        DFS(i+1,j,grid,m,n);
        DFS(i-1,j,grid,m,n);
        DFS(i,j+1,grid,m,n);
        DFS(i,j-1,grid,m,n);

    }
}
