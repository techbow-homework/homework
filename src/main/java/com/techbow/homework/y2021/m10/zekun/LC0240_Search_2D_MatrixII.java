package LC;

public class LC0240_Search_2D_MatrixII {
    //从左下角出发，因为左下角的值，是每行的最小值，是每列的最大值，每次仅需要比较matrix[i][j]的值和target
    //因此如果左下角的值比target大，则target不在该列，如果比target小，则不在该行；
    public boolean searchMatrix(int[][] matrix, int target) {
        //cc
        //if(matrix == null || matrix[0] == null || matrix[0] == 0 || matrix[0].length == 0) return new int[] {-1, -1};
        int nrow = matrix.length;
        int ncol = matrix[0].length;
        int i = nrow - 1;
        int j = 0;
        while(i >= 0 && j < ncol){
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                i--;
            }else{
                j++;
            }
        }
        return false;
    }
}
