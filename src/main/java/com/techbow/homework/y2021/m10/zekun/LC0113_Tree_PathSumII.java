package com.techbow.homework.y2021.m10.zekun;

import java.util.ArrayList;
import java.util.List;

public class LC0113_Tree_PathSumII {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //cc
        if(root == null) return res;
        dfsHelper(root, targetSum);
        return res;
    }

    private void dfsHelper(TreeNode root, int targetSum){
        //base case
        if(root == null) return;
        path.add(root.val);//add current root value to path
        targetSum = targetSum - root.val; //reduce  the targetSum by current value

        if(root.left == null && root.right == null && targetSum == 0){//check if we have reach the targetSum
            res.add(new ArrayList<Integer>(path));

        }

        dfsHelper(root.left, targetSum);
        dfsHelper(root.right, targetSum);
        path.remove(path.size()-1);
    }
}
