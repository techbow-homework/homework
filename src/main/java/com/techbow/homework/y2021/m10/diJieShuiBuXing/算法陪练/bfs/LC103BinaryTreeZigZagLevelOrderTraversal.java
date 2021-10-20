package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.bfs;

import dfsBfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
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
 * -100 <= Node.val <= 100
 */
public class LC103BinaryTreeZigZagLevelOrderTraversal {
    //bfs
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

                while (size-- > 0) {
                    TreeNode cur = queue.poll();
                    if(level %2 == 0) {
                        list.add(0, cur.val);
                    }else{
                        list.add(cur.val);
                    }

                    if(cur.left!= null){
                        queue.offer(cur.left);
                    }

                    if(cur.right != null){
                        queue.offer(cur.right);
                    }
            }
                level++;
                res.add(list);
        }
        return res;
    }

    public List<List<Integer>> zigzagLevelOrder_dfs(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null){
            return res;
        }
        helper(root,0,res);
        return res;
    }

    private void helper(TreeNode root, int level, List<List<Integer>> res) {
        if(root == null){
            return;
        }
        if (level == res.size()){
            res.add(new ArrayList<>());
        }

        if(level %2 !=0){
            res.get(level).add(0,root.val);
        }else{
            res.get(level).add(root.val);
        }
        helper(root.left,level+1,res);
        helper(root.right,level+1,res);
    }
}
