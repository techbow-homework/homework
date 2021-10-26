package com.techbow.homework.y2021.m10.ning;

/*
constraints:
1 <= n <= 8
 */

public class LC_0095 {
    public List<TreeNode> generateTrees(int n) {
        // cc
        return generateTrees(1, n);
    }
    private LinkedList<TreeNode> generateTrees(int start, int end) {
        LinkedList<TreeNode> res = new LinkedList<>();
        if (start > end) {
            res.add(null);
            return res;
        }

        for (int i = start; i <= end; i++) {
            LinkedList<TreeNode> leftTree = generateTrees(start, i - 1);
            LinkedList<TreeNode> rightTree = generateTrees(i + 1, end);
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = left;
                    cur.right = right;
                    res.add(cur);
                }
            }
        }
        return res;
    }
}
