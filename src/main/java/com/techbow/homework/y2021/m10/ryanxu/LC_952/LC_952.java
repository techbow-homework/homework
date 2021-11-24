package com.techbow.homework.y2021.m10.ryanxu.LC_952;

//import UF.UnionFind;
//import Eratosthenes.Eratosthenes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_952 {

    private static class Eratosthenes {
        private int[] arr;
        private int n;
        public Eratosthenes(int n) {
            this.arr = new int[n + 1];
            this.n = n;
        }

        public List<Integer> getPrimes() {

            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (arr[i] != 1) {
                    int j = i * 2;
                    while (j <= n) {
                        arr[j] = 1;
                        j += i;
                    }
                }
            }

            List<Integer> res = new ArrayList<>();
            for (int i = 2; i <= n; i++) {
                if (arr[i] == 0) {
                    res.add(i);
                }
            }

            return res;
        }
    }

    private static class UnionFind {
        private int[] parent;
        private int[] size;
        private int connectedComponentCount;
        private int maxSize;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            this.connectedComponentCount = 0;
            this.maxSize = 0;
        }

        public void initial(int p) {

            if (size[p] != 0) {
                return;
            }
            parent[p] = p;
            size[p] = 1;
            connectedComponentCount++;
        }

        public int getRoot(int idx) {

            int cur = idx;
            while (cur != parent[cur]) {
                parent[cur] = parent[parent[cur]];
                cur = parent[cur];
            }
            parent[idx] = cur;

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
                maxSize = Math.max(maxSize, size[qRoot]);
            } else {
                parent[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
                maxSize = Math.max(maxSize, size[pRoot]);
            }
            this.connectedComponentCount--;
        }

        public int getMaxSize() {
            return this.maxSize;
        }
    }

    private static int maxNum = (int) 1e5;
    public int largestComponentSize(int[] nums) {

        List<Integer> primes = new Eratosthenes((int) Math.sqrt(maxNum)).getPrimes();
        int len = nums.length;
        UnionFind uf = new UnionFind(maxNum + 1);

        for (int i = 0; i < len; i++) {
            int cur = nums[i];
            for (Integer prime : primes) {
                if (cur < prime) {
                    break;
                }
                if (cur % prime == 0) {
                    uf.initial(nums[i]);
                    uf.initial(prime);
                    if (!uf.find(nums[i], prime)) {
                        uf.union(nums[i], prime);
                    }
                    while (cur % prime == 0) {
                        cur /= prime;
                    }
                }
            }
            if (cur > 1) {
                uf.initial(cur);
                uf.initial(nums[i]);
                if (!uf.find(cur, nums[i])) {
                    uf.union(cur, nums[i]);
                }
            }
        }

        HashMap<Integer, Integer> parent2Count = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            parent2Count.put(uf.getRoot(num), parent2Count.getOrDefault(uf.getRoot(num), 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : parent2Count.entrySet()) {
            res = Math.max(res, entry.getValue());
        }
        return res;
    }

    public static void main(String[] args) {
        LC_952 lc_952 = new LC_952();
        int[] nums = {2,3,6,7,4,12,21,39};
        System.out.println(lc_952.largestComponentSize(nums));
    }
}
