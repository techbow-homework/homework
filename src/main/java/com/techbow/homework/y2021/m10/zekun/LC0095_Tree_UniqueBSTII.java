package com.techbow.homework.y2021.m10.zekun;

public class LC0095_Tree_UniqueBSTII {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        //cc
        if(n <= 0) return res;
        if(n == 1) return Arrays.asList(new TreeNode(n));

        return dfsHelper(1, n);
    }

    private List<TreeNode> dfsHelper(int start, int end){
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(start > end) {
            res.add(null);
            return res;
        }

        for(int i = start; i <= end; i++){
            List<TreeNode> lefts = dfsHelper(start, i - 1);
            List<TreeNode> rights = dfsHelper(i + 1, end);
            for(TreeNode left : lefts){
                for(TreeNode right : rights){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
