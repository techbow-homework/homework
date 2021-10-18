package com.techbow.homework.y2021.m10.zekun;

import java.util.LinkedList;
import java.util.Queue;

public class LC0513_BFS_TreeLeftMostValue {
    public int findBottomLeftValue(TreeNode root) {
        //cc
        if(root == null) throw new IllegalArgumentException("");

        //build que and put in root
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        TreeNode ret = null;

        while(!que.isEmpty()){
            int size = que.size();
            TreeNode levelfirst = null; // 这里每个forloop完成后回来，是每一层的开始;

            for(int i = 0; i < size; i++){
                TreeNode cur = que.poll();
                if(levelfirst == null){
                    levelfirst = cur;
                }
                if(cur.left != null) que.offer(cur.left);
                if(cur.right != null) que.offer(cur.right);
            }

            ret = levelfirst;
        }
        return ret.val;
    }


}
