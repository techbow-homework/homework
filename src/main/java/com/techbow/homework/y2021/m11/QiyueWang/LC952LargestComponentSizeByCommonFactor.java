package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.HashMap;
import java.util.Map;

class UnionFind{
    int[] parent;
    int[] size;
    int max;
    public UnionFind(int len){
        parent = new int[len];
        size = new int[len];
        max = 1;
        for(int i = 0; i < len; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x){
        if(x == parent[x]){ // stops when index matches content
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y){
        int setX = find(x);
        int setY = find(y);
        if(setX == setY){
            return; // belongs to the same set
        }
        if(size[setX] > size[setY]){// small set points to large one
            parent[setY] = setX;
            size[setX] += size[setY];
            max = Math.max(max, size[setX]);
        }else{
            parent[setX] = setY;
            size[setY] += size[setX];
            max = Math.max(max, size[setY]);
        }
    }
}

public class LC952LargestComponentSizeByCommonFactor {
    public static int largestComponentSize(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> m = new HashMap<>();
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < n; i++){
            int cur = nums[i];
            for(int j = 2; j * j <= cur; j++){ // search for factor
                if(cur % j == 0){//is factor
                    if(!m.containsKey(j)){
                        m.put(j, i); // factor j points to group i
                    }else{
                        uf.union(i, m.get(j));
                    }
                    if(!m.containsKey(cur / j)){ //the other factor
                        m.put(cur / j, i);
                    }else{
                        uf.union(i, m.get(cur / j));
                    }
                }
            }
            if(!m.containsKey(cur)){// self as a factor
                m.put(cur, i);
            }else{
                uf.union(i, m.get(cur));
            }
        }
        return uf.max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,6,15,35};
        int[] nums2 = new int[]{20,50,9,63};
        System.out.println(largestComponentSize(nums));//4
        System.out.println(largestComponentSize(nums2));//2
    }
}
// time O(n*sqrt(max(nums[i]))) space O(n)
