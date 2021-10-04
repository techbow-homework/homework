package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法冲刺.二分猜值;


import java.util.Arrays;

/**
 * You have n packages that you are trying to place in boxes, one package in each box. There are m suppliers that each produce boxes of different sizes (with infinite supply). A package can be placed in a box if the size of the package is less than or equal to the size of the box.
 *
 * The package sizes are given as an integer array packages, where packages[i] is the size of the ith package. The suppliers are given as a 2D integer array boxes, where boxes[j] is an array of box sizes that the jth supplier produces.
 *
 * You want to choose a single supplier and use boxes from them such that the total wasted space is minimized. For each package in a box, we define the space wasted to be size of the box - size of the package. The total wasted space is the sum of the space wasted in all the boxes.
 *
 * For example, if you have to fit packages with sizes [2,3,5] and the supplier offers boxes of sizes [4,8], you can fit the packages of size-2 and size-3 into two boxes of size-4 and the package with size-5 into a box of size-8. This would result in a waste of (4-2) + (4-3) + (8-5) = 6.
 * Return the minimum total wasted space by choosing the box supplier optimally, or -1 if it is impossible to fit all the packages inside boxes. Since the answer may be large, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: packages = [2,3,5], boxes = [[4,8],[2,8]]
 * Output: 6
 * Explanation: It is optimal to choose the first supplier, using two size-4 boxes and one size-8 box.
 * The total waste is (4-2) + (4-3) + (8-5) = 6.
 * Example 2:
 *
 * Input: packages = [2,3,5], boxes = [[1,4],[2,3],[3,4]]
 * Output: -1
 * Explanation: There is no box that the package of size 5 can fit in.
 * Example 3:
 *
 * Input: packages = [3,5,8,10,11,12], boxes = [[12],[11,9],[10,5,14]]
 * Output: 9
 * Explanation: It is optimal to choose the third supplier, using two size-5 boxes, two size-10 boxes, and two size-14 boxes.
 * The total waste is (5-3) + (5-5) + (10-8) + (10-10) + (14-11) + (14-12) = 9.
 *
 *
 * Constraints:
 *
 * n == packages.length
 * m == boxes.length
 * 1 <= n <= 105
 * 1 <= m <= 105
 * 1 <= packages[i] <= 105
 * 1 <= boxes[j].length <= 105
 * 1 <= boxes[j][k] <= 105
 * sum(boxes[j].length) <= 105
 * The elements in boxes[j] are distinct.
 */

//需要 sort pkgs和boxes，并需要presum来减少时间复杂度 =>可以快速计算一段subarray里的加和
// 对每个box，去packages里找比他小的pkgs里最大的（bs upper bound）
public class LC1889MinimumSpaceWastedFromPackaging {
    public  int minWastedSpace(int[] packages, int[][] boxes) {
        if(packages == null || packages.length == 0 || boxes == null || boxes.length == 0){
            return -1;
        }

        Arrays.sort(packages);
        for(int[] box:boxes){
            Arrays.sort(box);
        }
        int[] preSum = new int[packages.length];

        int total= 0;
        for(int i = 0 ;i< packages.length; i++){
            total += packages[i];
            preSum[i] += total;
        }

        long M = (long)(1e9 + 7);
        long res = Long.MAX_VALUE;
        for(int[] box:boxes){
            long waste = 0;
            int prev = -1;
            for(int i = 0; i < box.length;i++){
                int upperBound = upperBound(packages,box[i]);
                if( upperBound == -1){ // 最小的pkg都放不进去box
                    continue;
                }
                waste += (long)(upperBound - prev) * box[i] - (preSum[upperBound] - (prev == -1? 0:preSum[prev]));
                prev = upperBound; // upperbound他自己和之前的元素waste已经在上一行加入waste里了，所以把prev拉到当前upperbound，为以下一个pkg为起始点 的waste 开始做准备
                if(prev == packages.length -1){
                    break;
                }
            }
            if(prev != packages.length -1){ // 如果boxes用完了 pkgs还没有走完，则不计数
                continue;
            }
            res = Math.min(res,waste);
        }
        return res == Long.MAX_VALUE ? -1 :(int)(res % M);
    }


    private int upperBound(int[] packages, int box) {
        int l = 0, r = packages.length -1;

        while(l <= r){
            int mid = l + ( r - l) / 2;
            if(packages[mid] <= box){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return r;
    }

    public static void main(String[] args) {
        int[] pkgs = {2,3,5};
        int[][] boxes = {{4,8},{2,8}};
//        minWastedSpace(pkgs,boxes);

    }
}
