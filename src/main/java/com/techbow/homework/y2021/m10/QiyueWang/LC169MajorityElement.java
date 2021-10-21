package com.techbow.homework.y2021.m10.QiyueWang;
// Boyer-Moore Voting Algorithm
// https://leetcode-cn.com/problems/majority-element/solution/duo-shu-yuan-su-by-leetcode-solution/
// 投票法正确思路：不妨假设整个数组的众数记做a，则最初的数组中a的数量大于其余所有数。当采用count计数的时候有两种情况：

// 1）假设candidate等于a，则当count从1变为0的过程，此区间内a的数量等于其余数的数量，因此以count=0为分界线，数组右端部分的众数仍然为a

// 2）假设candidate不等于a，则当count从1变为0的过程， 此区间内a的数量小于等于其余数的数量，因此以count=0为分界线，数组右端部分的众数仍然为a

// 因此，以count=0可以将整个原始数组分为若干部分，count=0右端部分的数组中的众数永远是a，最终必然会筛选出a

public class LC169MajorityElement {
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int count = 1;
        for(int i = 1; i < n; i++){
            if(count == 0){
                res = nums[i];
            }
            if(nums[i] == res){
                count ++;
            }else{
                count --;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 7, 7, 7, 7};
        int[] nums2 = new int[]{7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 5, 5, 5, 5};
        System.out.println(majorityElement(nums)); // 7
        System.out.println(majorityElement(nums2)); // 5
    }
}
// time O(N) space O(1)