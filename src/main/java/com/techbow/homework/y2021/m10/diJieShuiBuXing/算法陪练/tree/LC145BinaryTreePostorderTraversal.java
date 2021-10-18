package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.tree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class LC145BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        postorder(root,res);
        return res;
    }

    private void postorder( TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }

        postorder(root.left,res);
        postorder(root.right,res);
        res.add(root.val);
    }

    //post-order 是左右上，所以revert应该是上右左，那我们就按上右左遍历加入结果，然后reverse
    public List<Integer> postorderTraversal_stack1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()){
            if(root != null ){
                res.add(root.val);
                stack.push(root);// preorder
                root = root.right; //因为是中右左，所以先加右
            }else{
                root = stack.pop();
                root = root.left;//因为是中右左，所以后加左
            }
        }
        Collections.reverse(res); //reverse
        return res;
    }

    //因为post的遍历顺序是左右中
    //在当它是从它的右子树上来的时候就证明左右已经走完了，加过了，此时把它加入结果
    //cur = stack.peek();
    //一个node可以有三种状态
    // 当他的prev是parent时候，证明它刚从上面开始往下遍历，它的左右还都没有遍历过，不是结果。所以需要先把左右入栈；记得要看子树是不是null，如果都是null，则证明已经遍历完了，他是一个有效结果，加入栈；
    // 当他的prev是左孩子时候，证明该遍历右孩子了；记得要看右子树是不是null，如果都是null，则证明已经遍历完了，他是一个有效结果，加入栈；
    // 当他的prev右孩子的时候就证明它的左右已经遍历过了，现在就是它本身该加入接过的时候

    public List<Integer> postorderTraversal_stack(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            TreeNode prev = null, cur = null;

            while(!stack.isEmpty()){
                cur = stack.peek();
                if(prev == null || prev.left == cur || prev.right == cur){
                    if(cur.left != null){
                        stack.push(cur.left);
                    }else if( cur.right != null){
                        stack.push(cur.right);
                    }else{
                        res.add(stack.pop().val);
                    }
                }else if ( prev == cur.left){
                    if(cur.right != null){
                        stack.push(cur.right);
                    }else{
                        res.add(stack.pop().val);
                    }
                }else{//prev = cur.right;
                    res.add(stack.pop().val);
                }
                prev = cur;
            }

            return res;
        }

    }
