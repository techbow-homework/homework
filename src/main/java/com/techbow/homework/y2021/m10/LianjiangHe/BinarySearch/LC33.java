//需要回锅,思路明白了但是自己写出来漏洞百出,首先看长度是不是1,如果不判断,则后面找k会outofboundary,判断之后找k,如果找不到则为sorted array
//对nums用BinarySearch就行.如果找到k了,则判断第一个数和target比较,如果第一个数比target大则target在[k,n]中,反之[0,k-1]
class Solution {
    int [] nums;
    int target;
    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        int n = nums.length-1;

        if (n == 0)
            return this.nums[0] == target ? 0 : -1;

        int k = find_k_index(0,n);

        if(k == 0){// no rotate
            return bSearch(0, n);
        }
        if(nums[0] > target){
            return bSearch(k,n);
        }else{
            return bSearch(0,k-1);
        }
    }
    public int bSearch(int left, int right) {
    /*
    Binary search
    */
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid]<target){
                left = mid + 1;
            }else if(nums[mid]>target){
                right= mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public int find_k_index(int left, int right) {
        if (nums[left] < nums[right])
            return 0;

        while (left <= right) {
            int mid = left+ (right-left)/2;
            if (nums[mid] > nums[mid + 1])
                return mid + 1;
            else {
                if (nums[mid] < nums[left])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }

        return 0;
    }
}
