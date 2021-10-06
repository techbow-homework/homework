package com.techbow.homework.y2021.m09.shengyuan;

import java.util.ArrayList;
import java.util.List;

public class LC_118 {
    public List<List<Integer>> pascalTriangle(int numRows) {
        final List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    //頭尾加1
                    list.add(1);
                } else {
                    //前一行的結果加到新的結果中，dp[i - 1][j - 1] + dp[i - 1][j]
                    list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(list);
        }
        return result;
    }
    //test case
    public static void main(String[] args) {
        LC_118 test = new LC_118();
        int input = 6;
        List<List<Integer>> result = test.pascalTriangle(input);
        System.out.println(result);
    }
}
