package com.techbow.homework.y2021.m10.Sammy;

import java.util.Stack;

public class LC449_SerializeBST {
    public class Codec {
        //encode a tree into a String
        public String serialize(TreeNode root){
            if(root == null) return "";
            Stack<TreeNode> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            while(root != null){
                sb.append(root.val).append(",");
                if(root.right != null) stack.push(root.right);
                if(root.left == null && !stack.isEmpty()){
                    root = stack.pop();
                } else {
                    root = root.left;
                }
            }
            return sb.toString();
        }
        public TreeNode deserialize(String data) {
            if(data.equals("")) return null;
            String[] token = data.split(",");

            Stack<TreeNode> stack = new Stack<>();

            TreeNode root = new TreeNode(Integer.parseInt(token[0]));
            stack.push(root);
            for(int i = 1; i < token.length; i++) {
                TreeNode parent = stack.peek();
                TreeNode next = new TreeNode(Integer.parseInt(token[i]));

                if(next.val < parent.val) parent.left = next;
                else{
                    parent = stack.pop();

                    while(!stack.isEmpty() && next.val > stack.peek().val){
                        parent = stack.pop();
                    }
                    parent.right = next;
                }
                stack.push(next);
            }
            return root;
        }
    }
}
