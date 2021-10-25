package com.techbow.homework.y2021.m10.LianjiangHe.BinarySearch;
/*
*在题设条件下是否保证有这样的peak元素出现呢？我觉得显然是有的。不妨利用反证法：假设这样的peak元素不存在，则对于nums[0]和nums[n-1]，由于它们旁边各有一个比它们小的元素（nums[-1]和nums[n]），为了保证peak元素不存在，必有nums[0] < nums[1]和nums[n-2] > nums[n-1]。然后以此类推，即可推出矛盾。

通过上述方法大概可以想到一种二分的思路。选择i = n/2，判断是否满足nums[i-1] < nums[i] > nums[i+1]：

如果满足，则显然i就是满足要求的peak元素
否则，如果nums[i-1] < nums[i] < nums[i+1]，则必存在一个peak元素位于[i+1, n-1]范围中
如果nums[i-1] > nums[i] > nums[i+1]，则必存在一个peak元素位于[0, i-1]范围中
如果nums[i-1] > nums[i] < nums[i+1]，则i两侧都可能存在peak元素
* */
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int len = right;
        if (len > 0){
            while(left < right){
                int mid = left + (right - left)/2;
                if (nums[mid] > nums[mid + 1]) {
                    right = mid;
                }else{
                    left = mid + 1;
                }
            }
        }else{
            return 0;
        }
        return left;
    }
}