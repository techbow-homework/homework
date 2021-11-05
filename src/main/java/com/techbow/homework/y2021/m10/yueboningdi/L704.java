public class L704 {

    //JIngyi's solution based on solution 2
    public int search(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            }else{  //nums[mid] >= target
                right = mid;
            }
        }
        //In this time, left == right
        //boundaries are not checked within the while loop, so post processing is needed
        return nums[left] == target ? left : -1;
    }
}
