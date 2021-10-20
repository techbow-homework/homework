package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int size = triangle.size();
        int[] result = new int[size + 1];
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                result[j] = Math.min(result[j], result[j+1]) + triangle.get(i).get(j);
            }
        }
        return result[0];
    }
}
