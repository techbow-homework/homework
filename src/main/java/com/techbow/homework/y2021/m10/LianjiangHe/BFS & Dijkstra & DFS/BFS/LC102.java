class Solution {
    //List就能表示树
    //返回值[[3],[9,20],[15,7]],由List里包个List就能表示要求的顺序了
    //这就是为什么List<List<GENERICS>>,input是List
    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    public void helper(TreeNode node, int level){
        //levels是list包list,本质还是list,level是当前输入的值
        if(levels.size() == level){
            levels.add(new ArrayList<Integer>());
        }
        //当前层.add(node此时的值)
        levels.get(level).add(node.val);

        if(node.left != null){

            helper(node.left, level + 1);
        }
        if(node.right != null){
            helper(node.right, level + 1);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return levels;
        }
        helper(root, 0);
        return levels;
    }
}

