public class L74 {
    public static boolean searchMatrixS1(int[][] matrix, int target){
        //corner cases
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        //normal case
        int rows = matrix.length;
        int cols = matrix[0].length;
        //binary search for row index
        int curRow = -1;
        int curCol = -1;
        int left = 0;
        int right = rows - 1;
        int mid = 0;
        while (left + 1 < right){
            mid = left + (right - left) / 2;
            if (matrix[mid][0] == target){
//                curRow = mid;
                return true;
            }else if (matrix[mid][0] < target){
                left = mid;
            }else{  //matrix[mid][0] > target
                right = mid;
            }
        }
        //post processing check two edges for target
        if (matrix[left][0] == target || matrix[right][0] == target){
            return true;
        }else if (matrix[right][0] < target){
            //corner case: all elements in the first column is < target
            curRow = right;
        }else if (matrix[left][0] > target){
            //corner case: all elements in the first column is > target
//            curRow = -1;
            return false;
        }else{
            // normal case: left < target, right > target
            curRow = left;
        }
//        System.out.println("Row#: " + curRow);
        //binary search for column index
        left = 0;
        right = cols - 1;
        mid = 0;
        while (left <= right){
            mid = left + (right - left) / 2;
            if (matrix[curRow][mid] == target){
                curCol = mid;
//                System.out.println("Col#: " + curCol);
                return true;
            }else if (matrix[curRow][mid] < target){
                left = mid + 1;
            }else{  //matrix[curRow][mid] > target
                right = mid - 1;
            }
        }
        return false;
    }

    public static boolean searchMatrixS2(int[][] matrix, int target){
        //corner cases
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        //normal case
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;
        int mid = 0;
        while (left <= right){
            mid = left + (right - left) / 2;
            if (matrix[mid / cols][mid % cols] == target){
//                System.out.println("Row#: " + mid / cols + ", col#: " + mid % cols);
                return true;
            }else if(matrix[mid / cols][mid % cols] < target){
                left = mid + 1;
            }else{  //matrix[mid / cols][mid % cols] > target
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] matrix = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        int target = 20;
        System.out.println(searchMatrixS1(matrix, target));
    }
}
