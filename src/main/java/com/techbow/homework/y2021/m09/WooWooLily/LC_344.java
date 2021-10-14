package com.techbow.homework.y2021.m09.WooWooLily;

//Reverse String, two pointer or recursion
public class LC_344 {
    //output none reverse in place
    public void reverseString(char[] s) {
        //two pointer method

        int left = 0, right = s.length - 1;
        while (left < right) {
            //swap begining and end
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}
