package com.techbow.homework.y2021.m10.Sammy;

public class LC270_ClosestBST {
    public int closestValue(TreeNode root, double target) {

        return dfs(root, target, root.val);
    }
    private int dfs(TreeNode root, double target, int closest){
        if(root == null) return closest;
        if(Math.abs(root.val - target) < Math.abs(closest - target)){
            closest = root.val;
        }
        if(root.val < target){
            closest = dfs(root.right, target, closest);
        } else {
            closest = dfs(root.left, target, closest);
        }
        return closest;
    }
}
