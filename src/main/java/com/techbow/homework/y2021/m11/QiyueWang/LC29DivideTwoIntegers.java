package com.techbow.homework.y2021.m11.QiyueWang;

public class LC29DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        if(divisor == Integer.MIN_VALUE){
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }

        int positive = 1;
        if(dividend < 0){
            positive *= -1;
            dividend = Math.abs(dividend);
        }
        if(divisor < 0){
            positive *= -1;
            divisor = Math.abs(divisor);
        }

        int res = 0;
        for(int i = 31; i >= 0; i--){// from large to small
            if((dividend >>> i) - divisor >= 0){ // intended overflow when dividend = 2 ^ 31 so it can go into the if statement
                //System.out.println((dividend >>> i) + " i: " + i);
                res += 1 << i; // divisor * i each time
                dividend -= divisor << i;// substract the divided part
            }
        }
        //System.out.println(Math.abs(1 << 31) >>> 1);
        return res * positive;
    }

//     public int divide(int A, int B) {
//         if (A == 1 << 31 && B == -1) return (1 << 31) - 1;
//         int a = Math.abs(A), b = Math.abs(B), res = 0;
//         //System.out.println((-4) >> 1);
//         for (int x = 31; x >= 0; x--)
//             if ((a >>> x) - b >= 0) {
//                 System.out.println((a >>> x) + " x : " + x + "  " + Integer.toBinaryString(a >>> x)+ " b: " + b);
//                 System.out.println((a >> x) + " x : " + x  + "  " + Integer.toBinaryString(a >> x) + " b: " + b);
//                 res += 1 << x;
//                 a -= b << x;
//             }
//         return (A > 0) == (B > 0) ? res : -res;
//     }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1109186033)); // 1
        System.out.println(divide(-2147483648, -109186033)); // 19
        System.out.println(divide(10, 3)); // 3
        System.out.println(divide(7,-3)); // -2
    }

}
// time O(32) space O(1)
