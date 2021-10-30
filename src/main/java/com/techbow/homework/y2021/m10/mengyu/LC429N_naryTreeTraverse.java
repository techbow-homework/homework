package com.techbow.homework.y2021.m10.mengyu;

import com.techbow.homework.y2021.m09.mengyu.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC429N_naryTreeTraverse {
    public List<List<Integer>> NnaryTreeLevelOrderTraverse (Node root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        bfsNnary(root, result);
        return result;
    }
    private void bfsNnary (Node root, List<List<Integer>> result) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curLevelNodes = new ArrayList<>();
            while (size-- > 0) {
                Node cur = queue.poll();
                curLevelNodes.add(cur.val);
                for (int i = 0; i < cur.children.size(); i++) {
                    queue.offer(cur.children.get(i));
                }
            }
            result.add(curLevelNodes);
        }
    }

    public static void main(String[] args) {
        Node test = new Node();
        LC429N_naryTreeTraverse method = new LC429N_naryTreeTraverse();
        System.out.println(method.NnaryTreeLevelOrderTraverse(test));
    }
}
