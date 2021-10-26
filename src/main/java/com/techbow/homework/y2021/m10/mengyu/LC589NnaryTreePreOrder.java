package com.techbow.homework.y2021.m10.mengyu;

import java.util.ArrayList;
import java.util.List;

public class LC589NnaryTreePreOrder {
    List<Integer> result = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) return result;
        result.add(root.val);
        for (Node child : root.children) {
            preorder(child);
        }
        return result;
    }
}
