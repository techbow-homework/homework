        /*如果我们观察题目中给的那个例子，可以发现有两个位置的数字很有特点，左下角和右上角的数。
        左下角的 18，往上所有的数变小，往右所有数增加，那么就可以和目标数相比较，如果目标数大，就往右搜，如果目标数小，就往上搜。
        这样就可以判断目标数是否存在。当然也可以把起始数放在右上角，往左和下搜，停止条件设置正确就行。*/
        //intuitive answer not the best one! 变种的2分法,因为每次舍弃一半的row或者column;
        class Solution {
            public boolean searchMatrix(int[][] matrix, int target) {
                int m = matrix.length;// row length
                int n = matrix[0].length;// col length
                int x = m - 1, y = 0;
                while (x >= 0 && y < n) {
                    if (matrix[x][y] > target) {
                        x--;}
                    else if (matrix[x][y] < target) {
                        y++;}
                    else{
                        return true;}
                }
                return false;
            }
        }