package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonContinuousSubarray {
    public static List<String> longestSubarray(String[] s1, String[] s2){
        int l1 = s1.length;
        int l2 = s2.length;
        if(l1 == 0 || l2 == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        int count = 0;
        int[] maxInd = new int[2];
        int[][] mem = new int[l1][l2];
        for(int i = 0; i < l1; i++){
            for(int j = 0; j < l2; j++){
                if(s1[i].equals(s2[j])){
                    if(i == 0 || j == 0){
                        mem[i][j] = 1;
                    }else{
                        mem[i][j] = mem[i - 1][j - 1] + 1;
                    }
                    if(mem[i][j] > count){
                        count = mem[i][j];
                        maxInd = new int[]{i,j};
                    }
                }
            }
        }
        //System.out.println(maxInd[0] +" " + maxInd[1]);
        for(int i = maxInd[0] - count + 1; i < maxInd[0] + 1; i++){
            res.add(s1[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] s1 = new String[]{"3234.html", "xys.html", "7hsaa.html"};
        String[] s2 = new String[]{"3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html"};
        System.out.println(longestSubarray(s1, s2)); //["xys.html", "7hsaa.html"]
        System.out.println(longestSubarray(s2, s2));
        String[] s3 = new String[]{"a", "a", "a","b","c","d","e"};
        String[] s4 = new String[]{"a","b", "c", "a", "d", "a","a"};
        System.out.println(longestSubarray(s3, s4)); //[a, b, c]
    }
}
