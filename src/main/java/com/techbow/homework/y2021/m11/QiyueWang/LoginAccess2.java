package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.*;

public class LoginAccess2 {
    public static Map<String, List<String>> multipleAccess(String[][] records){
        int n = records.length;
        Map<String, List<Integer>> logs = new HashMap<>();
        Map<String, List<String>> res = new HashMap<>();
        for(int i = 0; i < n; i++){
            List<Integer> temp = logs.getOrDefault(records[i][0], new ArrayList<>());
            temp.add(Integer.valueOf(records[i][1]));
            logs.put(records[i][0], temp);
        }
        for(String name : logs.keySet()){
            List<Integer> time = logs.get(name);
            if(time.size() > 1){
                Collections.sort(time);
                res.put(name, parseTime(time));
            }
        }
        return res;
    }
    private static List<String> parseTime(List<Integer> time){ // sorted time
        //if(time.size() == 1)
        int n = time.size(); // > 1
        List<String> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            List<String> cur = new ArrayList<>();
            int start = time.get(i);
            cur.add(String.valueOf(start));
            int j = i + 1;
            while(j < n && timeDif(start, time.get(j)) <= 60){ // multiple access in 1 hour
                cur.add(String.valueOf(time.get(j)));
                j++;
            }
            if(cur.size() > res.size()){ // only keep the most times of access in 1 hour
                res = cur;
            }
        }
        return res;
    }
    private static int timeDif(int t1, int t2){// t2 > t1
        int h1 = t1 / 100;
        int m1 = t1 % 100;
        int minute1 = 60*h1 + m1;
        int h2 = t2 / 100;
        int m2 = t2 % 100;
        int minute2 = 60*h2 + m2;
        return minute2 - minute1;
    }

    public static void main(String[] args) {
        String[][] records = new String[][]{{"James", "1300"}, {"Martha", "1600"}, {"Martha", "1620"}, {"Martha", "1530"},{"Martha", "1720"}, {"Martha", "1640"}};
        System.out.println(multipleAccess(records));
    }
}
