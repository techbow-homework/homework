package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.ArrayList;
import java.util.List;

public class LC129SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, new ArrayList<>(), res);
        int sum = 0;
        for(List<Integer> l : res){
            sum += parse(l);
            //System.out.println(l.toString());
        }
        return sum;
    }

    private void dfs(TreeNode root, List<Integer> cur, List<List<Integer>> res){

        cur.add(root.val);
        if(root.left != null){
            dfs(root.left, cur, res);
        }
        if(root.right != null){
            dfs(root.right, cur, res);
        }
        if(root.left == null && root.right == null){
            res.add(new ArrayList<Integer>(cur));
        }
        cur.remove(cur.size() - 1);
    }
    private int parse(List<Integer> l){
        int num = 0;
        for(int i : l){
            num = num * 10 + i;
        }
        return num;
    }
}
