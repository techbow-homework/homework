package com.techbow.homework.y2021.m10.mengyu;

import com.techbow.homework.y2021.m09.mengyu.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC559HeightOfNnaryTree {
    List<Integer> heights = new ArrayList<>();
    public int heightOfNTree (Node root) {
        if (root == null) return 0;
        if (root.children.isEmpty()) return 1;:
        for (Node node : root.children) {
            heights.add(heightOfNTree(node));
        }
        return Collections.max(heights);
    }
}
