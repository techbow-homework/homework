package com.techbow.homework.y2021.m11.schoolHW.matrixchainmultiplication;

import java.util.ArrayList;
import java.util.List;

public class MaxtrixChainMultiplication {
    private List<int[]> p;
    private Result result;

    public MaxtrixChainMultiplication(List<int[]> p) {
        this.p = p;
        result = new Result(p.size());
    }

    public Result memorizedMatrixChain() {
        return lookupChain(0, p.size() - 1);
    }

    public Result lookupChain(int i, int j) {
        int[][] m = result.getM();
        if (m[i][j] < Integer.MAX_VALUE) {
            result.setResult(m[i][j]);
            return result;
        }
        if (i == j) {
            m[i][j] = 0;
            result.setM(m);
        } else {
            for (int k = i; k <= j - 1; k++) {
                int left = lookupChain(i, k).getResult();
                int right = lookupChain(k + 1, j).getResult();
                int q = left + right + p.get(i)[0] * p.get(k)[1] * p.get(j)[1];
                System.out.println("i=" + i + " k= " + k + " j= " + j + " q= " + q + " combine cost= " + p.get(i)[0] * p.get(k)[1] * p.get(j)[1] + " left= " + left + " right= " + right);
                if (q < m[i][j]) {
                    m[i][j] = q;
                    result.setResult(m[i][j]);
                    int[][] s = result.getS();
                    s[i][j] = k + 1;
                    result.setM(m);
                    result.setS(s);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<int[]> p = new ArrayList<>();
        p.add(new int[]{15, 3});
        p.add(new int[]{3, 7});
        p.add(new int[]{7, 27});
        p.add(new int[]{27, 10});
        p.add(new int[]{10, 5});
        p.add(new int[]{5, 60});
        MaxtrixChainMultiplication maxtrixChainMultiplication = new MaxtrixChainMultiplication(p);
        Result res = maxtrixChainMultiplication.memorizedMatrixChain();
        System.out.println(res);
    }
}
