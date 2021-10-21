package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.tree;

import dfsBfs.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 * Example 2:
 * <p>
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 105].
 * -1000 <= Node.val <= 1000
 */
public class LC111MinimumDepthofBinaryTree {

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if(left == 0 || right == 0){ // 如果有一个孩子是0，但是另外一个孩子不是0，他们的parent的min 应该是不是0的那个孩子+1；如果不写corner case，这个值就成了 0 + 1 了，不对
            return left + right + 1;
        }

        return Math.min(left,right)+1;
    }

}
