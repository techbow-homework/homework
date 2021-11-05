/*
The core method is the same as L153.
But there is one difference:
if nums[right] duplicates appears both in left and right part,
when nums[mid]==nums[right],
we cannot decide how to shrink interval boundaries.
eg: [3,3,3,3,3,4,1,3,3], should do left=mid.
eg: [3,3,4,1,3,3,3,3,3],should do right=mid;


 */
public class L154 {
    //My solution passed lc tests:
    public static int findMIn(int[] nums){
        //corner cases
        if (nums == null || nums.length ==0){
            return -10000;  //return an illegal number
        }
        //corner case n == 1,2
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int mid = 0;
        //corner case rotated n times, already in ascending order
        if (nums[left] < nums[right]){
            return nums[left];
        }
        //normal case
        while (left + 1 < right){
            mid = left + (right - left) / 2;
            if (nums[mid] == nums[len - 1]){
                if (nums[mid] == nums[left]){
                    left += 1;
                }else{
                    right = mid;
                }
            }else if (nums[mid] < nums[len - 1]){
                right = mid;
            }else{  //nums[mid] > nums[len - 1]
                left = mid;
            }
        }
        //normal case: nums[left] > nums[n-1] (nums[left] == max), nums[right] < nums[n-1] (nums[right] == min).
        //corner case len==1
        //corner case len==2
        return (nums[left] < nums[right])? nums[left] : nums[right];
    }

    //Teacher Jingyi's solution: (solution 2)
    public static int findMIn2(int[] nums){
        int left = 0, right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else if (nums[mid] < nums[right]) right = mid;
            else right--;   //if ums[mid] == nums[right], shrink right boundary until nums[mid]!=nums[right]
        }
        return nums[left];
    }

    public static void main(String[] args){
        int[] nums = {3,3,1,3};
    }
}
