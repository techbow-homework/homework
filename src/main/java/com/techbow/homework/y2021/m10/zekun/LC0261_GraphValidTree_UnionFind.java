package com.techbow.homework.y2021.m10.zekun;

public class LC0261_GraphValidTree_UnionFind {
    //unionFindsolution
    class Solution {
        public boolean validTree(int n, int[][] edges) {
            //cc
            if(edges == null) return false;
            UnionFind uf = new UnionFind(n);
            for(int[] edge : edges){
                int p = edge[0];
                int q = edge[1];
                if(uf.find(p, q)){
                    return false;//这里的意思是p和q有共同的root，因此出环了，即不能make up a valid tree
                }else{
                    uf.union(p, q);
                }
            }
            return uf.n == 1;
        }
    }

    class UnionFind{
        int[] parents;
        int[] size;
        int n;
        //constructor
        public UnionFind(int n){
            parents = new int[n];
            size = new int[n];
            this.n = n;
            for(int i = 0; i < n; i++){
                parents[i] = i;//初始化的时候，每个node的parent都是它自己;
                size[i] = 1;
            }
        }
        public boolean find(int p, int q){
            return getRoot(p) == getRoot(q);
        }

        public int getRoot(int p){
            int cur = p;
            while(parents[cur] != cur){
                //cur.parent = cur.parent.parent;
                parents[cur] = parents[parents[cur]];
                //cur = cur.parent;
                cur = parents[cur];
            }
            parents[p] = cur;
            return cur;
        }

        public void union(int p, int q){
            int pRoot = getRoot(p);
            int qRoot = getRoot(q);
            int pSize = size[pRoot];
            int qSize = size[qRoot];
            if(pSize > qSize){
                parents[qRoot] = pRoot;
                size[pRoot]++;
            }else{
                parents[pRoot] = qRoot;
                size[qRoot]++;
            }
            n--;
        }
    }
}
