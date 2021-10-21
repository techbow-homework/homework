package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.bfs;

import dfsBfs.TreeNode;
import 第二轮.算法陪练.utils.Pair;

import java.util.*;

// 因为是要记录列，所以用两个queue; 或者用一个queue，里边装pair《col,value》
//如果需要dfs做，则除了min max col之外还要保存 row 来保证每个col是从上到下排序的
public class LC314BinaryTreeVerticalOrderTraversal {


    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if( root == null){
            return res;
        }

        Map<Integer,List<Integer>> map = new HashMap<>();
        int min = 0, max = 0;
        Queue<Pair<Integer, TreeNode>> queue = new LinkedList<>();
        queue.offer(new Pair<>(0,root));

        while(!queue.isEmpty()){
            Pair<Integer, TreeNode> cur = queue.poll();
            int col = cur.getKey();
            TreeNode curNode = cur.getValue();

            if(!map.containsKey(col)){
                map.put(col,new ArrayList<>());
            }

            map.get(col).add(curNode.val);
            min = Math.min(min, col);
            max = Math.max(max, col);


            if(curNode.left != null){
                queue.offer(new Pair<>(col-1,curNode.left));
            }

            if(curNode.right != null){
                queue.offer(new Pair<>(col +1 , curNode.right));
            }
        }

        for( int i = min; i <= max; i++){
            res.add(map.get(i));
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

    }
}
