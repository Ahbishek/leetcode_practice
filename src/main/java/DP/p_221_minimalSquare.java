package DP;

public class p_221_minimalSquare {

        public static int maximalSquare(char[][] matrix) {

            int m = matrix.length;
            if(m==0){
                return 0;
            }
            int n = matrix[0].length;
            if(n==0){
                return 0;
            }

            int [][]squaremat = new int[m][n];
            int maxSize=0;

            for(int i=0;i<n;i++){
                if(matrix[0][i] == '1'){
                    squaremat[0][i] =1;
                    maxSize=1;
                }
            }

            for(int i=0;i<m;i++){
                if(matrix[i][0] == '1'){
                    squaremat[i][0] =1;
                    maxSize=1;
                }
            }

            for(int i=1; i<m;i++){

                for(int j=1;j<n;j++){

                    if(matrix[i][j]=='1' && matrix[i-1][j-1] =='1'
                            && matrix[i-1][j]=='1' && matrix[i][j-1] =='1'){
                        if(squaremat[i-1][j-1]>1){
                            if(squaremat[i-1][j] ==squaremat[i-1][j-1] &&
                                    squaremat[i][j-1]==squaremat[i-1][j-1]){
                                squaremat[i][j]=squaremat[i-1][j-1] + 1;
                            }else{
                                squaremat[i][j]=2;
                            }

                        }else{

                            squaremat[i][j]=2;}
                        if(squaremat[i][j]>maxSize){
                            maxSize=squaremat[i][j];
                        }

                    }
                    else if(matrix[i][j]=='1'){
                        squaremat[i][j]=1;
                        if(squaremat[i][j]>maxSize){
                            maxSize=squaremat[i][j];
                            System.out.println(i + " " + j);
                        }
                    }
                }

            }

            return maxSize*maxSize;



        }

        public static  void main(String[]args){
            char [][]c =   new char[5][8];
            //["1","1","1","1","1","1","1","1"],["1","1","1","1","1","1","1","0"],["1","1","1","1","1","1","1","0"],["1","1","1","1","1","0","0","0"],["0","1","1","1","1","0","0","0"]]);
        }

}
