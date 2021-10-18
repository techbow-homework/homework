package com.techbow.homework.y2021.m10.zekun;

import java.util.ArrayList;
import java.util.List;

public class LC0323_Graph_ConnectedComponent {
    public static void main(String[] args){
        LC0323_Graph_ConnectedComponent obj = new LC0323_Graph_ConnectedComponent();
        int numNodes = 5;
        int[][] neighbors = {{0,1},{1,2},{3,4}};
        int sol = obj.countComponents(numNodes, neighbors);
        System.out.println(sol);

    }
    private static class Node{
        public int val;
        public List<Node> neighbors;
        public boolean status;//status = 0,1,0:not visited;2:visited

        public Node(int i){
            this.val = i;
            this.neighbors = new ArrayList<Node>();
            this.status = false;
        }
    }
    public int countComponents(int n, int[][] edges) {
        //cc
        if(n <= 0 || edges == null || edges[0].length == 0) return 0;
        List<Node> nodelist = new ArrayList<Node>();
        for(int i = 0; i < n; i++){
            nodelist.add(new Node(i));
        }
        for(int[] edge : edges){
            Node v0 = nodelist.get(edge[0]);//这里原来的写法是
            Node v1 = nodelist.get(edge[1]);
            v0.neighbors.add(v1);
            v1.neighbors.add(v0);
        }

        int componentNum = 0;
        for(Node cur : nodelist){
            if(!cur.status){
                dfsHelper(cur);
                componentNum++;
            }
        }
        return componentNum;
    }

    private void dfsHelper(Node node){
        node.status = true;
        for(Node neighbor : node.neighbors){
            if(!neighbor.status){
                dfsHelper(neighbor);
            }
        }
    }
}
