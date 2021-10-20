package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.bfs;

import dfsBfs.TreeNode;
import 第二轮.算法陪练.utils.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC366FindLeavesofBinaryTree {
    //dfs no sort


    public  List<List<Integer>> findLeaves_1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        getHeight_1(root,res);


        return res;
    }

    private  int getHeight_1(TreeNode root, List<List<Integer>> res) {
        if(root == null){
            return -1; //leaf 下面的null是-1，所以leaf是0 height
        }

        int left = getHeight_1(root.left,res);
        int right = getHeight_1(root.right,res);

        int height = Math.max(left,right) +1;

        if(res.size() == height){
            res.add(new ArrayList<>());
        }

        res.get(height).add(root.val);
        return height;
    }

    //dfs sort
    public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        List<Pair<Integer,Integer>> pairs = new ArrayList<>();
        getHeight(root,pairs);

        Collections.sort(pairs,(p1,p2)->p1.getKey()-p2.getKey());
        int height = 0, i = 0;

        while(i < pairs.size()){
            List<Integer> list = new ArrayList<>();
            while(i < pairs.size() && pairs.get(i).getKey() == height){
                list.add(pairs.get(i++).getValue());
            }
            height++;
            res.add(list);
        }

        return res;
    }

    private static int getHeight(TreeNode root, List<Pair<Integer, Integer>> pairs) {
        if(root == null){
            return -1;
        }

        int left = getHeight(root.left,pairs);
        int right = getHeight(root.right,pairs);

        int height = Math.max(left,right) +1;

        pairs.add(new Pair<>(height,root.val));
        return height;
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

        findLeaves(root);

    }
}
