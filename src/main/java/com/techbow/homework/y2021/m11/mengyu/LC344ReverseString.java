package com.techbow.homework.y2021.m11.mengyu;

public class LC344ReverseString {
    public void reverseString (char[] s) {
        //"abacd" --> "dcba"
        int pointerLeft = 0;
        int pointerRight = s.length - 1;
        while(pointerLeft < pointerRight) {
            char temp = s[pointerLeft];
            s[pointerLeft++] = s[pointerRight];
            s[pointerRight--] = temp;
        }
    }
}
