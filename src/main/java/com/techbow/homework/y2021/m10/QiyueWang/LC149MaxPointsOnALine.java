package com.techbow.homework.y2021.m10.QiyueWang;

import java.util.*;

public class LC149MaxPointsOnALine {
    public static int maxPoints(int[][] points) {
        int n = points.length;
        if(n == 1) return 1;
        Set<List<Double>> m = new HashSet<>();
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                List<Double> line = calculateLine(points[i], points[j]);
                m.add(line);
            }
        }
        int max = 0;
        for(List<Double> l : m){
            int count = 0;
            Double k = l.get(0);
            Double b = l.get(1);
            for(int i = 0; i < n; i++){
                if(k != null && b != null){
                    Double check = points[i][0] * k + b - points[i][1];
                    //System.out.println(check);
                    Double offset = Math.pow(10, -10);
                    if(check >= -offset && check <= offset) count ++;
                }else if(k == null){
                    if(points[i][1] == b) count ++;
                }else{
                    if(points[i][0] == k) count ++;
                }
                max = Math.max(max, count);
            }
        }
        //System.out.println(m);

        return max;
    }

    private static List<Double> calculateLine(int[] p1, int[] p2){
        int x1 = p1[0];
        int x2 = p2[0];
        int y1 = p1[1];
        int y2 = p2[1];
        Double k = null;
        double b = 0;
        List<Double> res = new ArrayList<>();
        if(x1 - x2 != 0 && y1 - y2 != 0){
            k =((double) (y1 - y2)) /((double) (x1 - x2));
            b = (y1 + y2 - k * (x1 + x2)) / 2;
            res.add(k);
            res.add(b);
        }else if(x1 - x2 == 0){
            res.add((double) x1);
            res.add(null);
        }else{
            res.add(null);
            res.add((double) y1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{3,3},{1,1},{2,1}};
        System.out.println(maxPoints(points)); // 2
    }
}
// time O(N^2) space O(N)
