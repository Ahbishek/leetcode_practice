package Algo;

public class ZigZag {
    public static String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        Character carr[][] = new Character[numRows][s.length()];

        boolean up = false;
        int i = 0;
        int j = 0;

        for (int m = 0; m < s.length(); m++) {

            if (i < numRows && !up) {
                carr[i][j] = s.charAt(m);
                i++;
            }

            if (i < numRows && up) {
                carr[i][j] = s.charAt(m);
                i--;
                j++;
            }

            if (i == numRows) {
                up = true;
                i = i - 2;
                j++;
            }

            if (i == 0) {
                up = false;
            }
        }
        StringBuilder sb = new StringBuilder();

       // StringBuilder sb = new StringBuilder();
        for (int m = 0; m < numRows; m++) {

            for (int n = 0; n < s.length(); n++) {


                if (carr[m][n] != null) {
                    sb.append(carr[m][n]);
                    //   System.out.print((carr[m][n]));
                } else {
                    //    System.out.print(" ");

                }

            }
            //  System.out.println("");
        }
        return sb.toString();

    }

    public static void main(String[] args) {

        System.out.println(ZigZag.convert("PAYPALISHIRING", 1));
    }
}
