package com.techbow.homework.y2021.m10.zekun;

public class LC0133_Graph_CloneGraph_BFS {
    Map<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        //cc
        if (node == null) return node;
        Queue<Node> que = new LinkedList<>();
        que.offer(node);
        visited.put(node, new Node(node.val, new ArrayList<Node>()));

        while(!que.isEmpty()){
            Node cur = que.poll();
            for(Node neighbor : cur.neighbors){
                if(!visited.containsKey(neighbor)){
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<Node>()));
                    que.add(neighbor);
                }
                visited.get(cur).neighbors.add(visited.get(neighbor));//如果hashmap里面有过当前node 的当前neighbor，就让当前node的neighbor这个list里面加上当前neighbor这个node
            }
        }
        return visited.get(node);
    }
}
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
