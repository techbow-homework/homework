//package com.techbow.homework.y2021.m10.jiale.leetcode;
//
///**
// * Binary Vertical order traversal
// */
//
//import com.techbow.homework.y2021.m09.jiale.common.TreeNode;
//import javafx.util.Pair;
//
//import java.util.*;
//
//
//class LC_314 {
//    public List<List<Integer>> verticalOrder(TreeNode root) {
//        List<List<Integer>> output = new ArrayList();
//        if (root == null) {
//            return output;
//        }
//
//        Map<Integer, ArrayList> columnTable = new HashMap();
//        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque();
//        int column = 0;
//        queue.offer(new Pair(root, column));
//
//        while (!queue.isEmpty()) {
//            Pair<TreeNode, Integer> p = queue.poll();
//            root = p.getKey();
//            column = p.getValue();
//
//            if (root != null) {
//                if (!columnTable.containsKey(column)) {
//                    columnTable.put(column, new ArrayList<Integer>());
//                }
//                columnTable.get(column).add(root.val);
//
//                queue.offer(new Pair(root.left, column - 1));
//                queue.offer(new Pair(root.right, column + 1));
//            }
//        }
//
//        List<Integer> sortedKeys = new ArrayList<Integer>(columnTable.keySet());
//        Collections.sort(sortedKeys);
//        for(int k : sortedKeys) {
//            output.add(columnTable.get(k));
//        }
//
//        return output;
//    }
//}
