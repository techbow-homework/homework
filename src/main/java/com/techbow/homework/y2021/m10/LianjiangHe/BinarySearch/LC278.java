package com.techbow.homework.y2021.m10.LianjiangHe.BinarySearch;

public class LC278 {
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
