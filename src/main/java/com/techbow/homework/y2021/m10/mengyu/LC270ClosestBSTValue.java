package com.techbow.homework.y2021.m10.mengyu;

import com.techbow.homework.y2021.m09.mengyu.TreeNode;

public class LC270ClosestBSTValue {
    public int closestValue(TreeNode root, double target) {
        /*
        t = 3.2
        4
      2   5
     1 3
        */
        int currentClosest = root.val;
        while (root != null) {
            if (Math.abs(currentClosest - target) <= Math.abs(root.val - target)) {
                currentClosest = currentClosest;
            } else {
                currentClosest = root.val;
            }
            if (root.val < target) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return currentClosest;
    }
}
