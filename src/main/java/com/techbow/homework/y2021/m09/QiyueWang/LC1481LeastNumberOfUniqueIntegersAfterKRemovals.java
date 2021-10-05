package com.techbow.homework.y2021.m09.QiyueWang;

import java.util.*;

public class LC1481LeastNumberOfUniqueIntegersAfterKRemovals {
        public static int findLeastNumOfUniqueInts(int[] arr, int k) {
            int n = arr.length;
            Map<Integer, Integer> map = new HashMap<>();

            Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>(){
                @Override
                public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2){
                    return e1.getValue() - e2.getValue();
                }
            });

            for(int i = 0; i < n; i++){
                int cur = map.getOrDefault(arr[i], 0 );
                map.put(arr[i], cur + 1);
            }

            for(Map.Entry<Integer, Integer> e : map.entrySet()){
                pq.offer(e);
            }

            while(k > 0){
                Map.Entry<Integer, Integer> cur = pq.poll();
                int f = cur.getValue();
                if(f > k) break;
                else{ k -= f;}
            }
            return k == 0 ? pq.size() : pq.size() + 1;
        }

    public static void main(String[] args) {
        int[] arr = new int[] {4,3,1,1,3,3,2};
        int[] arr2 = new int[] {5,5,4};
        System.out.println(findLeastNumOfUniqueInts(arr, 3)); //expect 2
        System.out.println(findLeastNumOfUniqueInts(arr2, 2)); //expect 1
    }
}
// time O(NlogN) space O(N)

