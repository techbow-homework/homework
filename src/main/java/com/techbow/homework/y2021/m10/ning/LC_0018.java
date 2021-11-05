package com.techbow.homework.y2021.m10.ning;

/*
constraints:
1 <= nums.length <= 200
 */

public class LC_0018 {
    // S0: four for loops to find all possible combinations time: O(n^3) space: O(1)

    // S1: sort + two pointers(inspired by 3Sum, we implement k-2 outer for loops and when k == 2, call 2Sum)
    // time: O(n^k-1) --> O(n^3)
    // space: O(n)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }
    public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();

        if (start == nums.length) {
            return res;
        }

        int avgVal = target / k;
        if (nums[start] > avgVal || avgVal > nums[nums.length - 1]) {
            return res;
        }

        if (k == 2) {
            return twoSum(nums, target, start);
        } else {
            for (int i = start; i < nums.length - k + 1; i++) {
                // reduce to k-1sum
                List<List<Integer>> temp = kSum(nums, target - nums[i], i + 1, k - 1);
                if (temp != null) {
                    for (List<Integer> t : temp) {
                        t.add(0, nums[i]);
                    }
                    res.addAll(temp);
                }
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }
    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int left = start, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target || (left > start && nums[left - 1] == nums[left])) {
                left++;
            } else if (sum > target || (right < nums.length - 1 && nums[right] == nums[right + 1])) {
                right--;
            } else {
                res.add(Arrays.asList(nums[left++], nums[right--]));
            }
        }
        return res;
    }

    // S2:
}
