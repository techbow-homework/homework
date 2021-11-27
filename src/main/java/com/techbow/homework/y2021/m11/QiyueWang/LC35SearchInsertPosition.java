package com.techbow.homework.y2021.m11.QiyueWang;

public class LC35SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if(n == 1){
            return target <= nums[0] ? 0 : 1;
        }
        int l = 0;
        int r = n - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1,3,5,6};
        System.out.println(searchInsert(nums1, 5)); //2
        System.out.println(searchInsert(nums1, 2));//1
        System.out.println(searchInsert(nums1, 0)); // 0
        System.out.println(searchInsert(nums1, 7));//4
    }
}
// (1) At this point, low > high. That is, low >= high+1
// (2) From the invariant, we know that the index is between [low, high+1], so low <= high+1. Follwing from (1), now we know low == high+1.
// (3) Following from (2), the index is between [low, high+1] = [low, low], which means that low is the desired index
//     Therefore, we return low as the answer. You can also return high+1 as the result, since low == high+1
