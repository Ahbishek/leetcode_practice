package Leetcode_datastructures.DFS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class p_743_Bellman_Ford {
}
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {

        // Using Bellman-Ford
        //src to dest cha min cost sathi.

        int nlen = times.length;
        if(nlen==0){
            return -1;
        }

        int[]dist = new int[N+1];
        for(int i=0;i<=N;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[0]=0;      //palceholder  we are creating 1 index array. 0 is useless
        dist[K]=0;

        Set<Integer> setsPostive = new HashSet<Integer>();
        // to see if all nodes are visited.
        setsPostive.add(K);
        int max = -99;

        for(int j=0;j<nlen;j++){
            for(int i=0 ;i<nlen ;i++){
                int u = times[i][0];
                int v = times[i][1];
                int w = times[i][2];

                if(dist[u]!=Integer.MAX_VALUE && (dist[u]+w) < dist[v]){
                    dist[v]=dist[u]+w;
                    setsPostive.add(v);
                }

            }
        }

        int dupN = setsPostive.size();
        if(dupN!=N){
            return -1;
        }
        max = Arrays.stream(dist).max().getAsInt();

        return max;


    }
}