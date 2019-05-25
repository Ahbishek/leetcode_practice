package Algo;

import java.util.*;

public class Parantesis_Validation {
    public static boolean isValid(String s) {

        Set<Character> openParan =new HashSet<>();
        openParan.add('(');
        openParan.add('{');
        openParan.add('[');

        Set<Character> closeParan =new HashSet<>();
        closeParan.add(')');
        closeParan.add('}');
        closeParan.add(']');

        Map<Character,Character>pairMap = new HashMap<>();
        pairMap.put('(',')');
        pairMap.put('{','}')
        ;pairMap.put('[',']');



        Stack<Character> fullStringStack = new Stack<>();
        Stack<Character> closeParanStack = new Stack<>();

        for(int i=0;i<s.length();i++){
            fullStringStack.push(s.charAt(i));
        }

        boolean answer = true;
        while(!fullStringStack.isEmpty()){

            Character paran = fullStringStack.pop();

        if(closeParan.contains(paran)){
            closeParanStack.add(paran);
        }
        if(openParan.contains(paran)){
                if(closeParanStack.isEmpty()){
                return false;
            }else{

                Character closeC = closeParanStack.pop();
                if(!closeC.equals(pairMap.get(paran))){
                    return  false;
                }

            }

        }

        }

        if(!closeParanStack.isEmpty()){
            return false;
        }
        return true;
    }



    public static void main(String[] args){
        boolean res = Parantesis_Validation.isValid("[][]");
        if(res){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }
}
