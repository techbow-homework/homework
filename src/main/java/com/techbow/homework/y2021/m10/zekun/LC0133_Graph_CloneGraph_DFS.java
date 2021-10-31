package com.techbow.homework.y2021.m10.zekun;

public class LC0133_Graph_CloneGraph_DFS {
    Map<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        Node tmp = visited.get(node);
        if(node == null){//check corner case
            return node;
        }
        if(tmp != null){//visited 中已经存在，不要再接着走当前neighbor；
            return tmp;
        }

        Node cloneNode = new Node(node.val, new ArrayList<Node>());
        visited.put(node, cloneNode);
        for(Node neighborNode : node.neighbors){
            cloneNode.neighbors.add(cloneGraph(neighborNode));//给当前node加neighbor;
        }
        return cloneNode;
    }
}
