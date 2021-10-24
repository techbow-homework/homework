package com.techbow.homework.y2021.m10.QiyueWang;

public class LC2048NextGreaterNumericallyBalancedNumber {
    public static int nextBeautifulNumber(int n) {
        while(true){
            n ++;
            if(isBalanced(n)){
                return n;
            }
        }
        //System.out.println(isBalanced(22));
        //return 0;
    }
    private static boolean isBalanced(int n){
        int[] count = new int[10];
        String s = String.valueOf(n);
        for(int i = 0; i < s.length(); i++){
            count[ s.charAt(i) - '0']++;
        }
        //System.out.println(Arrays.toString(count));
        for(int i = 0; i < 10; i++){
            if(count[i] != 0 && count[i] != i) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 1;
        int n2 = 1000;
        int n3 = 3000;
        System.out.println(nextBeautifulNumber(n));//22
        System.out.println(nextBeautifulNumber(n2));//1333
        System.out.println(nextBeautifulNumber(n3));//3133
    }
}
