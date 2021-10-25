package com.techbow.homework.y2021.m10.mengyu;

import com.techbow.homework.y2021.m09.mengyu.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LC662MaximumWidthBT {
    public int widthOfBinaryTree(TreeNode root) {
        Map<TreeNode, Integer> layerMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Integer layers = 0;
        Integer layerWidth = 0;
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            while(queueSize-- != 0) {
                TreeNode n = queue.poll();
                //if(i == 0) left = layerMap.getOrDefault(n, 1); //first polled node from queue is the left side of the tree in same level
                if(n.left != null) {
                    queue.offer(n.left);
                    layerMap.put(n.left, layerMap.getOrDefault(n, 1) * 2);
                }
                if(n.right != null) {
                    queue.offer(n.right);
                    layerMap.put(n.right, layerMap.getOrDefault(n, 1) * 2 + 1);
                }
                layers = Math.max(layers, layerMap.getOrDefault(n, 1) - layerWidth + 1);
            }

        }
        return layers;
    }
}
