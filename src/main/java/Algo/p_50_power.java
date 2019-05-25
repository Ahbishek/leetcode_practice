package Algo;

public class p_50_power {
    public static double myPow(double x, int n) {
//directly use   return Math.pow(x,n); in exam or if interview
// and asked to implement your own method then use below code


        double MOD = 1000000007;
        double res=1;
        int ex = Math.abs(n);
        //spl handling for INT_MIN , as mod function returns same no for INT_MIN;
        if(n== -2147483648 && x>1){
            return 0;
        }else if (n== -2147483648 && x==1){
            return 1;
        }
        //fastest to calculate pow
        while(ex>0){

            if(ex%2==1){res = (res*x) % (MOD);}
            x = (x*x)%(MOD);
            ex=ex/2;
        }
        //  return res;
        return n>0?res:(1/res);

    }
    public static  void main(String[]args){
        myPow(2.00000,-2147483648);
    }


}
