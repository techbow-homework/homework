package com.techbow.homework.y2021.m12QiyueWang;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
public class LC2096StepByStepDirectionsFromABinaryTreeNodeToAnother {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = LCA(root, startValue, destValue);
        StringBuilder path1 = new StringBuilder();
        StringBuilder path2 = new StringBuilder();

        search(lca, startValue, path1);
        search(lca, destValue, path2);
        String res = "";
        for(int i = 0; i < path1.length(); i++){
            res += "U";
        }
        res += path2.toString();
        return res;
    }

    private boolean search(TreeNode root, int value, StringBuilder path){
        if(root == null) return false;
        if(root.val == value) return true;
        path.append('L');
        boolean res = search(root.left, value, path);
        if(res) {
            //System.out.println(path.toString());
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        path.append('R');
        res = search(root.right, value, path);
        if(res) {
            //System.out.println(path.toString());
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        return false;
    }

    private TreeNode LCA(TreeNode root, int s, int d){//lowestCommonAncestor
        if(root == null){
            return null;
        }else if(root.val == s || root.val == d){
            return root;
        }

        TreeNode left = LCA(root.left,s,d);
        TreeNode right = LCA(root.right,s,d);
        if(left == null) {
            return right;
        }else if(right == null) {
            return left;
        }else return root;

    }
}
