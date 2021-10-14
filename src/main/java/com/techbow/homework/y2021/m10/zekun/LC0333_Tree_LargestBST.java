package com.techbow.homework.y2021.m10.zekun;

public class LC0333_Tree_LargestBST {
    private class Result{
        public int min, max, size;
        public Result(int min, int max, int size){
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }
    private int maxSize = 0;
    public int largestBSTSubtree(TreeNode root) {
        dfsHelper(root);
        return maxSize;
    }
    private Result dfsHelper(TreeNode root){
        if(root == null) return new Result(0,0,0);
        Result left = dfsHelper(root.left);
        Result right = dfsHelper(root.right);
        if(left == null || right == null) return null;
        int size = 1;
        if((left.size == 0 || left.max < root.val) && (right.size == 0 || right.min > root.val)){
            size = left.size + 1 + right.size;
            maxSize = Math.max(maxSize, size);
        } else{
            return null;
        }
        int min = (left.size > 0) ? left.min : root.val;
        int max = (right.size > 0) ? right.max : root.val;
        return new Result(min, max, size);
    }
}
