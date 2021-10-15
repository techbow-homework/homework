package com.techbow.homework.y2021.m10.jiale.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 * <p>
 * idea: maintain a hashtable, key is the element in the array, and the value is the index of the element in the array. For each value in the array, we check hashtable to see if the value of the element we have already visited and if the difference is less than equal k
 *
 * Complexity: O(n)
 */
public class LC_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null && Math.abs(map.get(nums[i]) - i) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
