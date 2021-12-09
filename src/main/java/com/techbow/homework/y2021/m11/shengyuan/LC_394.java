package com.techbow.homework.y2021.m11.shengyuan;

public class LC_394 {
    public String decodeString(String s) {
        //cc
        if (s == null || s.length() == 0) {
            return s;
        }
        int[] pos = {0};
        return decodeString(s, pos);
    }
    private String decodeString(String s, int[] pos) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (int i = pos[0]; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } else if (ch == '[') {
                pos[0] = i + 1;
                String next = decodeString(s, pos);
                for (int n = num; n > 0; n--) {
                    sb.append(next);
                }
                num = 0;
                i = pos[0];
            } else if (Character.isLetter(ch)) {
                sb.append(ch);
            } else if (s.charAt(i) == ']') {
                pos[0] = i;
                return sb.toString();
            } else {
                throw new IllegalArgumentException("come up with an unknown letter");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        LC_394 test = new LC_394();
        String str = "3[a]2[bc]";
        String res = test.decodeString(str);        //aaabcbc
        System.out.println(res);
    }
}
