package com.techbow.homework.y2021.m10.zekun;

public class LC0105_Tree_BuildTreePreInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //cc
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        return buildHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end){
        if(i_start > i_end) return null;
        int rootVal = preorder[p_start];
        TreeNode root = new TreeNode(rootVal);

        int inorder_root_ind = 0;
        for(int i =  i_start; i < i_end; i++){
            if(inorder[i] == rootVal){
                inorder_root_ind = i;
                break;
            }
        }

        root.left = buildHelper(preorder, p_start + 1, p_start + 1 + inorder_root_ind - 1 - i_start, inorder, i_start, inorder_root_ind - 1);
        root.right = buildHelper(preorder, p_start + inorder_root_ind - i_start + 1, p_end, inorder, inorder_root_ind + 1, i_end);
        return root;

    }
}
