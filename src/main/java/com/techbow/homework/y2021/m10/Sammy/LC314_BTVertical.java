package com.techbow.homework.y2021.m10.Sammy;

import java.util.*;

public class LC314_BTVertical {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        levelOrder(map, root, res);

        return res;
    }
    private void levelOrder(HashMap<Integer, List<Integer>> map, TreeNode root, List<List<Integer>> res ){
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        queue.offer(root);
        col.offer(0);
        int min = 0;
        int max = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                TreeNode cur = queue.poll();
                int curCol = col.poll();
                if(!map.containsKey(curCol)){
                    List<Integer> list = new ArrayList<>();
                    list.add(cur.val);
                    map.put(curCol, list);
                } else {
                    map.get(col).add(cur.val);
                }
                if(cur.left != null){
                    queue.offer(cur.left);
                    col.offer(curCol - 1);
                    min = Math.min(min, curCol - 1);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                    col.offer(curCol + 1);
                    max = Math.max(max, curCol + 1);
                }
            }

        }
        for(int i = min; i <= max; i++){
            res.add(map.get(i));
        }
    }
}
