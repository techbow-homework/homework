package com.techbow.homework.y2021.m10.Jacob;

public class LC_55 {
    public boolean canJump (int A[]) {
    int lastPositionOfIndex = A.length -1;

    for (int i = A.length -1; i >= 0; i--) {
        if (A[i] + i >= lastPositionOfIndex) {
            lastPositionOfIndex = i;

        }
    }
    return lastPositionOfIndex == 0;
    }
}
