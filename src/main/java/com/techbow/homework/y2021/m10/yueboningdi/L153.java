/*
By analyzing an rotated array [4,5,6,7,*0*,1,2], we can find that:
if n = nums.length = len,
and if we divide the array into two parts on the minimum element: the left part and the right part are all ascending.
And all left part elements are greater than nums[n-1] (the greatest element in the right part).
So the problem becomes finding the left-most element in the right part.
The essence of this problem is finding the dividing line between the left part(nums[i] > nums[n-1]) and the right part(nums[i] <= nums[n-1]).
We can use binary search to solve this problem.
if mid is in left part ==> nums[mid] > nums[n-1] ==> target is on the right of mid ==> move left boundary towards right to mid;
if mid is in the right part ==> nums[mid] < nums[n-1] ==> target is on the left of mid (or mid is target) ==> move right boundary towards left to mid.
 */

public class L153 {
    //My solution passed lc L153 tests
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
            if (nums[mid] < nums[len - 1]){
                right = mid;
            }else{  //nums[mid] > nums[len - 1], they cannot be equal
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
            else right = mid;
        }
        return nums[left];
    }
//    public static void main(String[] args){
//
//    }
}
