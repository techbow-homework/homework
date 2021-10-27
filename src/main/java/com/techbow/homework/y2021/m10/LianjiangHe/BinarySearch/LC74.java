class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;// row length
        int n = matrix[0].length;// col length
        if(m == 0){
            return false;
        }
        int left = 0;
        int right = m*n-1;
        int counter = 0;

        while(left<=right){
            int mid = left + (right - left)/2;
            int idxc =  (mid)%n;
            int idxr =  (mid)/n;
            if(matrix[idxr][idxc] < target){
                left = mid + 1;
            }else if(matrix[idxr][idxc] > target){
                right = mid - 1;
            }else{
                counter++;
                return true;
            }
        }
        if(counter == 0){
            return false;
        }
        return true;
    }
}