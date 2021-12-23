package com.techbow.homework.y2021.m10.ryanxu.LC_894;

import com.techbow.homework.y2021.m10.ryanxu.Library.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC_894 {
    public List<TreeNode> allPossibleFBT(int n) {

        List<TreeNode> res = new ArrayList<>();
        if (n % 2 == 0) {
            return res;
        }

        return dfs(n);
    }

    private List<TreeNode> dfs(int numOfNode) {

        List<TreeNode> res = new ArrayList<>();
        if (numOfNode == 1) {
            res.add(new TreeNode(0));
            return res;
        }

        for (int k = 1; k < numOfNode - 1; k += 2) {
            List<TreeNode> l = dfs(k);
            List<TreeNode> r = dfs(numOfNode - k - 1);
            for (TreeNode leftNode : l) {
                for (TreeNode rightNode : r) {
                    TreeNode root = new TreeNode(0);
                    root.left = leftNode;
                    root.right = rightNode;
                    res.add(root);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LC_894 lc_894 = new LC_894();
        int n = 7;
        System.out.println(lc_894.allPossibleFBT(n));
    }
}
