package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.bfs;

import dfsBfs.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC958CheckCompletenessofaBinaryTree {

    public static boolean isCompleteTree(TreeNode root) {
        if(root == null){
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean hasNull = false;//用在整个树上，不是一层上

        while(!queue.isEmpty()){

            int size =  queue.size();
            while(size-- >0){
                TreeNode cur = queue.poll();
                if(cur != null && hasNull){
                    return false;
                }
                if(cur == null){
                    hasNull =true;
                }
                if(cur!=null){
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;

        isCompleteTree(root);

    }
}
