package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.bfs;

import dfsBfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC102BinaryTreeLevelOrderTraversal {
    //bfs
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root ==null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size-- > 0){
                TreeNode cur = queue.poll();
                list.add(cur.val);

                if(cur.left != null){
                    queue.offer(cur.left);
                }

                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            res.add(list);
        }
        return res;
    }


    //dfs
    public static List<List<Integer>> levelOrder_dfs(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root ==null){
            return res;
        }

        dfs(root,res,0);
        return res;
    }

    private static void dfs(TreeNode root, List<List<Integer>> res, int level){
        if(root == null){
            return ;
        }

        if(level == res.size()){
            res.add(new ArrayList<>());
        }

        res.get(level).add(root.val);
//        System.out.println("preorder--"+root.val +" : "+level);

        dfs(root.left, res,level + 1);
//        System.out.println("inorder--"+root.val +" : "+level);
        dfs(root.right, res, level + 1);
        System.out.println("postorder--"+root.val +" : "+level);
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
    }

}
