package com.techbow.homework.y2021.m10.ryanxu.LC_300.v2;

import java.util.ArrayList;
import java.util.List;

public class LC_300v2 {

    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        List<Integer> bucket = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (bucket.size() == 0) {
                bucket.add(nums[i]);
            } else if (nums[i] > bucket.get(bucket.size() - 1)) {
                bucket.add(nums[i]);
            } else {
                updateBusket(bucket, nums, nums[i]);
            }
        }

        return bucket.size();
    }

    private void updateBusket(List<Integer> bucket, int[] nums, int num) {

        int start = 0;
        int end = bucket.size() - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (bucket.get(mid) < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        bucket.set(start, num);
    }

    public static void main(String[] args) {
        LC_300v2 lc_300v2 = new LC_300v2();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lc_300v2.lengthOfLIS(nums));
    }
}
