package LC;

import java.util.ArrayList;
import java.util.List;

public class LC0543_Tree_Recursion {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        helper(root);
        return diameter - 1;
    }
    private int helper(TreeNode root){
        //base case
        if(root == null) return 0;

        int leftLen = helper(root.left);//左右根
        int rightLen = helper(root.right);
        diameter = Math.max(diameter, leftLen + rightLen + 1);
        return Math.max(leftLen, rightLen) + 1;//返回左右子树中的最大值 + 1 返值，因为要把自己加上

    }

    public class TreeNode {
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

    public static class LC0241_Tree_AddParentheses {
        public static void main(String[] args){
            LC0241_Tree_AddParentheses obj = new LC0241_Tree_AddParentheses();
            String input = "2-1-1";
            List<Integer> sol = obj.diffWaysToCompute(input);
            System.out.println(sol);
        }
        public List<Integer> diffWaysToCompute(String expression) {
            List<Integer> res = new ArrayList<Integer>();
            //cc
            if(expression == null || expression.length() == 0) return res;
            for(int i = 0; i < expression.length(); i++){
               char operator = expression.charAt(i);
               if(operator == '-' || operator == '+' || operator == '*'){
                   List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                   List<Integer> right = diffWaysToCompute(expression.substring(i + 1, expression.length()));
                   List<Integer> curval = cal(operator, left, right);
                   res.addAll(curval);
               }
            }
            if(res.isEmpty()) res.add(Integer.valueOf(expression));
            return res;
        }

        private List<Integer> cal(char operator, List<Integer> left, List<Integer> right){
            List<Integer> res = new ArrayList<Integer>();
            for(int l : left){
                for(int r : right){
                    int result = 0;
                    if(operator == '+') result = l + r;
                    if(operator == '-') result = l - r;
                    if(operator == '*') result = l * r;
                    res.add(result);
                }
            }
            return res;
        }
    }
}
