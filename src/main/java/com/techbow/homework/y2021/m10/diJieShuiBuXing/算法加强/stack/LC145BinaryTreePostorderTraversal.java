package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法加强.stack;

import dfsBfs.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 * Example 4:
 *
 *
 * Input: root = [1,2]
 * Output: [2,1]
 * Example 5:
 *
 *
 * Input: root = [1,null,2]
 * Output: [2,1]
 *
 *
 * Constraints:
 *
 * The number of the nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 */
public class LC145BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode prev = null, cur = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if (prev == null ||prev.left == cur || prev.right == cur){
                if(cur.left != null){
                    stack.push(cur.left);
                }else if (cur.right !=  null){
                    stack.push(cur.right);
                }else{
                    res.add(stack.pop().val);
                }
            }else if( prev == cur.left){
                if(cur.right != null) {
                    stack.push(cur.right);
                }else{
                    res.add(stack.pop().val);
                }
            }else if ( prev == cur.right){
                res.add(stack.pop().val);
            }
            prev = cur;
        }
        return res;
    }

}
