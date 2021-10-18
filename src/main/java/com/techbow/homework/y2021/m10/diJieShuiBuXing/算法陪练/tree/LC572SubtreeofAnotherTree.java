package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.tree;

import dfsBfs.TreeNode;

/**
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 *
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,4,5,1,2], subRoot = [4,1,2]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the root tree is in the range [1, 2000].
 * The number of nodes in the subRoot tree is in the range [1, 1000].
 * -104 <= root.val <= 104
 * -104 <= subRoot.val <= 104
 */
public class LC572SubtreeofAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
         if( root == null && subRoot == null){
             return true;
         }

         if(root == null || subRoot == null){
             return false;
         }

        return isSame(root,subRoot) ? true : isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    private boolean isSame(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null){
            return true;
        }

        if(root == null || subRoot == null || root.val != subRoot.val){
            return false;
        }

        return isSame(root.right,subRoot.right) && isSame(root.left,subRoot.left);
    }


    //follow up:
    //if is a part of tree
//区别是不用走到leaf node，只要subtree为null的时候，root==null 或者root！=null 都是有效case
    public boolean isPartTree(TreeNode root, TreeNode subRoot) {
        if( root == null && subRoot == null){
            return true;
        }

        if(root == null && subRoot != null){//小树没走完，大树走完了
            return false;
        }

        return isPart(root,subRoot) ? true : isPartTree(root.left,subRoot) || isPartTree(root.right,subRoot);
    }

    private boolean isPart(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null){
            return true;
        }

        if(root == null && subRoot != null //小树没走完，大树走完了
                || root.val != subRoot.val){
            return false;
        }

        return isPart(root.right,subRoot.right) && isPart(root.left,subRoot.left);
    }
}
