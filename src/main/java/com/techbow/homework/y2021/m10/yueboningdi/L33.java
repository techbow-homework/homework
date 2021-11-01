/*
According to description, the array is definitely rotated, cannot be strictly ascending, because k !0 0.

 */
public class L33 {
//    //My solution
//    public static int search(int[] nums, int target){
//
//    }

    //Teacher JIngyi's solution based on solution 2
    public static int search2(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            //mid stays the same half as target
            if (nums[mid] >= nums[0] && target >= nums[0] || nums[mid] < nums[0] && target < nums[0]){
                if (nums[mid] < target) left = mid + 1;
                else right = mid;
            }else if (nums[mid] >= nums[0]) {     //mid stays different half as target, mid left, target right half
                left = mid + 1;
            }else{  ////mid stays different half as target, target left, mid right half
                right = mid - 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

}
