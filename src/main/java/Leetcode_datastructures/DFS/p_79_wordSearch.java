package Leetcode_datastructures.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p_79_wordSearch {

    public static boolean exist(char[][] board, String word) {

        int n = board.length;
        if(n==0){
            return false;
        }
        int m = board[0].length;

        boolean visited[][] = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
        visited[i][j] = false;
            }
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                String s ="";
                boolean resultContainer[] ={false};

                DFS(board,word,i,j,visited,s,resultContainer);
                if(resultContainer[0]){
                    return  true;
                }
            }
        }

        return false;

    }

    private static  void DFS(char[][] board, String word, int i, int j, boolean[][] visited,String s,boolean[] resultContainer) {
    String oldS = new String(s);
    s=s+board[i][j];
    visited[i][j] = true;

    if(word.equals(s)){
       resultContainer[0] = true;
    }

    if( i+1 < board.length && i+1 >=0 && j>=0 && j<board[0].length &&!visited[i+1][j]){
        DFS(board,word,i+1,j,visited,s,resultContainer);
    }

        if( i-1 < board.length && i-1>=0 && j>=0 && j<board[0].length &&!visited[i-1][j]){
            DFS(board,word,i-1,j,visited,s,resultContainer);
        }


    if(i < board.length && i>=0 && j+1<board[0].length && j+1>=0 && !visited[i][j+1]){
            DFS(board,word,i,j+1,visited,s,resultContainer);
        }

        if(i < board.length && i>=0 && j-1<board[0].length && j-1>=0 && !visited[i][j-1]){
            DFS(board,word,i,j-1,visited,s,resultContainer);
        }

    //end done sabh hum leya with this node , set it to false and remove
    visited[i][j] = false;
    //s = oldS;
    }


    public static void main(String[] args){
        String  abc ="";
        char c = 'c';
        abc = abc + c;
        System.out.println(abc);
        char[][]board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        if(exist(board,"ABCCED")){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }

    }




}
