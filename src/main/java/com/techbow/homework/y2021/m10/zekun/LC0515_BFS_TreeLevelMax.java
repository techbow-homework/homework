package LC;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC0515_BFS_TreeLevelMax {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //cc
        if(root == null) return res;

        //build que
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()){
            int qsize = que.size();
            int levelMax = Integer.MIN_VALUE;

            for(int i = 0; i < qsize; i++){
                TreeNode cur = que.poll();
                levelMax = Math.max(levelMax, cur.val);
                if(cur.left != null) que.offer(cur.left);
                if(cur.right != null) que.offer(cur.right);
            }
            res.add(levelMax);
        }
        return res;
    }
}
