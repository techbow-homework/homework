package com.techbow.homework.y2021.m11.mengyu;

import com.techbow.homework.y2021.m09.mengyu.TreeNode;

import java.util.*;

public class BFS_Related {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> levelResult = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                levelResult.add(cur.val);
            }
            result.add(levelResult);
        }
        return result;
    }
    /*
    public List<List<Integer>> followUp1UsingDFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

    }

    private void dfs(TreeNode root, Li) {
        if (root == null) return;

    }
    */
    public List<List<Integer>> LC107levelOrderBottomFollowUp2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelResult = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                levelResult.add(cur.val);
            }
            map.put(level, levelResult);
            level++;
        }
        result = new ArrayList<>(map.values());
        Collections.reverse(result);
        return result;
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();
        nodeQueue.offer(root);
        colQueue.offer(0);
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;
        //-inf       +inf
        //       0
        while (!nodeQueue.isEmpty()) {
            TreeNode cur = nodeQueue.poll();
            int col = colQueue.poll();
            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);
            if (!map.containsKey(col)) {
                ArrayList<Integer> valList  = new ArrayList<>();
                valList.add(cur.val);
                map.put(col, valList);
            } else {
                map.get(col).add(cur.val);
            }
            if (cur.left != null) {
                nodeQueue.offer(cur.left);
                colQueue.offer(col - 1);
            }
            if (cur.right != null) {
                nodeQueue.offer(cur.right);
                colQueue.offer(col + 1);
            }

        }
        for (int i = minCol; i < maxCol; i++) {
            result.add(map.get(i));
        }
        return result;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    /*
    3
  9   20
     15 7

     9 20
     */
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> deque = new LinkedList<>();
        int level = 0;
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            ArrayList<Integer> levelRes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur;
                if (level % 2 == 0) {
                    cur = deque.pollFirst();
                    if (cur.left != null) {
                        deque.offerLast(cur.left);
                    }
                    if (cur.right != null) {
                        deque.offerLast(cur.right);
                    }
                } else {
                    cur = deque.pollLast();
                    if (cur.right != null) {
                        deque.offerFirst(cur.right);
                    }
                    if (cur.left != null) {
                        deque.offerFirst(cur.left);
                    }
                }
                levelRes.add(cur.val);
            }
            level++;
            result.add(levelRes);
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        BFS_Related test = new BFS_Related();
        System.out.println(test.zigzagLevelOrder(root).toString());
    }
}
