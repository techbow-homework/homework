package com.techbow.homework.y2021.m11.QiyueWang;
// return number of ways to pick a pair of number from a[], such that i < j and a[i] + a[j] is divisible by k.
public class SumDivisibleByK {
    public static int numDivisible(int[] a, int k){
        int[] numResidual = new int[k]; // index for residual of num / k, value for number of nums at this residual
        int res = 0;
        for(int i : a){
            int residual = i % k;
            if(residual == 0){
                res += numResidual[0];
            }else{
                res += numResidual[k - residual];
            }
            numResidual[residual] += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};
        System.out.println(numDivisible(a, 3));// 4
    }
}
