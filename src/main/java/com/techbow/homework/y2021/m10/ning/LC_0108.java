package com.techbow.homework.y2021.m10.ning;

/*
constraints:
1. 1 <= nums.length <= 10^4
2. nums sorted in strictly increasing order --> no duplicates
 */

/*
time: O(n) -- visit each node once
space: O(logn) -- recursion stack requires logn space since tree is balanced
 */
public class LC_0108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        // cc
        return BSTHelper(nums, 0, nums.length - 1);
    }
    private TreeNode bstHelper(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left)/2;
        int rootVal = nums[mid];
        TreeNode root = new TreeNode(rootVal);
        root.left = bstHelper(nums, left, mid - 1);
        root.right = bstHelper(nums, mid + 1, right);
        return root;
    }
}
