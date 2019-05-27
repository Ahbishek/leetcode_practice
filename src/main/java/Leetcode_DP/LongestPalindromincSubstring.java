package Leetcode_DP;

public class LongestPalindromincSubstring {
    public static String longestPalindrome(String s) {
      int l =s.length();


      int [][]arr = new int[l][l];

      for(int i=0;i<l;i++){
          arr[i][i] =1;
      }

      int start=0;
      int maxlen=1;
      for(int i=0;i<l-1;i++){
          if(s.charAt(i) == s.charAt(i+1)){
              arr[i][i+1] =1;
              start=i;
              maxlen=2;
          }
      }

      for(int k=3;k<=l;k++){

          for(int i=0;i<= l-k;i++){

              int j = i+k-1;

              if(s.charAt(i)==s.charAt(j) && arr[i+1][j-1]==1){
                  arr[i][j]=1;
                  if(k>maxlen){
                  start=i;
                  maxlen=k;
                  }
              }
          }

      }



      String answer = s.substring(start,start+maxlen);
     // System.out.println(answer  + " " + maxlen + " " + start);

      return answer;

    }

    public static void main(String[] args){
        longestPalindrome("ttttmbababmyuy");
    }
}
