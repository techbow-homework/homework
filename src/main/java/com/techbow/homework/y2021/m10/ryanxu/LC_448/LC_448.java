package com.techbow.homework.y2021.m10.ryanxu.LC_448;

import java.util.ArrayList;
import java.util.List;

public class LC_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }

        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            while (nums[i - 1] != i && nums[i - 1] != nums[nums[i - 1] - 1]) {
                swap(i - 1, nums);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] != i) {
                res.add(i);
            }
        }

        return res;
    }

    private void swap(int a, int[] nums) {

        int temp = nums[a];
        nums[a] = nums[temp - 1];
        nums[temp - 1] = temp;
    }

    public static void main(String[] args) {
        LC_448 lc_448 = new LC_448();
        int[] nums = {3, 1, 2};
        System.out.println(lc_448.findDisappearedNumbers(nums));
    }
}
