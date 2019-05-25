package Algo;

import java.util.*;

public class p_49_String_Group_Anagram {
    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        if(strs.length==0){
            return  result;
        }
        result.add(new ArrayList<>(Arrays.asList(strs[0])));

        for(int i=1; i<strs.length;i++){
            boolean flagAnagramAdded = false;
            for(int j=0; j< result.size();j++){

                if(isAnagram(strs[i],result.get(j).get(0))){
                    result.get(j).add(strs[i]);
                    flagAnagramAdded= true;
                    break;
                }

            }
            if(!flagAnagramAdded)
            {
                result.add(new ArrayList<>(Arrays.asList(strs[i])));
            }


        }


        return result;


    }


    public static boolean isAnagram(String s1,String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
 /*       char s1array[] =s1.toCharArray();
        char s2array[] =s2.toCharArray();
        Arrays.sort(s1array);
        Arrays.sort(s2array);*/

        Map<Character,Integer> cm = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            Character c = s1.charAt(i);
            Integer cn = cm.get(c);
            if(cn==null){
                cn=1;
            }else{
                cn=cn+1;
            }
            cm.put(c,cn);
        }

        for(int j =0; j <s2.length() ;j++){
            Character c = s2.charAt(j);
            Integer cn = cm.get(c);
            if(cn==null){
                return false;
            }else{
                cn=cn-1;
            }
            cm.put(c,cn);
        }

        boolean[] flag ={true};
        cm.forEach((k,v) -> {
            if(v!=0){
                 flag[0]=false;

            }
        });

        if(flag[0]==false){
            return false;
        }
        return  true;
    }

    public static  void main(String[] args){
        //isAnagram("dogi","good");
       // String []group = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String []group = {};

        System.out.println(groupAnagrams(group));
    }


    //---------------------better solution
    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> result=new ArrayList();
        if(strs.length==0)return result;
        Map<String,List<String>> map=new HashMap();
        for(String str:strs) {
            String sorted=sortedString(str);
            List<String> value = map.getOrDefault(sorted,new ArrayList());
            value.add(str);
            map.put(sorted,value);
        }

        for(Map.Entry<String,List<String>> entries:map.entrySet()){
            result.add(entries.getValue());
        }
        return result;
    }
    private String sortedString(String s){
        char[] ch=s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}
