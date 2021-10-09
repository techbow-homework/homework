package com.techbow.homework.y2021.m10.QiyueWang;

import java.util.ArrayList;
import java.util.List;

public class LC6ZigzagConversion {
    public static String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int n = s.length();
        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < Math.min(n, numRows); i++){
            rows.add(new StringBuilder());
        }
        int index = 0;
        int dir = -1; // 1 going down, -1 going up
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            rows.get(index).append(c);
            if(index == 0 || index == numRows - 1) dir = -dir;
            index += dir;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder sb : rows){
            res.append(sb);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        String s2 = "AB";
        int nR = 3;
        int nR2 = 4;
        System.out.println(convert(s,nR)); // "PAHNAPLSIIGYIR"
        System.out.println(convert(s,nR2)); // "PINALSIGYAHRPI"
        System.out.println(convert(s2,nR2)); // "AB"
    }
}
// time O(N) space O(N)


