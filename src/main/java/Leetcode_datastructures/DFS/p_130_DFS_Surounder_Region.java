package Leetcode_datastructures.DFS;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class IntPair{
    public  int i;
    public  int j;
    public IntPair(int i,int j){
        this.i = i;
        this.j = j;
    }


}

// adj matrix maintain keya hei for every 0 (as pass ke elements if 0 then its there in that matrix)
//border ke 0 se  connected 0 rahege toh thatshould not be changed.
//so dfs lagte for all 0 on border and unko * me convert karte.
// now urlele 0 cannot be reached by border 0 elements.
// so make them X
//make * to O again
public class p_130_DFS_Surounder_Region {

    public static void solve(char[][] board) {

        Map<String, List<IntPair>> adjMatrix  = new HashMap<>();

        int m = board.length;
        if(m==0){
            return;
        }
        int n = board[0].length;

        for(int i=0;i<m;i++){

            for(int j=0;j<n;j++){

                if(board[i][j] == 'O'){
                    List<IntPair> localAdj = new ArrayList();
                    String keyEle = i+"_"+j;   //12_3 aise rakhege 123 rakah roh 12,3 or 1,23 dono possible samaj sakte so wrong key
                    adjMatrix.put(keyEle,localAdj);

                    if( (i+1)<m && (i+1)>=0 &&
                            (j)<n && (j)>=0
                            && board[i+1][j]=='O'){
                        localAdj.add(new IntPair(i+1,j));
                    }


                    if( (i-1)<m && (i-1)>=0 &&
                            (j)<n && (j)>=0
                            && board[i-1][j]=='O'){
                        localAdj.add(new IntPair(i-1,j));
                    }


                    if( (i)<m && (i)>=0 &&
                            (j-1)<n && (j-1)>=0
                            && board[i][j-1]=='O'){
                        localAdj.add(new IntPair(i,j-1));
                    }


                    if( (i)<m && (i)>=0 &&
                            (j+1)<n && (j+1)>=0
                            && board[i][j+1]=='O'){
                        localAdj.add(new IntPair(i,j+1));
                    }


                }

            }
        }

        for(int j=0;j<n;j++){
            if(board[0][j]=='O'){
                DFS(0,j,adjMatrix,board);
            }
        }

        for(int j=0;j<n;j++){
            if(board[m-1][j]=='O'){
                DFS(m-1,j,adjMatrix,board);
            }
        }

        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                DFS(i,0,adjMatrix,board);
            }
        }

        for(int i=0;i<m;i++){
            if(board[i][n-1]=='O'){
                DFS(i,n-1,adjMatrix,board);
            }
        }

        for(int i=0;i<m;i++){

            for(int j=0;j<n;j++){

                if(board[i][j] =='O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] =='*'){
                    board[i][j]='O';
                }
            }
        }


    }

    public static void DFS(int i ,int j,
                    Map<String,List<IntPair>> adjMatrix ,char[][] board){

        board[i][j] = '*';
        List<IntPair> adjList = adjMatrix.get(i+""+j);
        if(adjList!=null){
            for(int k=0;k<adjList.size();k++){
                int ii = adjList.get(k).i;
                int jj = adjList.get(k).j;
                if(board[ii][jj]=='O'){
                    DFS(ii,jj,adjMatrix,board);
                }


            }
        }

    }

    public static void main(String args[]){
        char [][]board = {{'O','X','O','O','X','X','X','O','O','O','O','O','X','O','O','O','O','X','O','X'},
                {'X','O','X','O','O','X','X','O','O','X','O','X','O','X','O','X','X','O','O','O'},
                {'O','X','O','O','O','X','X','X','X','O','O','O','O','O','X','X','X','X','O','X'},
                {'X','X','O','O','O','X','X','O','O','O','X','X','X','O','O','X','O','X','X','O'},
                {'O','X','O','X','X','O','X','O','O','O','X','O','O','X','O','O','O','O','O','X'},
                {'X','O','O','X','O','X','O','O','O','X','X','O','X','O','O','X','O','O','O','O'},
                {'X','O','O','O','X','X','O','O','O','O','O','X','O','O','X','O','O','O','O','X'},
                {'X','O','O','O','X','O','X','X','X','O','X','O','X','X','X','X','O','O','O','X'},
                {'X','O','O','X','O','O','O','X','O','O','O','O','O','O','O','O','O','X','O','X'},
                {'O','O','O','X','O','X','X','X','X','X','X','X','X','X','O','O','O','O','X','O'},
                {'X','O','X','O','X','O','O','X','X','X','O','X','X','O','O','X','X','O','O','O'},
                {'O','X','O','O','X','O','O','O','O','O','O','X','X','X','X','O','O','O','X','O'},
                {'X','O','O','O','X','X','X','O','X','O','O','O','X','O','X','O','X','O','O','X'},
                {'O','O','O','O','X','O','X','X','O','X','O','X','O','X','X','X','X','O','O','O'},
                {'O','X','X','O','O','O','O','X','O','O','X','X','X','O','O','X','X','O','X','O'},
                {'X','O','X','X','X','X','X','X','O','X','X','O','X','O','O','X','O','O','O','X'},
                {'X','O','O','O','X','O','X','O','O','X','O','X','O','O','X','O','O','X','X','X'},
                {'O','O','X','O','O','O','O','X','O','O','X','X','O','X','X','X','O','O','O','O'},
                {'O','O','X','O','O','O','O','O','O','X','X','O','X','O','X','O','O','O','X','X'},
                {'X','O','O','O','X','O','X','X','X','O','O','X','O','X','O','X','X','O','O','O'}};

        solve(board);
    }
}