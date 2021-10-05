package com.techbow.homework.y2021.m10.qiangzhai;
import java.util.ArrayList;
import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class LC314_BinaryTreeVerticalLevelOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        //cc
        if (root == null) return result;
        //
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        //这里用两个queue，是因为
        Queue<TreeNode> levelQue = new LinkedList<>();
        Queue<Integer> colQue = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //
        levelQue.offer(root);
        colQue.offer(0);
        while (!levelQue.isEmpty()) {
            TreeNode pollNode = levelQue.poll();
            int col = colQue.poll();
            min = Math.min(min,col);
            max = Math.max(max,col);
            //update map
            if (map.containsKey(col)) {
                map.get(col).add(pollNode.val);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(pollNode.val);
                map.put(col, list);
            }
            //update queue
            if (pollNode.left != null) {
                levelQue.offer(pollNode.left);
                colQue.offer(col - 1);
            }
            if (pollNode.right != null) {
                levelQue.offer(pollNode.right);
                colQue.offer(col + 1);
            }
        }
        //
        for (int i = min; i <= max; i++) {
            result.add(map.get(i));
        }
        return result;
    }

}
