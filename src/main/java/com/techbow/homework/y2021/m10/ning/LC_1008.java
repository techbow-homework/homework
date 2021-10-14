package com.techbow.homework.y2021.m10.ning;

/*
constraints:
1. 1 <= preorder.length <= 100
2. all values in preorder are unique
 */
public class LC_1008 {
    // S1: preorder + inorder -- straightforward
    // time: O(nlogn) sort preorder array + O(n) construct tree
    // space: O(n) hashmap + O(n) build tree
//    Map<Integer, Integer> inorderIndexMap;
//    int preorderIndex;
//    public TreeNode bstFromPreorder(int[] preorder) {
//        int[] inorder = Arrays.copyOf(preorder, preorder.length);
//        Arrays.sort(inorder);
//
//        inorderIndexMap = new HashMap<>();
//        for (int i = 0; i < inorder.length; i++) {
//            inorderIndexMap.put(inorder[i], i);
//        }
//
//        preorderIndex = 0;
//        return bstHelper(preorder, 0, preorder.length - 1);
//    }
//    private TreeNode bstHelper(int[] preorder, int left, int right) {
//        // if there are no elements to construct the tree
//        if (left > right) return null;
//
//        // select preorder index element as the root and increment it
//        int rootVal = preorder[preorderIndex++];
//        TreeNode root = new TreeNode(rootVal);
//
//        // build left right subtree
//        // excluding inorderIndexMap(rootVal) element since its the root
//        root.left = bstHelper(preorder, left, inorderIndexMap.get(rootVal) - 1);
//        root.right = bstHelper(preorder, inorderIndexMap.get(rootVal) + 1, right);
//
//        return root;
//    }

    // S2: recursion optimizing O(nlogn) to O(n)
    // time: O(n)
    // space: O(n)
    int index;
    public TreeNode bstFromPreorder(int[] preorder) {
        // cc
        index = 0;
        return bstHelper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private TreeNode bstHelper(int[] preorder, int lowerBound, int upperBound) {
        // base case
        if (index == preorder.length) return null;
        int val = preorder[index++];
        if (val < lowerBound || val > upperBound) return null;

        // recursion
        TreeNode root = new TreeNode(val);
        root.left = bstHelper(preorder, lowerBound, val);
        root.right = bstHelper(preorder, val, upperBound);

        return root;
    }
}
