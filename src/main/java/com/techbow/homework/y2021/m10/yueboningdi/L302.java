//L302 Smallest Rectangle Enclosing Black Pixels
/*Locked problem.
You are given an m x n binary matrix image where 0 represents a white pixel and 1 represents a black pixel.
The black pixels are connected (i.e., there is only one black region). Pixels are connected horizontally and vertically.
Given two integers x and y that represents the location of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.
You must write an algorithm with less than O(mn) runtime complexity

Input: image = [["0","0","1","0"],["0","1","1","0"],["0","1","0","0"]], x = 0, y = 2
Output: 6
Input: image = [["1"]], x = 0, y = 0
Output: 1
Chinese Leetcode official solution.
 */
public class L302 {
    //solution 1: binary search
    //passed all lc tests
    public static int minArea(char[][] image, int x, int y){
        //corner cases
        if (image == null || image.length == 0 || image[0] == null || image[0].length == 0){
            return -1;
        }
        //normal case
        int leftBound = getLeftBound(image, 0, y);
        int rightBound = getRightBound(image, y + 1, image[0].length - 1);
        int upperBound = getUpperBound(image, 0, x);
        int lowerBound = getLowerBound(image, x + 1, image.length - 1);
        System.out.println("leftbound: " + leftBound);
        System.out.println("rightbound: " + rightBound);
        System.out.println("upperBound: " + upperBound);
        System.out.println("lowerBound: " + lowerBound);

        int length = rightBound - leftBound + 1;
        int width = lowerBound - upperBound + 1;
        return length * width;
    }

    public static int getLeftBound(char[][] image, int start, int end){
        //corner case
        if (image == null || image.length == 0 || image[0] == null || image[0].length == 0){
            return -1;
        }
        //search for leftBound
        int left = start;
        int right = end;
        int mid = start;
        while (left + 1 < right){
            mid = left + (right - left) / 2;
            //check all elements in column mid to see if there is any black pixel.
            if (!hasBlackInCol(image,mid)){
                left = mid;
            }else{
                right = mid;
            }
        }
        //postprocessing check edges
        if ( hasBlackInCol(image,left)){
            return left;
        }else{
            return right;
        }
    }

    public static int getRightBound(char[][] image, int start, int end){
        //if start out of bound (y == image[0].length - 1)
        if (start >= image[0].length){
            return start - 1;
        }
        //search for rightBound
        int left = start;
        int right = end;
        int mid = start;
        while (left + 1 < right){
            mid = left + (right - left) / 2;
            //check all elements in column mid to see if there is any black pixel.
            if (hasBlackInCol(image,mid)){
                left = mid;
            }else{
                right = mid;
            }
        }
        //postprocessing check edges
        if ( hasBlackInCol(image,right)){
            return right;
        }else if ( hasBlackInCol(image,left)){
            return left;
        }else{
            return start - 1;
        }
    }

    public static int getUpperBound(char[][] image, int start, int end){
        //corner case
        if (image == null || image.length == 0 || image[0] == null || image[0].length == 0){
            return -1;
        }
        //search for leftBound
        int left = start;
        int right = end;
        int mid = start;
        while (left + 1 < right){
            mid = left + (right - left) / 2;
            //check all elements in column mid to see if there is any black pixel.
            if (!hasBlackInRow(image,mid)){
                left = mid;
            }else{
                right = mid;
            }
        }
        //postprocessing check edges
        if ( hasBlackInRow(image,left)){
            return left;
        }else{
            return right;
        }
    }

    public static int getLowerBound(char[][] image, int start, int end){
        //if start out of bound (x == image.length - 1)
        if (start >= image.length){
            return start - 1;
        }
        //search for LowerBound
        int left = start;
        int right = end;
        int mid = start;
        while (left + 1 < right){
            mid = left + (right - left) / 2;
            //check all elements in column mid to see if there is any black pixel.
            if (hasBlackInRow(image,mid)){
                left = mid;
            }else{
                right = mid;
            }
        }
        //postprocessing check edges
        if ( hasBlackInRow(image,right)){
            return right;
        }else if ( hasBlackInRow(image,left)){
            return left;
        }else{
            return start - 1;
        }
    }

    public static boolean hasBlackInCol(char[][] image, int colNum){
        int k = 0;
        while (k < image.length){
            if (image[k][colNum] == '1'){
                break;
            }else{
                k++;
            }
        }
        //k == image.length indicates there's no black pixels in column mid, else there is
        if (k == image.length){
            return false;
        }else{
            return true;
        }
    }

    public static boolean hasBlackInRow(char[][] image, int rowNum){
        int k = 0;
        while (k < image[0].length){
            if (image[rowNum][k] == '1'){
                break;
            }else{
                k++;
            }
        }
        //k == image[0].length indicates there's no black pixels in column mid, else there is
        if (k == image[0].length){
            return false;
        }else{
            return true;
        }
    }

    //solution 2: DFS/BFS

    public static void main(String[] args){
//        //tc 1: output: 1
//        char[][] image = {{'0'},{'1'}};
//        int x = 1;
//        int y = 0;
        //tc 2 : output: 4
        char[][] image = {{'0','0','0'},{'0','1','0'},{'1','1','0'}};
        int x = 1;
        int y = 1;
        System.out.println(minArea(image,x,y));
    }

}
