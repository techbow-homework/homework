package com.techbow.homework.y2021.m09.jiale.oa;

import java.util.*;

public class Third {
    public int solution(int N) {
        List<Integer> allFives = getAllFives(N);
        int res = Integer.MIN_VALUE;
        for (Integer index : allFives){
            res = Math.max(res, calculate(N, index));
        }
        return res;
    }

    private Integer calculate(int N, int index) {
        int flag = N < 0 ? -1 : 1;
        N = Math.abs(N);
        String nStr = String.valueOf(N);
        char[] charArr = new char[nStr.length()];
        for (int i = 0; i < nStr.length(); i++) {
            charArr[charArr.length - i - 1] = nStr.charAt(i);
        }
        System.out.println(charArr.toString());
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        for (int i = charArr.length - 1; i > index; i--) {
            right.append(charArr[i]);
        }
        for (int i = index - 1; i >= 0; i--) {
            left.append(charArr[i]);
        }
        int rNum = Integer.parseInt(right.toString());
        int lNum = Integer.parseInt(left.toString());
        if (flag == 1) {
            return (int) (rNum * Math.pow(10, index) + lNum);
        } else {
            return -1 * (int) (rNum * Math.pow(10, index) + lNum);
        }
    }

    private List<Integer> getAllFives(int N) {
        String nStr = String.valueOf(N);
        List<Integer> res = new ArrayList<>();
        char[] charArr = nStr.toCharArray();
        Collections.reverse(Arrays.asList(charArr));
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '5') {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Third().solution(15958));
    }
}
