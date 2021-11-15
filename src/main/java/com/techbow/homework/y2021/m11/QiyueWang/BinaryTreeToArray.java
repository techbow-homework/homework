package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.*;

public class BinaryTreeToArray {
    public Integer[] compressDenseTree(TreeNode root){
        int height = getHeight(root);
        Integer[] res = new Integer[(int)Math.pow(2, height)];
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> indices = new LinkedList<>();
        nodes.offer(root);
        indices.offer(1);//starts from 1
        while(!nodes.isEmpty()){
            TreeNode cur = nodes.poll();
            int curIdx = indices.poll();
            res[curIdx] = cur.val;
            if(cur.left != null){
                nodes.offer(cur.left);
                indices.offer(curIdx * 2);
            }
            if(cur.right != null){
                nodes.offer(cur.right);
                indices.offer(curIdx * 2 + 1);
            }
        }
        return res;
    }
    private int getHeight(TreeNode root){
        if(root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public Map<Integer, Integer> compressSparseTree(TreeNode root){
        Map<Integer, Integer> m = new TreeMap<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> indices = new LinkedList<>();
        nodes.offer(root);
        indices.offer(1);//starts from 1
        while(!nodes.isEmpty()){
            TreeNode cur = nodes.poll();
            int curIdx = indices.poll();
            m.put(curIdx, cur.val);
            if(cur.left != null){
                nodes.offer(cur.left);
                indices.offer(curIdx * 2);
            }
            if(cur.right != null){
                nodes.offer(cur.right);
                indices.offer(curIdx * 2 + 1);
            }
        }
        return m;
    }

    public static void main(String[] args) {
        BinaryTreeToArray obj = new BinaryTreeToArray();
        TreeNode t1 = new TreeNode(11);
        TreeNode t2 = new TreeNode(12);
        TreeNode t3 = new TreeNode(13);
        TreeNode t4 = new TreeNode(14);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        System.out.println(Arrays.toString(obj.compressDenseTree(t1)));
        System.out.println(obj.compressSparseTree(t1));
    }
}
