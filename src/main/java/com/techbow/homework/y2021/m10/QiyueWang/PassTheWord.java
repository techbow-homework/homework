package com.techbow.homework.y2021.m10.QiyueWang;
// DRW OA
public class PassTheWord {
    public static String solution(String S, int[] A) {
        // write your code in Java SE 8
        //int n = A.length;
        StringBuilder res = new StringBuilder();
        int index = 0;
        res.append(S.charAt(index));
        while(A[index] != 0){
            index = A[index];
            res.append(S.charAt(index));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] A1 = new int[]{3,2,0,1};
        String S1 = "cdeo";
        System.out.println(solution(S1,A1)); // code
        int[] A2 = new int[]{5, 2, 0, 1, 6, 4, 8, 3, 7};
        String S2 = "cdeenetpi";
        System.out.println(solution(S2,A2)); // centipede
        int[] A3 = new int[]{4, 3, 0, 1, 2, 5};
        String S3 = "bytdag";
        System.out.println(solution(S3,A3)); // bat
    }
}
