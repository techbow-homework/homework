package com.techbow.homework.y2021.m10.shengyuan;

import java.util.HashMap;
import java.util.Map;

public class LC_1 {
    //Method1: Brute force
    public int[] twoSum(int[] array, int target) {
        if (array == null || array.length == 0) {
            return null;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }
    //Method2: HashMap
    public int[] twoSumI(int[] array, int target) {
        if (array == null || array.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }
        for (int i = 0; i < array.length; i++) {
            int diff = target - array[i];
            if (map.containsKey(diff) && map.get(diff) != i) {
                return new int[] {i, map.get(diff)};
            }
        }
        return null;
    }
    public static void main(String[] args) {
        LC_1 test = new LC_1();
        int[] input = {2, 7, 11, 15};
        int target = 9;
        int[] result = test.twoSum(input, target);
        System.out.println(result);
    }
}
