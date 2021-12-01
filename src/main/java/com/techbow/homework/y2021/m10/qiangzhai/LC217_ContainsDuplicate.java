package com.techbow.homework.y2021.m10.qiangzhai;

public class LC217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        //cc
        if (nums == null || nums.length == 0) return false;
        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            if (!set.add(n)) return true;
        }
        return false;
    }

}
