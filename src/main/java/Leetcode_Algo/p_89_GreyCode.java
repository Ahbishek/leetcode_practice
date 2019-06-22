package Leetcode_Algo;

import java.util.ArrayList;
import java.util.List;

public class p_89_GreyCode {
    class Solution {
        public List<Integer> grayCode(int n) {
            List<Integer> ansList = new ArrayList();
            if(n==0){
                ansList.add(0);
                return ansList;
            }
            String []grey = {"0","1"};

            int count = 1;
            while(count<n){

                List<String> L1 =new ArrayList();
                for(int i=0;i<grey.length;i++){
                    L1.add("0"+grey[i]);
                }

                List<String> L2 =new ArrayList();
                for(int i=grey.length-1;i>=0;i--){
                    L2.add("1"+grey[i]);
                }
                List<String>L3 = new ArrayList(L1);
                L3.addAll(L2);
                grey =  L3.toArray(new String[0]);
                count++;
            }



            for(String s: grey){

                Integer abc = Integer.parseInt(s,2);
                ansList.add(abc);
            }

            return ansList;

        }
    }
}
