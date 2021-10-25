package com.techbow.homework.y2021.m10.ning;

/*
constraints:
number of nodes in this range [0, 5*10^4]
guaranteed complete tree
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
}
public class LC_0222 {
    // S1: brute force - linear time, but not profit from complete tree
    // time: O(n)
    // space: O(logn) - recursion stack tree depth
//    public int countNodes(TreeNode root) {
//        return root != null ? 1 + countNodes(root.right) + countNodes(root.left) : 0;
//    }

    // S2: binary search
    /*
    complete tree: for every level, except the last level, is completely filled, for the last
    level all nodes are as far left as possible. so for kth level (not the last one), it has
    2^k nodes, and for the last level, the number of tree nodes should vary from 1 to 2^h, h
    is the tree height. the height of tree can be found by just going left until left is null
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        // if left == right, it means its not the last level so we can easily compute
        // the number of nodes by knowing height. otherwise we count nodes for the last level.
        if (left == right) return countNodes(root.right) + (1 << left);
        else return countNodes(root.left) + (1 << right);
    }
    private int getHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }
}
