package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_700 {
            if (root == null) return null;
         TreeNode curr = root;
        while (curr != null) {
        if (curr.val == val) return curr;
        else if (curr.val < val) curr = curr.right;
        else curr = curr.left;
    }
        return curr;
}
}
