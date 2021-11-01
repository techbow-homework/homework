package com.techbow.homework.y2021.m10.rantao;

public class pointerOct31 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // better solution, doesn't not create extra space
        int p1 = m-1;
        int p2 = n-1;

        for( int p = m+n-1; p >= 0; p--) {
            if (p2 <0) break;

            if(p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1--];
            }
            else {
                nums1[p] = nums2[p2--];

            }
        }
    }}

 /*   use 3 pointer but need additional space

       int[] nums = new int[m];
        for ( int i =0; i < m; i++) {
            nums[i] = nums1[i];
        }

        int p1 = 0, p2 = 0;

        for( int p = 0; p < m + n; p++) {
            if(p2 >= n || (nums[p1] <m && nums[p1] < nums2[p2])) {

                nums1[p] = nums[p1++];
            }
            else {
                nums1[p] = nums2[p2++];
            }
        }
    }
    */
}
