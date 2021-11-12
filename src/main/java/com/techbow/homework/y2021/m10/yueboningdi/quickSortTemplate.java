import java.util.Arrays;

//written by myself, just implement basic ideas of quick sort
//passed all LC tests
//time complexity is not good
public class quickSortTemplate {
    public static void quickSort(int[] nums, int start, int end){
        //base case
        if (start >= end){
            return;
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
        swap(nums, left, end);  //put pivot to its proper place
        quickSort(nums, start, left - 1);
        quickSort(nums, left + 1, end);
    }

    public static void swap(int[] nums, int index1, int index2){
        if (index1 == index2) return;
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void main(String[] args){
        int[] nums= {3,2,3,1,2,4,5,5,6,6,11,1,2,10,5};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

}

