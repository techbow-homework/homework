package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.bfs;

import dfsBfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SeeingfromLeftToRight {
    public static List<Integer> fromLeftToRight(TreeNode root){
        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean veryLeft = true;
            while(size-- > 0){

                TreeNode cur = queue.poll();
                if(veryLeft){
                    res.add(cur.val);
                    veryLeft = false;
                }
                if(cur.left!=null){
                    queue.offer(cur.left);
                }

                if(cur.right!=null){
                    queue.offer(cur.right);
                }
            }
        }
        return res;
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
        node4.right = node5;

        fromLeftToRight(root);

    }
}
