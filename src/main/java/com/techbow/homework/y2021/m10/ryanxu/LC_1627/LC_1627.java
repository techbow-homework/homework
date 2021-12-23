package com.techbow.homework.y2021.m10.ryanxu.LC_1627;

import java.util.ArrayList;
import java.util.List;

public class LC_1627 {

    private static class UF {

        private int[] parent;
        private int[] size;

        public UF(int n) {
            this.parent = new int[n + 1];
            this.size = new int[n + 1];
        }

        private int getRoot(int p) {

            int cur = p;
            while (cur != parent[cur]) {
                parent[cur] = parent[parent[cur]];
                cur = parent[cur];
            }

            parent[p] = cur;
            return cur;
        }

        public boolean find(int p, int q) {
            return getRoot(p) == getRoot(q);
        }

        public void union(int p, int q) {

            int pRoot = getRoot(p);
            int qRoot = getRoot(q);
            if (size[pRoot] < size[qRoot]) {
                parent[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
            } else {
                parent[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
            }
        }

        public void initial(int idx) {

            if (size[idx] != 0) {
                return;
            }
            this.parent[idx] = idx;
            this.size[idx] = 1;
        }
    }

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {

        List<Boolean> res = new ArrayList<>();
        UF uf = new UF(n);
        for (int i = threshold + 1; i <= n; i++) {
            for (int j = 2 * i; j <= n; j += i) {
                uf.initial(i);
                uf.initial(j);
                uf.union(i, j);
            }
        }

        for (int[] pair : queries) {
            if (uf.getRoot(pair[0]) != 0) {
                res.add(uf.find(pair[0], pair[1]));
            } else {
                res.add(false);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LC_1627 lc_1627 = new LC_1627();
        int n = 6;
        int threshold = 2;
        int[][] queries = {{1,4}, {2,5}, {3,6}};
        System.out.println(lc_1627.areConnected(n, threshold, queries));
    }
}
