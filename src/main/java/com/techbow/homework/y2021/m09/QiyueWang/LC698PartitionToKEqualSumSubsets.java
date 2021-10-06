package com.techbow.homework.y2021.m09.QiyueWang;

public class LC698PartitionToKEqualSumSubsets {
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int maxNum = 0;
        for(int num : nums){
            sum += num;
            maxNum = Math.max(num, maxNum);
        }
        if(sum % k != 0) return false;
        int avg = sum / k;
        if(maxNum > avg) return false;
        boolean[] used = new boolean[n];

        return dfs(nums, 0, 0, avg, k, used);
    }

    private static boolean dfs(int[] nums, int index, int curSum, int avg, int k, boolean[] used){
        if(k == 0) return true;
        if(curSum == avg) {
            return dfs(nums, 0, 0, avg, k - 1, used);
        }

        for(int i = index; i < nums.length; i++){
            if(!used[i] && curSum + nums[i] <= avg){
                curSum += nums[i];
                used[i] = true;
                if(dfs(nums, i + 1, curSum, avg, k, used)) return true;
                curSum -= nums[i];
                used[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {4,3,2,3,5,2,1};
        int[] nums2 = new int[] {1,2,3,4};
        int[] nums3 = new int[] {2,2,2,2,3,4,5};
        System.out.println(canPartitionKSubsets(nums, 4)); //expect true
        System.out.println(canPartitionKSubsets(nums2, 3)); //expect false
        System.out.println(canPartitionKSubsets(nums3, 4)); //expect false
    }
}
