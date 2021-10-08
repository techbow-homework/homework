package com.techbow.homework.y2021.m10.zekun;

import java.util.ArrayList;
import java.util.List;

public class LC0257_DFS_BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;

        dfsHelper(root, res, "");
        return res;
    }

    private void dfsHelper(TreeNode root, List<String> res, String s){
        //base case
        if(root == null) return;

        StringBuilder sb = new StringBuilder(s);
        sb.append(Integer.toString(root.val));
        if(root.left == null && root.right == null) {
            res.add(sb.toString());
            return;
        }else{
            sb.append("->");
            dfsHelper(root.left, res, sb.toString());
            dfsHelper(root.right, res, sb.toString());
        }
    }
}
