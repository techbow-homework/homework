package com.techbow.homework.y2021.m10.ning;

public class LC_0106 {
    Map<Integer, Integer> inorderIndexMap;
    int postorderIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 ||
                postorder == null || postorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }

        // build hashmap to store <value, index> relations for future use
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        // start from the last postorder element
        postorderIndex = postorder.length - 1;
        return buildTree(postorder, 0, postorder.length - 1);
    }
    private TreeNode buildTree(int[] postorder, int left, int right) {
        // if there are no elements to construct the tree, return null
        if (left > right) return null;

        // select postorder index element as the root and increment it
        int rootVal = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootVal);

        // build left right subtree
        // excluding inorderIndexMap(rootVal) element since its the root
        root.right = buildTree(postorder, inorderIndexMap.get(rootVal) + 1, right);
        root.left = buildTree(postorder, left, inorderIndexMap.get(rootVal) - 1);

        return root;
    }
}
