public class S1Q6 {
    public static int largestSmallerPos(int[] nums, int target) {
        // Corner case
        if (nums == null || nums.length == 0) return -1;
//        if (nums[nums.length - 1] < target){
//            return nums.length - 1;
//        }
//        if (nums[0] >= target){
//            return -1;
//        }
        //normal cases
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid;
            else if (nums[mid] >= target) right = mid;
        }
        //Post processing tackle corner cases
        if (nums[right] < target){  //if all elements are < target
            return right;
        }else if (nums[left] >= target){    // if all elements are >= target
            return -1;
        }else{
            return left;
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2,9,25,66,96,100};
        int target = 101;
        System.out.println(largestSmallerPos(nums, target));
    }
}

//test case:
//normal case 1: [2,9,25,66,96,100] target = 30, res = 2.
//normal case 2: target = 25, res = 1.
//corner case 1: target = 1, res = -1.
//corner case 2: target = 101, res = 5.

