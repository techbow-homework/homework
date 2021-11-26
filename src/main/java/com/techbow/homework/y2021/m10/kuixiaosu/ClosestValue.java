package com.techbow.homework.y2021.m10.kuixiaosu;

public class ClosestValue {
    public int closestValue(TreeNode root, double target) {
        if (root == null) return root;
        TreeNode cur = root;
        int res = 0;
        while (cur != null) {
            if (cur.val == target) return cur.val;
            else if (Math.abs(cur.val - target) < Math.abs(res - target) {
                res = cur.val;
            }
		else if (cur.val > target) cur = cur.left;
            else cur = cur.right;
        }
        return res;
    }
}
