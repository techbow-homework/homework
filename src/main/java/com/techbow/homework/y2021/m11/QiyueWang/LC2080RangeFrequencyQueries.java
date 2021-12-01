package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC2080RangeFrequencyQueries {
    Map<Integer, List<Integer>> m;
    public LC2080RangeFrequencyQueries(int[] arr) {
        m = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            List<Integer> temp = m.getOrDefault(arr[i], new ArrayList<>());
            temp.add(i);
            m.put(arr[i], temp);
        }

    }

    public int query(int left, int right, int value) {
        List<Integer> index = m.getOrDefault(value, new ArrayList<>());
        if(index.size() == 0){
            return 0;
        }
        int l = binSearchHigh(index, left);
        int r = binSearchLow(index, right);
        if(l == -1 || r == -1) return 0;
        //System.out.println("l: " + l + " r: " +  r);
        return r - l + 1;
    }

    private int binSearchHigh(List<Integer> list, int val){
        int l = 0;
        int r = list.size() - 1;
        while(l < r){
            int mid = (l + r) / 2;
            if(list.get(mid) < val) l = mid + 1;
            else{
                r = mid;
            }
        }
        if(l == list.size() - 1 && list.get(l) < val) return -1;// all values are small than val
        return l;
    }

    private int binSearchLow(List<Integer> list, int val){
        int l = 0;
        int r = list.size() - 1;
        while(l < r){
            int mid = (l + r + 1) / 2;
            if(list.get(mid) < val) l = mid ;
            else if(list.get(mid) == val) return mid;
            else{
                r = mid - 1;
            }
        }
        if(l == 0 && list.get(l) > val) return -1; // all values are larger than val
        return l;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56};
        LC2080RangeFrequencyQueries obj = new LC2080RangeFrequencyQueries(arr);
        System.out.println(obj.query(1,2,4)); //1
        System.out.println(obj.query(0,11,33));// 2
    }
}
