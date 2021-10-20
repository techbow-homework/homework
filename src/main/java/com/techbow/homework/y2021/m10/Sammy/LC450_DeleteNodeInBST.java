package com.techbow.homework.y2021.m10.Sammy;

public class LC450_DeleteNodeInBST {
    //若要删除的当前节点为本身且为叶子节点，可以将自身置为空。
    //若要删除的当前节点其只有一棵子树（左子树或右子树），则将当前节点指向那一棵子树（左子树或右子树）
    //若要删除的当前节点的左右子树都存在，则将右子树的最左节点的值赋值给当前节点（即右子树的最左节点做为根），
    //是将左子树的最右节点的值赋值给当前节点（即左子树的最右节点做为根），此时再删除右子树的最左节点或左子树的最右节点。
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val > key) {root.left = deleteNode(root.left,key);}
        else if(root.val < key) {root.right = deleteNode(root.right,key);}
        else {
            if(root.left == null || root.right == null){//左节点或右节点为空，或为叶子节点
                root=(root.left==null) ? root.right : root.left;
            }else{//左、右节点都不为空的情况下，寻找右子树的最左节点赋值给当前结点，再将右子树的最左节点删除
                TreeNode curNode = root.right;
                while(curNode.left != null) curNode = curNode.left;
                root.val = curNode.val;
                root.right = deleteNode(root.right,curNode.val);
            }
        }

        return root;
    }
}
