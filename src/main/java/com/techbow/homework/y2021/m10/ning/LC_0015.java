package com.techbow.homework.y2021.m10.ning;

/*
constraints:
0 <= nums.length <= 3000
 */

public class LC_0015 {
    // thought process: this is a follow-up question of 2Sum, we may reuse the existing solutions and
    // make some tweaks to accommodate 3Sum requirements. based on 2Sum solutions, we know the best
    // time complexity is O(n), so for 3Sum it sounds reasonable to shoot O(n^2) as our best TC.

    // S1: sort + two pointers(enumerate each value in a single loop, then two pointers for the rest array)
    // time: O(nlogn + n^2) --> O(n^2)
    // space: depends on the implementation of the sorting algorithm
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSumII(nums, i, res);
            }
        }
        return res;
    }
    private void twoSumII(int[] nums, int i, List<List<Integer>> res) {
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                res.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
            }
        }
    }

    // S2: hashset
    // time: O(n^2)
    // space: O(n)
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSum(nums, i, res);
            }
        }
        return res;
    }
    private void twoSum(int[] nums, int i, List<List<Integer>> res) {
        Set<Integer> set = new HashSet<>();
        for (int j = i + 1; j < nums.length; j++) {
            int complement = -nums[i] - nums[j];
            if (set.contains(complement)) {
                res.add(Arrays.asList(nums[i], nums[j], complement));
                while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            set.add(nums[j]);
        }
    }
}
