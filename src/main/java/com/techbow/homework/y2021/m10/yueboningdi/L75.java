//75. Sort Colors
/*

 */
public class L75{
    public static void sortColors(int[] nums){
        //corner case
        if (nums == null || nums.length == 0 || nums.length == 1){
            return;
        }
        //sort all 0s to the left
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            if (nums[left] == 0) left++;
            else if (nums[right] != 0) right--;
            else swap(nums, left, right);
        }
        //at this time, left==right, [0,left) are all the 0s
        //[left,nums.length-1] are all 1s and 2s unsorted
        //sort all 1s to the left of all remaining elements
        right = nums.length - 1;
        while (left < right){
            if (nums[left] == 1) left++;
            else if (nums[right] == 2) right--;
            else swap(nums, left, right);
        }
    }

    public static void swap(int[] nums, int left, int right){
        if (nums == null || nums.length == 0){
            throw new IllegalArgumentException("Null input array!");
        }
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
