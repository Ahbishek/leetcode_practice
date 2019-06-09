package java_learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class TP {
    public static void main(String [] args) throws IOException {
        Stack<Integer> s1 = new Stack<>();
        Queue<Integer> queue = new PriorityQueue<>();

/*        Collections.binarySearch();
   *//*     Collections.reverseOrder()
                Collections.reverse();
        String s = "";

        s.subSequence()*/

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        String abc = br.readLine().trim();
        String abcs[] = br.readLine().split(" ");

        Scanner scr = new Scanner(System.in);
        BigInteger bigint = BigInteger.valueOf(100);
        bigint.intValue();
        Integer.toString(Integer.parseInt("100",2),10);
        Integer.bitCount(8);
        Integer.highestOneBit(8);
        System.out.println(Integer.toBinaryString(202));
        System.out.println(Integer.toBinaryString(-202));
        System.out.println(Integer.toBinaryString(202 & (-202)));
        System.out.println((Integer.reverse(202)));
        System.out.println(Integer.toBinaryString(-905969664));
      StringBuilder br2 =new StringBuilder("abc");
      br2.reverse().toString();



      Boolean abcd = false;
      fun1(abcd);
      fun2(abcd);

        //n!=0 & !(n &)
       // bigint.bitCount()
    }

    private static void fun1(Boolean abcd) {
        System.out.println("fun1 abcd before change " + abcd);
        abcd = true;
        System.out.println("fun1 abcd after change " + abcd);
    }
    private static void fun2(Boolean abcd) {
        System.out.println("fun2 abcd before change " + abcd);
    }

}
