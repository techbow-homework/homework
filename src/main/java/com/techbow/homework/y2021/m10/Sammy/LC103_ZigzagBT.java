package com.techbow.homework.y2021.m10.Sammy;

import java.util.*;

public class LC103_ZigzagBT {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        HashMap<Integer, List<Integer>> map = new HashMap<>();//level + list of integer
        int height = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            while(size-- > 0){
                TreeNode cur = queue.poll();
                curLevel.add(cur.val);
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            map.put(height, curLevel);
            height++;
        }
        for(Integer e: map.keySet()){
            if(e % 2 != 0){
                res.add(map.get(e));
            } else {
                List<Integer> temp = map.get(e);
                Collections.reverse(temp);
                res.add(temp);
            }
        }
        return res;
    }
}
