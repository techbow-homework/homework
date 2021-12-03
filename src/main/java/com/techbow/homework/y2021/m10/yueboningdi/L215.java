/*
Kth Largest Element in an Array
 */
public class L215 {
    //Solution 1: optimized quick sort approach
    //passed all LC tests
    public static int findKthLargest_sol1(int[] nums, int k){
        //corner case
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length){
            throw new IllegalArgumentException("Illegal input array or k!");
        }
        //normal case
        int result = quickSort_sol1(nums, 0, nums.length - 1, k);
        return (result == Integer.MIN_VALUE)? nums[nums.length - k] : result;
    }

    public static int quickSort_sol1(int[] nums, int start, int end, int k){
        //base case
        if (start >= end){
            return Integer.MIN_VALUE;
        }
        int left = start;
        int right = end - 1;
        int pivot = nums[end];
        while (left < right){
            if (nums[left] < pivot) left++;
            else if (nums[right] >= pivot) right--;
            else swap(nums, left, right);
        }
        if (nums[left] < pivot){    //if all elements in [start,end-1] is < pivot
            left = right = end;
        }
        swap(nums, left, end);  //put pivot to its proper place (index left)
        //if pivot is the kth largest elements, return in advance, return value is pivot
        if (left == nums.length - k){
            return nums[left];
        }else{
            //if pivot is on the left of the target position n-k
            //only recursion on the right part of pivot
            if (left < nums.length - k){
                int tmp = quickSort_sol1(nums, left + 1, end, k);
                if ( tmp != Integer.MIN_VALUE) {
                    return tmp;
                }
            }else{  //if pivot is on the right of the target position n-k
                //only recursion on the left part of pivot
                int tmp = quickSort_sol1(nums, start, left - 1, k);
                if ( tmp != Integer.MIN_VALUE) {
                    return tmp;
                }
            }
        }
        return Integer.MIN_VALUE;   //if didn't return in advance, return Integer.MIN_VALUE
    }

    public static void swap(int[] nums, int index1, int index2){
        if (index1 == index2) return;
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    //solution 2: use heap
//    public static int findKthLargest_sol2(int[] nums, int k){
//        //corner case
//        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length){
//            throw new IllegalArgumentException("Illegal input array or k!");
//        }
//        //normal case
//        quickSort(nums, 0, nums.length - 1);
//        return nums[nums.length - k];
//    }

    public static void main(String[] args){
        int[] nums = {3,2,3,1,2,4,5,5,6,6,11,1,2,10,5};
        int k = 4;
        System.out.println(findKthLargest_sol1(nums, k));
    }

}
