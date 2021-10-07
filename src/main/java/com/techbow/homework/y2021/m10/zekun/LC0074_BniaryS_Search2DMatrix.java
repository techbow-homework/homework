package LC;

public class LC0074_BniaryS_Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //cc
        //if(matrix == null || matrix[0] == null || matrix.length = 0 || matrix[0].length == 0) return false;

        int nrow = matrix.length;
        int ncol = matrix[0].length;
        int left = 0;
        int right = nrow * ncol - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int i = mid / ncol;
            int j = mid % ncol;
            if (matrix[i][j] < target) {
                left = mid + 1;
            } else if (matrix[i][j] > target) {
                right = mid - 1;
            } else if (matrix[i][j] == target) {
                return true;
            }
        }
        return false;
    }
}
