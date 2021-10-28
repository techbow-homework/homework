package com.techbow.homework.y2021.m10.ning;

/*
constraints:
2 <= nums.length <= 10^4
only one valid answer
 */

public class LC_0001 {
    // S0: brute force, traverse all possible combinations and see if it equals to target
    // time: O(n^2)
    // space: O(1)

    // S1: sort + two pointers(left, right)
    // time: O(nlogn + n)
    // space: O(1)

    // S2: hashmap
    // time: O(n)
    // space: O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
