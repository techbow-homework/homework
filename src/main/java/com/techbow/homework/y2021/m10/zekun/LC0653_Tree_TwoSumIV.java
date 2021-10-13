package com.techbow.homework.y2021.m10.zekun;

public class LC0653_Tree_TwoSumIV {
    class Solution {
        private Stack<TreeNode> initialLeft(TreeNode root){
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            return stack;
        }
        private void lPlus(Stack<TreeNode> stack){
            TreeNode top = stack.pop();
            TreeNode next = top.right;
            while(next != null){
                stack.push(next);
                next = next.left;//repeat the step of build left stack, push all left node to the stack
            }
        }

        private Stack<TreeNode> initialRight(TreeNode root){
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while(cur != null){
                stack.push(cur);
                cur = cur.right;
            }
            return stack;
        }
        private void rMinus(Stack<TreeNode> stack){
            TreeNode top = stack.pop();
            TreeNode next = top.left;
            while(next != null){
                stack.push(next);
                next = next.right;
            }
        }

        public boolean findTarget(TreeNode root, int k) {
            //cc
            Stack<TreeNode> stackL = initialLeft(root);
            Stack<TreeNode> stackR = initialRight(root);

            while(!stackL.isEmpty() && !stackR.isEmpty()){
                TreeNode l = stackL.peek();
                TreeNode r = stackR.peek();
                if(l != null && r != null){
                    if(l == r) return false;
                    if(l.val + r.val == k){
                        return true;
                    }else if(l.val + r.val < k){
                        lPlus(stackL);
                    }else{
                        rMinus(stackR);
                    }
                }
            }
            return false;
        }
    }
}
