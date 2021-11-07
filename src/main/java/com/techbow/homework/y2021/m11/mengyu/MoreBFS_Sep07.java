package com.techbow.homework.y2021.m11.mengyu;

import com.techbow.homework.y2021.m09.mengyu.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MoreBFS_Sep07 {
    public boolean validateCompleteBinaryTree(TreeNode root) {
        if (root == null) return true;
    boolean isNull = false;
    Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
        TreeNode cur = queue.poll();
        if (cur != null) {
            if (!isNull) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                return false;
            }
        } else {
            isNull = true;
        }
    }
        return true;
}
    public boolean validateCompleteBinaryTree2 (TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isNull = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                if (isNull) return false;
                queue.offer(cur.left);
            } else {
                isNull = true;
            }
            if (cur.right != null) {
                if (isNull) return false;
                queue.offer(cur.right);
            } else {
                isNull = true;
            }
        }
        return true;
    }
    //
    //public void validateCompleteBinaryTree3 (TreeNode root) {
    //    //Math
    //    return;
    //}
    //
    public boolean LC785isBipartite(int[][] graph) {
        int[] mark = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (mark[i] != 0) continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            mark[i] = 1;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                int[] neighbors = graph[cur];
                for (int neighbor : neighbors) {
                    if (mark[neighbor] == 0) {
                        mark[neighbor] = -mark[cur];
                        queue.offer(neighbor);
                    } else {
                        if (mark[cur] == mark[neighbor]) {
                            return false;
                        }
                    }

                }
            }
        }
        return true;
    }

    public static final int[][] DIRECTIONS = {{0,1},{0,-1},{-1,0},{1,0}};
    public void wallsAndGatesLC286(int[][] rooms) {
        int row = rooms.length - 1;
        int col = rooms[0].length - 1;
        int minDistance = 1;
        Queue<int[]> queue = new LinkedList<>();
        loadGates(rooms, queue);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] direction : DIRECTIONS) {
                    int nextRow = cur[0] + direction[0];
                    int nextCol = cur[1] + direction[1];
                    if ( nextCol < 0 || nextRow < 0 || nextCol > col || nextRow > row ||
                            rooms[nextRow][nextCol] != Integer.MAX_VALUE ) {
                        continue;
                    } else {
                        queue.offer(new int[] {nextRow, nextCol});
                        rooms[nextRow][nextCol] = minDistance;
                    }
                }
            }
            minDistance++;
        }
    }
    private void loadGates (int[][] rooms, Queue<int[]> queue) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        //root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        MoreBFS_Sep07 test = new MoreBFS_Sep07();
        int[][] wallTest = {{2147483647,0,2147483647,2147483647,0,2147483647,-1,2147483647}};

        test.wallsAndGatesLC286(wallTest);
        System.out.println(Arrays.deepToString(wallTest));
    }
}
