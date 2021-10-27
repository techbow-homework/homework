class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        if(x == 0){
            return 0;
        }
        if(x == 1){
            return 1;
        }
        while(left <= right){
            int mid = left + (right - left)/2;
            if(mid <= x/mid && (mid+1)> x/(mid+1)){
                return mid;
            }else if(mid <= x/mid){
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }
        return 0;
    }
}