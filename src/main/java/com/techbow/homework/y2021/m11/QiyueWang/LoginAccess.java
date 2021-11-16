package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.*;
// badge_records = [
//   ["Martha",   "exit"],
//   ["Paul",     "enter"],
//   ["Martha",   "enter"],
//   ["Martha",   "exit"],
//   ["Jennifer", "enter"],
//   ["Paul",     "enter"],
//   ["Curtis",   "enter"],
//   ["Paul",     "exit"],
//   ["Martha",   "enter"],
//   ["Martha",   "exit"],
//   ["Jennifer", "exit"],
// ]

// Expected output: ["Paul", "Curtis"], ["Martha"]
public class LoginAccess {
    public static List<Set<String>> notValid(String[][] records) {
        int n = records.length;
        Map<String, Integer> logs = new HashMap<>(); // + - 1 for enter and exit
        List<Set<String>> res = new ArrayList<>();
        res.add(new HashSet<>());// for enter
        res.add(new HashSet<>());// for exit
        for (int i = 0; i < n; i++) {
            String person = records[i][0];
            String action = records[i][1];
            int temp = logs.getOrDefault(person, 0);
            if (action.equals("enter")) {
                if (temp > 0) {//enter invalid
                    res.get(0).add(person);
                }
                logs.put(person, temp + 1);
            } else if (action.equals("exit")) {
                if (temp <= 0) { // exit invalid
                    res.get(1).add(person);
                }
                logs.put(person, temp - 1);
            }
        }
        for(String s : logs.keySet()){// only entered not exited
            if(logs.get(s) > 0){
                res.get(0).add(s);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[][] records = new String[][]{{"Martha", "exit"}, {"Paul", "enter"}, {"Martha", "enter"}, {"Martha", "exit"}, {"Jennifer", "enter"}, {"Paul", "enter"}, {"Curtis", "enter"}, {"Paul", "exit"}, {"Martha", "enter"}, {"Martha", "exit"}, {"Jennifer", "exit"}};
        List<Set<String>> res = notValid(records);
        System.out.println(res.get(0));
        System.out.println(res.get(1));
    }
}
