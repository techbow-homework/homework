package com.techbow.homework.y2021.m11.mengyu;

import java.util.Arrays;

public class LC0268MissingNum {
            /*
public int missingNumber(int[] nums) {
    Arrays.sort(nums);
    if (nums[0] != 0) {
        return 0;
    }
    if (nums[nums.length - 1] != nums.length) {
        return nums.length;
    }
    for (int i = 0; i < nums.length; i++) {
        if (nums[i + 1] - nums[i] != 1) {
            return i + 1;
        }
    }
    return -1;
}
//Time: sort --> O(NlogN)
//      for --> O(N)
//Space: O(1)
 */
/*
public int missingNumber(int[] nums) {
    int noMissingSum = nums.length * (1 + nums[nums.length - 1]) / 2;
    int sum = 0;
    for (int num : nums) {
        sum = sum + num;
    }
    return noMissingSum - sum;
}
//Time: iterate through nums --> O(N)
//Space: O(1)
 */
/*
public int missingNumber(int[] nums) {
    Set<Integer> numSet = new HashSet<Integer>();
    for (int num : nums) numSet.add(num);
    for (int number = 0; number <= nums.length; number++) {
        if (!numSet.contains(number)) {
            return number;
        }
    }
    return -1;
}
//Time: set add nums --> O(N) +
//      find dup --> O(N)
//Space: extra set O(N)
 */
    public int missingNumber(int[] nums) {
        // 0 2 3 4 5 6
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1, mid = 0;
        if (nums[0] != 0) return 0;
        if (nums[nums.length - 1] != nums.length) return nums.length;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid + 1] - nums[mid] == 2) {
                return mid + 1;
            }
            if (nums[mid] - nums[mid - 1] == 2) {
                return mid;
            }
            if (nums[mid] != mid) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return -1;
    }
    //Time: sort --> O(NlogN)
    //      binary search --> log(N)
    //Space O(1)
}

