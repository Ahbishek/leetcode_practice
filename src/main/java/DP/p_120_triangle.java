package DP;

import java.util.List;

public class p_120_triangle {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        if (n == 1) {
            return triangle.get(0).get(0);
        } else if (n == 0) {
            return 0;
        }

        int m = triangle.get(n - 1).size();
        int[][] arr = new int[n][m];

        for (int i = 0; i < m; i++) {
            arr[n - 1][i] = triangle.get(n - 1).get(i);
        }


        for (int j = n - 2; j >= 0; j--) {

            for (int i = 0; i < triangle.get(j).size(); i++) {
                arr[j][i] = triangle.get(j).get(i) + Math.min(arr[j + 1][i], arr[j + 1][i + 1]);
            }

        }

        return arr[0][0];
    }
}
