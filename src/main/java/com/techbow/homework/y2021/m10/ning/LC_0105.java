package com.techbow.homework.y2021.m10.ning;

/* Thought process: use preorder array to locate root, use for loop to find root index in inorder array,
and do partition to construct tree recursively. for optimization, use O(n) time to build hashmap
to store inorder <value,index> info for quick lookup, instead of O(n) time for loop in each recursion. */

/* time: O(n) = build hashmap O(n) + construct tree O(n)
   space: O(n) = build hashmap O(n) (if considering system stack, depends on height of the tree,
          worst case O(n), amortized case O(logn)  */
public class LC_0105 {
    Map<Integer, Integer> inorderIndexMap;
    int preorderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 ||
                inorder == null || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }

        // build hashmap to store <value, index> relations for future use
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        preorderIndex = 0;
        return buildTree(preorder, 0, preorder.length - 1);
    }
    private TreeNode buildTree(int[] preorder, int left, int right) {
        // if there are no elements to construct the tree
        if (left > right) return null;

        // select preorder index element as the root and increment it
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        // build left right subtree
        // excluding inorderIndexMap(rootVal) element since its the root
        root.left = buildTree(preorder, left, inorderIndexMap.get(rootVal) - 1);
        root.right = buildTree(preorder, inorderIndexMap.get(rootVal) + 1, right);

        return root;
    }
}
