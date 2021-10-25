package com.techbow.homework.y2021.m10.mengyu;


import com.techbow.homework.y2021.m09.mengyu.TreeNode;

import java.util.ArrayList;

public class LC590postOrderNnaryTree {
    public ArrayList<Integer> postorderNTree(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }
    private void postorder(Node root, ArrayList<Integer> result) {
        if (root == null) return;
        for (Node node : root.children) {
            postorder(node, result);
        }
        result.add(root.val);
    }
}
