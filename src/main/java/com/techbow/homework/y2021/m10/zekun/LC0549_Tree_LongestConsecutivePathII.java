package com.techbow.homework.y2021.m10.zekun;

import javax.swing.tree.TreeNode;

public class LC0549_Tree_LongestConsecutivePathII {
    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        //cc
        if(root == null) return 0;
        dfsHelper(root);
        return max;
    }

    private int[] dfsHelper(TreeNode root){
        if(root == null) return new int[]{0,0};

        int[] len = new int[]{1,1};//len[0] 代表到当前root升序的长度，len[1]代表降序
        int[] leftLen = dfsHelper(root.left);
        int[] rightLen = dfsHelper(root.right);

        if(root.left != null){//左子树的升序降序
            if(root.left.val - 1 == root.val) len[0] = leftLen[0] + 1;//升序的情况，就在len[0] +1；
            if(root.left.val + 1 == root.val) len[1] = leftLen[1] + 1;//降序的情况就在len[1] + 1；
        }

        if(root.right != null){//右子树的升序降序；
            if(root.right.val - 1 == root.val) len[0] = Math.max(len[0], rightLen[0] + 1);//如果右子树也是升序，那就跟左子树的升序返上来的值比较大小，取大的
            if(root.right.val + 1 == root.val) len[1] = Math.max(len[1], rightLen[1] + 1);//同理，跟左子树的降序返上来的值比大小
        }

        max = Math.max(max, len[0] + len[1] - 1);//最后，取降序+升序 的和，-1去掉重复计算的root，得到最大连续长度；
        return len;

    }
}


