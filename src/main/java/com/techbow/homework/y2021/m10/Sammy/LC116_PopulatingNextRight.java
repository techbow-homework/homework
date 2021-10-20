package com.techbow.homework.y2021.m10.Sammy;

import java.util.LinkedList;
import java.util.Queue;

public class LC116_PopulatingNextRight {
    public Node connect(Node root) {
        if(root == null) return root;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                Node cur = queue.poll();
                Node next = queue.peek();
                if(size == 0){
                    cur.next = null;
                } else {
                    cur.next = next;
                }
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }

            }
        }
        return root;
    }
}
