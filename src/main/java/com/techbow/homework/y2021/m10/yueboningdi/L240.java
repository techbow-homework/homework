public class L240 {
    public static boolean searchMatrix(int[][] matrix, int target){
        //corner case
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        //normal case
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int curRow = rowNum - 1;
        int curCol = 0;
        while (curRow >= 0 && curRow < rowNum && curCol >= 0 && curCol < colNum){
            if (matrix[curRow][curCol] == target){
                return true;
            }else if (matrix[curRow][curCol] < target){
                curCol += 1;
            }else{  //matrix[curRow][curCol] > target
                curRow -= 1;
            }
        }
        return false;
    }

//    public static void main(String[] args){
//
//    }
}
