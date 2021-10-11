package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_270 {
    public int closestValue(TreeNode root, double target) {
        int val;
        int closest = root.val;
        while (root != null) {
            val = root.val;
            closest = Math.abs(target - closest) < Math.abs(target - val) ? closest : val;
            root = target < val ? root.left : root.right;
        }
        return closest;
    }
}
