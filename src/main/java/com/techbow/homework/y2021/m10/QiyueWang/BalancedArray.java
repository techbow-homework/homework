package com.techbow.homework.y2021.m10.QiyueWang;

import java.util.Arrays;
import java.util.List;

// output the first index that the sum of both parts are equal
public class BalancedArray {
    public static int balancedSum(List<Integer> arr) {
        // Write your code here
        int n = arr.size();
        int[] prefix = new int[n];
        prefix[0] = arr.get(0);
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr.get(i);
        }
        for (int i = 1; i < n; i++) {
            if (prefix[i] == prefix[n - 1] - prefix[i - 1]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] A = new Integer[]{1,2,3,3};
        List<Integer> arr = Arrays.asList(A);
        System.out.println(balancedSum(arr)); //2
    }
}
