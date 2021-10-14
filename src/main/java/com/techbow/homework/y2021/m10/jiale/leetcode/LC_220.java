package com.techbow.homework.y2021.m10.jiale.leetcode;

import java.util.TreeSet;

/**
 * Given an integer array nums and two integers k and t, return true if there are two distinct indices i and j in the array such that abs(nums[i] - nums[j]) <= t and abs(i - j) <= k.
 * <p>
 * We maintain a balance binary search tree with max size k. For each element in nums, we check the if absolute value of the difference of cur element and its successor/predecessor is less or equal than t.
 * <p>
 * loop invariant: for each iteration in the loop, we graduate the index interval is less than k.
 * <p>
 * Complexity: O(nlogk) n iteration, logk for tree operation in each iteration.
 */
public class LC_220 {
    public boolean containsNearbyAlmostDuplicate(long[] nums, int k, int t) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long successor = treeSet.ceiling(nums[i]);
            if (successor != null && Math.abs(successor - nums[i]) <= t) {
                return true;
            }
            Long predecessor = treeSet.floor(nums[i]);
            if (predecessor != null && Math.abs(predecessor - nums[i]) <= t) {
                return true;
            }
            treeSet.add(nums[i]);
            if (treeSet.size() > k) {
                treeSet.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        long[] num = {-2147483648, 2147483647};
        System.out.println(new LC_220().containsNearbyAlmostDuplicate(num, 1, 1));

        System.out.println(Math.abs(-2147483648 - 2147483647));

        // leetcode 用 int[] 输入 对于
        // test case [-2147483648, 2147483647], 1, 1 不通过  -> Math.abs(-2147483648 - 2147483647) 对于int 返回是1
    }
}
