package com.techbow.homework.y2021.m11.shengyuan;

import java.util.Stack;

public class LC_536 {
    public TreeNode str2tree(String s) {
        // corner case
        if (s == null || s.length() == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            char c = s.charAt(i);
            //遇到右括號要從Stack pop出來，回到上一層
            if (c == ')') {
                stack.pop();
            } else if (c >= '0' && c <= '9' || c == '-') {
                //判斷是否大於兩位數
                while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    i++;
                }
                String sub = s.substring(j, i + 1);
                TreeNode cur = new TreeNode(Integer.valueOf(sub));
                if (!stack.isEmpty()) {
                    TreeNode parent = stack.peek();
                    if (parent.left != null) {
                        parent.right = cur;
                    } else {
                        parent.left = cur;
                    }
                }
                stack.push(cur);
            }
        }
        return stack.peek();
    }
}
