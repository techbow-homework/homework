//Redo
//It is actually a dual-pivot partitioning sub-routine of quick sort algorithm.
class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, i = 0;
//简而言之，0放最左边，2放最右边，时间复杂度为O(N)
        while (i <= right) {
            if      (nums[i] == 0) swap(nums, left++, i++);//swap nums[i]和前一个值，换完i和left++,因为 0 最小排前面
            else if (nums[i] == 2) swap(nums, i, right--);//swap nums[i]和最右边的一个值，换完nums[i]还没检测，所以只是right--
            else if (nums[i] == 1) i++;
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}