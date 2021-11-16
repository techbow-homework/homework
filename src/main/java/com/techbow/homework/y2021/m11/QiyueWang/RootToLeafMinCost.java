package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Edge{
    GNode end; // edge point to a node
    int cost;
    public Edge(GNode n, int cost){
        this.cost = cost;
        end = n;
    }
}

class GNode{
    List<Edge> edges; //edges start with this node
    public GNode(){
        edges = new ArrayList<>();
    }
}

public class RootToLeafMinCost {
    private int minVal = Integer.MAX_VALUE;
    public List<Edge> minCostPath(GNode root){
        List<Edge> res = new ArrayList<>();
        dfs(root,new ArrayList<>(), 0, res);
        return res;
    }
    private void dfs(GNode root, List<Edge> cur, int curCost, List<Edge> res){
        if(root == null) return;
        if(root.edges.size() == 0 && curCost < minVal){
            minVal = curCost;
            res.clear();
            res.addAll(cur);
            return;
        }
        for (Edge e : root.edges){
            cur.add(e);
            dfs(e.end, cur, curCost + e.cost, res);
            cur.remove(cur.size() - 1);
        }
    }

    public List<Edge> minGraphPath(GNode root){
        List<Edge> res = new ArrayList<>();
        Map<GNode, Integer> m = new HashMap<>();
        dfsGraph(root,new ArrayList<>(), 0, res, m);
        //System.out.println(m);
        return res;
    }

    private void dfsGraph(GNode root, List<Edge> cur, int curCost, List<Edge> res, Map<GNode, Integer> m){
        if(root == null) return;
        if(m.containsKey(root) && m.get(root) <= curCost) return;
        m.put(root, curCost);
        if(root.edges.size() == 0 && minVal > curCost){
            minVal = curCost;
            res.clear();
            res.addAll(cur);
            return;
        }

        for (Edge e : root.edges){
            cur.add(e);
            dfsGraph(e.end, cur, curCost + e.cost, res, m);
            cur.remove(cur.size() - 1);
        }
    }
    public static void main(String[] args) {
        RootToLeafMinCost test = new RootToLeafMinCost();
        /*
         *       n1
         *   e1 /  \ e3
         *     n2   n3
         * e2 /
         *   n4
         *
         * */
        GNode n1 = new GNode();
        GNode n2 = new GNode();
        GNode n3 = new GNode();
        GNode n4 = new GNode();
        Edge e1 = new Edge(n2,1);
        Edge e2 = new Edge(n4,2);
        Edge e3 = new Edge(n3,5);
        n1.edges.add(e1);
        n1.edges.add(e3);
        n2.edges.add(e2);

//        List<Edge> res = test.minCostPath(n1);
//        int sum = 0;
//        for (Edge e : res){
//            sum += e.cost;
//        }
//        System.out.println("3 == "+sum);
//        System.out.println(test.minVal);

        List<Edge> res = test.minGraphPath(n1);
        int sum = 0;
        for (Edge e : res){
            sum += e.cost;
        }
        System.out.println("3 == "+ sum);
        System.out.println(test.minVal);
    }
}
