package com.techbow.homework.y2021.m10.LianjiangHe.BinarySearch;

public class LC278 {

/*  //BAD VERSION
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version);
//  1<=n<=2^31-1
    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int l = 0;      //因为没有注意到n的范围, n+1已经超过了int的范围,所以错了
            int r = n+1 ;
            int bad = r;
            while(l+1<r){
                    m = l+(r-l)/2;
                if (isBadVersion(m)==true){
                    r = m;
                    bad = r;
                }else{
                    l = m;
                    bad = r;
                }
            }
            return bad;
        }
    }
    */
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
//Time complexity : O(log n). The search space is halved each time, so the time complexity is O(log n).
//Space complexity : O(1).

    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int l = 1;
            int r = n ;
            int bad = r;

            while(l<r){
                int m = l+(r-l)/2;
                if (isBadVersion(m)){
                    r = m;
                    bad = r;
                }else{
                    l = m+1;// l的左边都是好版本,所以把pointer移动到右边一格,ohterwise l不会移动了,陷入死循环
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

/*  //BAD VERSION
    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int l = -1;
            int r = n+1 ;
            int bad;
            int m;
            while(l+1!=r-2){
                if(n%2==0){
                    m = (l+m-1)/2;
                }else{
                    m = (l+m)/2;
                }

                if (isBadVersion(m)==true){
                    r = m;
                    bad = r;
                }else{
                    l = m;
                    bad = r;
                }
            }
            return bad;
        }
    }
*/

}
