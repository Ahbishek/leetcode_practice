package Leetcode_Algo;

import java.util.Stack;

public class LongestValidParenthesis {

    public static int longestValidParentheses(String s) {



        Stack<Character> fullStringStack = new Stack<>();
        Stack<Character> closeParanStack = new Stack<>();

        for(int i=0;i<s.length();i++){
            fullStringStack.push(s.charAt(i));
        }
        int count=0;
        int maxCount=-99;


        while(!fullStringStack.isEmpty()){
            boolean answer = true;
            Character paran = fullStringStack.pop();

            if(")".equals(paran.toString())){
                closeParanStack.add(paran);
                answer=false;
            }
            if("(".equals(paran.toString())){
                if(closeParanStack.isEmpty()){
                    if(maxCount<count){
                        maxCount=count;
                    }
                    count=0;
                    answer=false;
                }else{

                    Character closeC = closeParanStack.pop();
                    if(!closeC.toString().equals(")")){
                        if(maxCount<count){
                            maxCount=count;
                        }
                        count=0;
                        answer=false;
                    }

                }

            }
            if(answer){
                count=count+2;
            }
            if(maxCount<count){
                maxCount=count;
            }

        }

        while(!closeParanStack.isEmpty()){
            closeParanStack.pop();
            maxCount--;
        }
        return maxCount;

    }


    public static void main(String[] args){
        System.out
                .println(longestValidParentheses(")()())()()("));
    }
}
