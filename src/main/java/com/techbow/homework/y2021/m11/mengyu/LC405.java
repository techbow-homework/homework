package com.techbow.homework.y2021.m11.mengyu;

public class LC405 {
    public String toHex(int num) {
        if (num == -1) return "ffffffff";
        char[] Hex = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        String res = "";
        int original = num;
        if (num < 0) {
            num *= -1;
        }
        while (num != 0) {
            res = res + Hex[num % 16];
            num /= 16;
        }
        res = new StringBuilder(res).reverse().toString();
        if (original < 0) {
            return "-" + res;
        } else {
            return res;
        }
    }
}
