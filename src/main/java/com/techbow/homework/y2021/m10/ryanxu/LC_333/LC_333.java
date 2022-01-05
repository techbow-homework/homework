package com.techbow.homework.y2021.m10.ryanxu.LC_333;

import Library.TreeNode;

public class LC_333 {

    private static class Cell {
        private int minVal;
        private int maxVal;
        private boolean isBST;
        private int size;

        public Cell() {}
        public Cell(int minVal, int maxVal, boolean isBST, int size) {
            this.minVal = minVal;
            this.maxVal = maxVal;
            this.isBST = isBST;
            this.size = size;
        }
    }

    public int largestBSTSubtree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }

    private Cell dfs(TreeNode node,  int[] res) {

        if (node == null) {
            return new Cell(0, 0, true, 0);
        }

        Cell left = dfs(node.left, res);
        Cell right = dfs(node.right, res);
        if (!left.isBST || !right.isBST) {
            return new Cell(0, 0, false, 0);
        }

        Cell cell = new Cell();
        if ((left.size == 0 || left.maxVal < node.val) && (right.size == 0 || right.minVal > node.val)) {
            cell.minVal = left.size == 0 ? node.val : left.minVal;
            cell.maxVal = right.size == 0 ? node.val : right.maxVal;
            cell.size = left.size + right.size + 1;
            cell.isBST = true;
        }
        res[0] = Math.max(res[0], cell.size);
        return cell;
    }

    public static void main(String[] args) {
        LC_333 lc_333 = new LC_333();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(lc_333.largestBSTSubtree(root));
    }
}
