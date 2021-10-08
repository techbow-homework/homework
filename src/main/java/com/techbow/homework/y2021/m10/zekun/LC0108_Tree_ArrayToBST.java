package LC;

public class LC0108_Tree_ArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        //cc
        if(nums == null || nums.length == 0 ) return null;

        return treeBuilder(nums, 0, nums.length - 1);
    }

    private TreeNode treeBuilder(int[] nums, int left, int right){
        //base case
        if(left > right) return null;

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = treeBuilder(nums, left, mid - 1);
        root.right = treeBuilder(nums, mid + 1, right);
        return root;
    }
}
