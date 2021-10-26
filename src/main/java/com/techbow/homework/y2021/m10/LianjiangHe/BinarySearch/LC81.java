class Solution {
    int[] nums;
    int target;

    public boolean search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        int n = nums.length-1;

        if(n == 0){
            return this.nums[0] == target ? true:false;
        }
        int k = find_k_index(0,n);

        if(k == 0){
            return bSearch(0,n);
        }

        if(nums[0] > target){
            return bSearch(k,n);
        }else{
            return bSearch(0,k-1);
        }
    }
    //key point: avoid duplicates
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
            if (nums[mid] > nums[mid + 1]){
                return mid + 1;
            }
            else {
                if (nums[mid] < nums[left])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return 0;
    }

    public boolean bSearch(int left, int right){
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }
}