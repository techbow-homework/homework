package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.HashMap;
import java.util.Map;

public class LC106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> m = new HashMap<>();
        int n = inorder.length;
        for(int i = 0; i < n; i++){
            m.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, n - 1, 0, n - 1, m);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int il, int ir, int pl, int pr, Map<Integer, Integer> m){
        if(il > ir || pl > pr ) return null;
        TreeNode root = new TreeNode(postorder[pr]);
        int indexIr = m.get(postorder[pr]);// root index in inorder
        int leftTreeSize = indexIr -  il;
        int rightTreeSize = ir - indexIr;
        root.left = buildTree(inorder, postorder, il, indexIr - 1, pl, leftTreeSize + pl - 1, m);
        root.right = buildTree(inorder, postorder, indexIr + 1, ir, pl + leftTreeSize, pr - 1, m);
        return root;
    }
}
// time O(N) space O(N)
