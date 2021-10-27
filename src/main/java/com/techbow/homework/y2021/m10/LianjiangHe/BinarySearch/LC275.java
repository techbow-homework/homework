class Solution {

    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0;
        int right = n-1;
        if (right == 0){
            return citations[0] >= 1 ? 1:0;
        }
        if(citations[0] >= n){
            return n;
        }
        while(left <= right){
            int mid = left + (right-left)/2;
            if(mid == 0){//2 elements situation; if not index out of boundary;
                if(citations[0] == 0){
                    return citations[1] >= 1 ? 1:0;
                }else{
                    return citations[0] >= 2 ? 2:1;
                }
            }

            if(citations[n-mid]>=mid&&citations[n-mid-1]<=mid){
                return mid;
            }if(citations[n-mid]<mid){
                right = mid-1;
            }if(citations[n-mid-1]>mid){
                left = mid+1;
            }
        }
        return 0;
    }

}