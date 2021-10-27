package com.techbow.homework.y2021.m10.jiale.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */
public class LC_217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        Set<Integer> set = new HashSet<>();
        for (int each : nums) {
            if (set.contains(each)) {
                return true;
            } else {
                set.add(each);
            }
        }
        return false;
    }
}
