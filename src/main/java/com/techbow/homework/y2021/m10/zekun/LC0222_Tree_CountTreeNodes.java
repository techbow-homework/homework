package LC;

public class LC0222_Tree_CountTreeNodes {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int lH = getHeight(root.left);
        int rH = getHeight(root.right);

        int count = 1;
        if(lH > rH){
            count += (1 << rH) - 1;
            return count + countNodes(root.left);

        }else if(lH == rH){
            count += (1 << lH) - 1;
            return count + countNodes(root.right);
        }else{
            return -1;
        }
    }

    private int getHeight(TreeNode root){
        int height = 0;
        while(root !=null){
            height++;
            root = root.left;
        }
        return height;
    }
}
