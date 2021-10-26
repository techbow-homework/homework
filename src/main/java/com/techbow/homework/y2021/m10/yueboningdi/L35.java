public class L35 {
    public static int insertPos(int[] nums, int target){
        //corner case
        if (nums == null || nums.length == 0){
            return -1;
        }
        //normal case
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left + 1 < right){
            mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid;
            }else if (nums[mid] > target){
                right = mid;
            }else {  //nums[mid] == target
                return mid;
            }
        }
        //post processing tackle corner cases
        if (nums[left] == target){
            return left;
        }else if (nums[right] == target){
            return right;
        }
        //all elements are < target
        if (nums[right] < target){
            return nums.length;
        }else if (nums[left] > target){ //all elements are > target
            return 0;
        }else{  //normal case: [<target, >target]
            return right;
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,3,5};
        int target = 1;
        System.out.println(insertPos(nums,target));
    }
}
//test case:
//normal case 1: [2,9,25,66,96,100] target = 30, res = 3.
//normal case 2: target = 25, res = 2.
//corner case 1: target = 1, res = 0.
//corner case 2: target = 101, res = 6.
//corner case 3: nums = [1,33], target = 1, res = 0.
//corner case 4: nums = [1,33], target = 33, res = 1.
//corner case 5: nums = [1,33], target = 0, res = 0.
//corner case 6: nums = [1,33], target = 20, res = 1.
//corner case 7: nums = [1,33], target = 40, res = 2.
//corner case 7: nums = [1,3,5], target = 1, res = 0.