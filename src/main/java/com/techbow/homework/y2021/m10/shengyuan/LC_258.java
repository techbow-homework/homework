package com.techbow.homework.y2021.m10.shengyuan;

public class LC_258 {
    public int addDigits(int num) {
        if (num < 0) {
            num = num * -1;
        }
        int sum = getEach(num);
        int newSum;
        if (sum / 10 != 0) {
            newSum = getEach(sum);
        } else {
            return sum;
        }
        return newSum;
    }
    private int getEach(int input) {
        int sum = 0;
        while (input != 0) {
            sum += input % 10;
            input /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        LC_258 test = new LC_258();
        System.out.println(test.addDigits(38));
        System.out.println(test.addDigits(1));
        System.out.println(test.addDigits(102));
    }
}
