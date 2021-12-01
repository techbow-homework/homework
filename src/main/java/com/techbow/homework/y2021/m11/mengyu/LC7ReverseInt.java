package com.techbow.homework.y2021.m11.mengyu;

public class LC7ReverseInt {
    public int reverse(int x) {
        //123 --> 321
        long res = 0;
        while (x != 0) {
            res *= 10;
            res += x % 10;
            x /= 10;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        return (int)res;
    }

    public static void main(String[] args) {
        LC7ReverseInt test = new LC7ReverseInt();
        int x = 1534236469;
        System.out.println(test.reverse(x));
    }

    //follow up reverse double

}
