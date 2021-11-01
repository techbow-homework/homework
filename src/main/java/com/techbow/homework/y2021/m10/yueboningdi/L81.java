/*
According to description, the array is can be rotated or strictly ascending, with duplicate elements.

 */
public class L81 {
//    //My solution
//    public static int search(int[] nums, int target){
//
//    }

    //Teacher JIngyi's solution based on solution 2
    public static boolean search2(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        //exclude all nums[0] on the right half
        while (right > 0 && nums[right] == nums[0]){
            right--;
        }
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
        return nums[left] == target ? true : false;
    }

}
