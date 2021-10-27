//If num is greater than any element in sub, then add num to sub.
//Otherwise, perform a binary search in sub to find the smallest element
// that is greater than or equal to num. Replace that element with num.Time complexity: O(N⋅log(N))
//需要回锅
class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);

        for(int i=1;i<nums.length;i++){
            int num = nums[i];
            if(num > sub.get(sub.size()-1)){
                sub.add(nums[i]);
            }else{
                int j = binarySearch(sub,num);
                sub.set(j,num);
            }
        }
        return sub.size();
    }
    public int binarySearch(ArrayList<Integer> sub, int num){
        int left = 0;
        int right = sub.size()-1;

        while (left <= right){
            int mid = left + (right - left)/2;
            if(sub.get(mid)==num){
                return mid;
            }
            if(sub.get(mid)>num){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}