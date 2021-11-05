/** root = [1, 3, 2, 5, 3, null, 9] --> [1, 3, 9]
 *  root = [1, 2, 3] --> [1, 3]
 *  root = [1, null, 2] --> [1, 2]
 */
package com.techbow.homework.y2021.m10.shengyuan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_515 {
    //Method1: BFS
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.value > max) {
                    max = node.value;
                }
            }
            list.add(max);
        }
        return list;
    }
    //Method2: DFS
    public List<Integer> largestValuesI(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, result, 0);
        return result;
    }
    private void dfs(TreeNode node, List<Integer> result, int level) {
        //base case
        if (node == null) {
            return;
        }
        if (result.size() == level) {
            result.add(node.value);
        } else {
            result.set(level, Math.max(result.get(level), node.value));
        }
        dfs(node.left, result, level + 1);
        dfs(node.right, result, level + 1 );
    }

    public static void main(String[] args) {
        LC_515 test = new LC_515();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        List<Integer> result = test.largestValues(root);
        System.out.println(result);
    }
}
