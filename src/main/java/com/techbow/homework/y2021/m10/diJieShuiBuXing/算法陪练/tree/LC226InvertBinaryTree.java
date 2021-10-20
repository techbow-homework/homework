package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.tree;


import dfsBfs.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * Example 2:
 *
 *
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */

//先recursion后办事
    //且必须cache
public class LC226InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }

        TreeNode left = invertTree(root.left);//此处必须cache，因为不然的话 root.right = invertTree(root.left); 就会导致下面的recursion右枝是错的root.right
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }


    public TreeNode invertTree_bst(TreeNode root) {
        if(root == null){
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        TreeNode cur = null;

        while(!queue.isEmpty()){
            cur = queue.poll();

            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;

            if(cur.left!=null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
        return root;
    }
}
