package com.techbow.homework.y2021.m09.QiyueWang;
// a city is located at (x,y)
// the festival is located at (a,b)
// the cost of travel = (|x-a| + |y-b|) * num of person
// find the location of festival at min cost


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MetroLandFestival {
    public static int[] location(int[] numPeople, int[] x, int[] y){
        int n = x.length;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < n; i++){
            min = Math.min(Math.min(min, x[i]), y[i]);
            max = Math.max(Math.max(max, x[i]), y[i]);
        }

        int[][][] cities = new int[n][max - min + 1][max - min + 1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < max -min + 1; j++){
                for(int k = 0; k < max - min + 1; k++){
                    cities[i][j][k] = Math.abs(x[i] - j - min) + Math.abs(y[i] - k - min);
                }
            }
        }
        for(int i = 0; i < n; i++){
            System.out.println(Arrays.deepToString(cities[i]));
        }

        int[][] res = new int[max - min + 1][max - min + 1];
        for(int j = 0; j < max -min + 1; j++){
            for(int k = 0; k < max - min + 1; k++){
                for(int i = 0; i < n; i++){
                    res[j][k] += cities[i][j][k] * numPeople[i];
                }
            }
        }
        System.out.println(Arrays.deepToString(res));
        return null;
    }

    public static int minCost(int[] numPeople, int[] x, int[] y) {
        int n = x.length;
        List<Integer> xAll = new ArrayList<>();
        List<Integer> yALL = new ArrayList<>();
        for (int i = 0; i < n; i++){
            int num = numPeople[i];
            while (num != 0){
                xAll.add(x[i]);
                yALL.add(y[i]);
                num --;
            }
        }
        // find the median, and it does not matter if size is odd or even
        // if it's even, any number within size/2 and size/2+1 will work
        Collections.sort(xAll);
        Collections.sort(yALL);
        int xMedian = xAll.get(xAll.size() / 2);
        int yMedian = yALL.get(yALL.size() / 2);
        int res = 0;
        for (int i = 0; i < n; i++){
            res += (Math.abs(xMedian - x[i]) + Math.abs(yMedian - y[i])) * numPeople[i];
        }
        return res;
    }



    public static void main(String[] args) {
        int[] numP = new int[] {1,2};
        int[] x = new int[] {1,3};
        int[] y = new int[] {1,3};
        location(numP, x, y);
        System.out.println(minCost(numP, x, y)); // expect 4
    }
}
