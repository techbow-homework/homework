public class S1Q6 {
    public static int largestSmallerPos(int[] nums, int target) {
        // Corner case
        if (nums == null || nums.length == 0) return -1;
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
        //check edges for target
        if (nums[left] == target){
            return (left - 1) < 0 ? -1: left - 1;
        }else if (nums[right] == target){
            return left;
        }
        //check other corner cases
        if (nums[right] < target){  //if all elements are < target
            return right;
        }else if (nums[left] > target){    // if all elements are >= target
            return -1;
        }else{                      //normal: [<target, >target]
            return left;
        }
//        if (nums[right] < target){  //if all elements are < target
//            return right;
//        }else if (nums[left] >= target){    // if all elements are >= target
//            return -1;
//        }else{
//            return left;
//        }
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
//corner case 3: nums = [1,33], target = 1, res = -1.
//corner case 4: nums = [1,33], target = 33, res = 0.
//corner case 5: nums = [1,33], target = 0, res = -1.
//corner case 6: nums = [1,33], target = 20, res = 0.
//corner case 7: nums = [1,33], target = 40, res = 1.
//corner case 7: nums = [1,3,5], target = 1, res = -1.
