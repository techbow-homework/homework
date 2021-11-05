////278. First Bad Version
///*
//The essence of this problem is finding the dividing line of continuous 0 and continuous 1.
// */
//public class L278 {
//    //My binary search solution 3 solution, passed LC
//    public int firstBadVersion(int n) {
//        //corner cases
//        if (n == 0){
//            return -1;
//        }
//        //normal cases
//        int left = 1;
//        int right = n;
//        int mid = 1;
//        while (left + 1 < right){
//            mid = left + (right - left) / 2;
//            if (isBadVersion(mid) == false){
//                left = mid;
//            }else{
//                right = mid;
//            }
//        }
//        //postprocessing check edges, corner cases: [0], [1], [*,*], [0,0,...,0], [1,1,...,1], normal case [left0,right1].
//        if (isBadVersion(left) == true){
//            return left;
//        }else if (isBadVersion(right) == true){
//            return right;
//        }
//        return -1;  //no bad version found
//    }
//}
