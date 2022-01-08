package com.techbow.homework.y2021.m10.rantao;

public class treeNov29 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };


    class Solution {
        public int maxDepth(Node root) {
            if(root == null) return 0;
            int max = 0;

            for(Node n : root.children){
                max = Math.max(max, maxDepth(n));
            }

            return max +1;
        }
    }
}
