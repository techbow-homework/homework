class Solution {
    int[] nums;
    public int findMin(int[] nums) {
        this.nums = nums;
        int n = nums.length-1;
        if(n==0){
            return this.nums[0];
        }
        int k = find_k_index(0,n);
        if(k == 0){
            return this.nums[0];
        }
        return this.nums[k];
    }
    public int find_k_index(int left, int right){
        if(nums[left] < nums[right]){
            return 0;
        }

        // avoid duplicates
        while(left < right && nums[left] == nums[left+1]){
            left++;
        }
        while(left < right && nums[right] == nums[right-1]){
            right--;
        }
        if(left == right && nums[left] == nums[right]){
            return 0;
        }

        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid]>nums[mid+1]){
                return mid+1;
            }else{
                if(nums[mid] < nums[left]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }
        return 0;
    }

}