package com.techbow.homework.y2021.m10.zekun;

public class LC0272_Tree_KClosestBST {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {

        Stack <TreeNode> stackL = new Stack<>();
        Stack<TreeNode> stackR = new Stack<>();
        TreeNode cur = root;
        while(cur != null){
            if(cur.val < target){
                stackL.push(cur);
                cur = cur.right;

            }else{
                stackR.push(cur);
                cur = cur.left;
            }
        }
        List<Integer> res = new ArrayList<>();
        while(k-- > 0){
            if(!stackL.isEmpty() && !stackR.isEmpty()){
                if(Math.abs(stackL.peek().val - target) < Math.abs(stackR.peek().val - target)){//l--
                    res.add(lMinus(stackL));
                }else{
                    res.add(rPlus(stackR));
                }
            }else if(!stackR.isEmpty()){
                res.add(rPlus(stackR));
            }else if(!stackL.isEmpty()){
                res.add(lMinus(stackL));
            }else{
                break;
            }
        }
        return res;
    }

    private int lMinus(Stack<TreeNode> stack){
        TreeNode top = stack.pop();
        TreeNode cur = top.left;
        while(cur != null){
            stack.push(cur);
            cur = cur.right;
        }
        return top.val;
    }
    private int rPlus(Stack<TreeNode> stack){
        TreeNode top = stack.pop();
        TreeNode cur = top.right;
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        return top.val;
    }
}
