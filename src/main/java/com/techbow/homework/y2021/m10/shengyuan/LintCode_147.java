package com.techbow.homework.y2021.m10.shengyuan;

/** Determine if a range of number are Narcissistic number (水仙花數)
 *  ex1: 153 = 1^3 + 5^3 + 3^3 --> True
 *  ex2: 1634 = 1^4 + 6^4 + 3^4 + 4^4 --> True
 *  ex2: 11 != 1^2 + 1^2 --> False
 *
 */
public class LintCode_147 {
    //Method1: 數學問題: 1. 如何判斷幾位數? 2. 如何取出每個數字
    public boolean ifNarcissistic(int n) {
        int m = n;
        int sum = 0;
        int count = digitCount(n);
        while (m != 0) {
            int number = m % 10;
            sum += Math.pow(number, count);
            m /= 10;
        }
        if (sum == n) {
            return true;
        } else {
            return false;
        }
    }
    private int digitCount(int n) {
        int count = 0;
        while (n != 0) {
            n /= 10;
            count++;
        }
        return count;
    }
    //Method2: 利用toString來得到位數和個別數字
    public boolean ifN(int n) {
        int[] array = intToArray(n);
        int length = array.length;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += (int)Math.pow(array[i], length);
        }
        if (sum == n) {
            return true;
        } else {
            return false;
        }
    }
    private int[] intToArray(int n) {
        String str = Integer.toString(n);
        int length = str.length();
        int[] array = new int[length];
        int i = 1;
        while (n != 0) {
            array[length - i] = n % 10;
            n /= 10;
            i++;
        }
        return array;
    }
    public static void main(String[] args) {
        LintCode_147 test = new LintCode_147();
        int n = 5;
        int m = 200;
        for (int i = n; i <= m; i++) {
            if (test.ifN(i)) {
                System.out.println(i);
            }
        }
    }
}
