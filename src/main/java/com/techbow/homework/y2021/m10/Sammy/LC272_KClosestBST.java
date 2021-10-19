package com.techbow.homework.y2021.m10.Sammy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LC272_KClosestBST {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> Math.abs(a - target) >= Math.abs(b - target) ? -1 : 1);
        inorder(root, k, minHeap);
        return new ArrayList<>(minHeap);
    }
    private void inorder(TreeNode root, int k, PriorityQueue<Integer> minHeap){
        if(root == null) return;
        inorder(root.left, k, minHeap);
        minHeap.offer(root.val);
        if(minHeap.size() > k){
            minHeap.poll();
        }
        inorder(root.right, k, minHeap);
    }
    //NlogK
    //GOOGLE SLN should be QuickSelection
}
