public class L162 {
    public static int findPeakElement(int[] nums){
        //corner cases
        if (nums == null || nums.length == 0){
            return -1;
        }
        //normal cases
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left + 1 < right){
            mid = left + (right - left) / 2;
            //if ascend (nums[i] - nums[i - 1] > 0) (1) update left edge
            if ((nums[mid] - nums[mid - 1]) > 0){
                left = mid;
            }else if ((nums[mid] - nums[mid - 1]) < 0){ //if descend (nums[i] - nums[i - 1] < 0) (0) update right edge
                right = mid;
            }
        }
        //post processing tackle corner cases where nums.length==2 (won't get into while loop)
        if (nums.length == 2){
            return (nums[0] > nums[1])? 0 : 1;  //nums[i] != nums[i + 1] for all valid i
        }
        //jump out from while loop
        //check other corner cases
        if (nums[left] < nums[right]){  //if all elements are ascending
            return right;
        }else{  //nums[left] > nums[right], if all elements are descending + normal case
            return left;
        }
    }

//    public static void main(String[] args){
//
//    }
}
