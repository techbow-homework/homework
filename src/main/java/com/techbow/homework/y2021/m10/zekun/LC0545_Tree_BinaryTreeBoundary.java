package LC;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC0545_Tree_BinaryTreeBoundary {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //cc
        if(root == null || root.val == 0) return res;

        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);

        while(!que.isEmpty()){
            List<Integer> level = new LinkedList<>();
            int qsize = que.size();
            for(int i = 0; i < qsize; i++){
                TreeNode cur = que.poll();
                if(cur.left != null) que.offer(cur.left);
                if(cur.right != null) que.offer(cur.right);
                level.add(cur.val);
            }
            if(qsize == 1){
                res.add(level.get(0));
            }else{
                res.add(level.get(0));
                res.add(level.get(qsize - 1));
            }
        }

        return res;
    }
}
