package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.tree.BST;

import dfsBfs.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 描述
 * 给定一个二叉查找树和范围[k1, k2]。按照升序返回给定范围内的节点值。
 * <p>
 * 样例
 * 样例 1：
 * <p>
 * 输入：
 * <p>
 * tree = {5}
 * k1 = 6
 * k2 = 10
 * 输出：
 * <p>
 * []
 * 解释：
 * <p>
 * 没有数字介于6和10之间
 * <p>
 * 样例 2：
 * <p>
 * 输入：
 * <p>
 * tree = {20,8,22,4,12}
 * k1 = 10
 * k2 = 22
 * 输出：
 * <p>
 * [12,20,22]
 * 解释：
 * <p>
 * [12,20,22]介于10和22之间
 */

//https://www.lintcode.com/problem/11/
public class LT11SearchRangeInBST {
    //1。
    // iteration
    // 用stack的inorder 模版改动，进栈时候，按照root的val，对比k1,k2值选择叉入栈
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if(root != null){
                //cover [k1,k2] R
                if(root.val > k2){
                    root = root.left;
                }else if(root.val < k1){//cover R [k1,k2]
                    root = root.right;
                }else {//cover [k1, R ,k2]
                    stack.push(root);
                    root = root.left;
                }
            }else{
                root = stack.pop();
                if(root.val<= k2 && root.val>=k1){//出站时候inorder的位置，验证，只要是有效的就加入
                    res.add(root.val);
                }
                root = root.right;
            }
        }
        return res;
    }

// recursion

    List<Integer> res = new ArrayList<>();
    public List<Integer> searchRange_r(TreeNode root, int k1, int k2) {

        searchHelper(root,k1,k2);
        return res;
    }

    private void searchHelper(TreeNode root, int k1, int k2){
        if(root == null){
            return;
        }

        //剪枝 限制进入条件
        ////cover 2种条件：[k1,k2] R 和 [k1,R,k2]
        if(root.val > k1){
            searchHelper(root.left,k1,k2);
        }
        //此处拉出一个可以处理inorder 的空间，来处理

        if(root.val>=k1 && root.val <=k2){
            res.add(root.val);
        }

        //

        // 剪枝 限制进入条件
        ////cover 2种条件：R [k1,k2] 和 [k1,R,k2]
        if(root.val < k2){
            searchHelper(root.right,k1,k2);
        }
    }
}
