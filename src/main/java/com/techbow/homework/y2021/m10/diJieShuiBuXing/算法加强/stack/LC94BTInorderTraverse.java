package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法加强.stack;

import dfsBfs.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


//先把左边的node全放进去stack，然后pull出来的时候打印，如果cur是null证明到leaf了，将stack pop，并让cur=cur.right 把这个node的右子树再按照之前的顺序加进栈
public class LC94BTInorderTraverse {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;

        while(cur!=null || !stack.isEmpty()){ // 2 conditions, one for init, one for break
            if( cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }

        return res;
    }
}
