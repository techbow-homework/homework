package com.techbow.homework.y2021.m10.zekun;

public class LC0012_IntegerToRoman {
    public String integerToRoman(int num) {
        int[] numArray = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanWord = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        //每一步都使用当前对应阿拉伯数字较大的罗马数字作为加法因子，最后得到罗马数字表示就是长度最少的
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numArray.length; i++){
            while(num >= numArray[i]){
                sb.append(romanWord[i]);
                num -= numArray[i];
            }
        }
        return sb.toString();
    }
}
