package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.bfs;


import dfsBfs.TreeNode;

import java.util.*;

/**
 * Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[15,7],[9,20],[3]]
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 */
public class LC107BinaryTreeLevelOrderTraversalII {


    //bfs
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                list.add(cur.val);

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(0, list);
        }
        return res;
    }


    //dfs
    public List<List<Integer>> levelOrderBottom_dfs(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        level_traversal(root, 0, res);
        Collections.reverse(res);
        return res;
    }

    private void level_traversal(TreeNode root, int level, List<List<Integer>> res) {
        if(root == null){
            return;
        }

        if(level == res.size()){
            res.add(new ArrayList<>());
        }

        res.get(level).add(root.val);
//        res.get(res.size() - level -1).add(root.val); // res.size() - level -1 is always 0

        level_traversal(root.left,level + 1 ,res);
        level_traversal(root.right,level + 1 ,res);
    }
}
