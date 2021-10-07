package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.sort;

public class LC50Pow {
         public double myPow_bruteForce(double x, int n) {
         if (n == 0) return 1;
         if (n == 1) return x;
         boolean isNegative = false;

         if (n < 0) {
              x = 1/x;
              isNegative = true;
              n = -(n+1);
         }
         double ans = 1;
         double temp = x;

         while(n!=0){
             if(n%2 ==1){
                 ans *= temp;
             }
             temp *=temp;
             n/=2;
         }
         if(isNegative){
             ans *=x;
         }
         return ans;
     }

    public static double myPow(double x, int n) {
        if(n ==1) return x;
        if (n==0) return 1;
        boolean isNegative = false;
        if(n < 0){
            n = -(n+1);
            isNegative = true;
            x = 1/x;
        }

        double half = myPow(x,n/2);
        double res = 0;
        if( n % 2 == 0){
            res = half*half;
        }else{
            res = half * half * x;
        }

        if(isNegative){
            return res *= x;
        }else{
            return res;
        }
    }
}
