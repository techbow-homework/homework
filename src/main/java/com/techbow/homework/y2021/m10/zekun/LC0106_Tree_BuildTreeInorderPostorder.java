package com.techbow.homework.y2021.m10.zekun;

import java.util.Map;

public class LC0106_Tree_BuildTreeInorderPostorder {
    private Map<Integer, Integer> indexMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //cc
        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0);
        for(int i = 0; i < postorder.length; i++){
            indexMap.put(inorder[i], i);
        }

        TreeNode ans = new TreeNode();
        ans = treeBuilder(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        return ans;
    }

    private TreeNode treeBuilder(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd){
        if(iEnd < iStart || pEnd < pStart) return null;

        int treeVal = postorder[pEnd];
        TreeNode root = new TreeNode(treeVal);
        int inRootInd = indexMap.get(treeVal);

        int numLeftNode = inRootInd - iStart;//get how many nodes at the left

        root.left = treeBuilder(inorder, iStart, inRootInd - 1, postorder, pStart, pStart + numLeftNode - 1);
        root.right = treeBuilder(inorder, inRootInd + 1, iEnd, postorder, pStart + numLeftNode, pEnd);
        return root;
    }
}
