package com.techbow.homework.y2021.m10.zekun;

public class LC0863_KDistanceOfNodeinBinaryTree {
    List<Integer> res = new ArrayList<>();
    Map<TreeNode, TreeNode> graph = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k){
        //cc
        if(root == null || target == null) return res;
        buildGraph(root);

        bfs(target);
        return res;

    }
    private void buildGraph(TreeNode root){
        //basecase
        if(root == null) return;
        if(root.left != null){
            graph.put(root.left, root);
            buildGraph(root.left);
        }
        if(root.right != null){
            graph.put(root.right, root);
            buildGraph(root.right);
        }
    }
    private void bfs(TreeNode node){

    }
}
