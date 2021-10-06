package com.techbow.homework.y2021.m09.jiale.oa.Twitter;

import java.util.*;

class First {

    /*
     * Complete the 'processLogs' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY logs
     *  2. INTEGER maxSpan
     */

    public static List<String> processLogs(List<String> logs, int maxSpan) {
        // Write your code here
        List<Integer> resTmp = new ArrayList<>();
        Map<String, Integer> signInMap = new HashMap<>();
        Map<String, Integer> signOutMap = new HashMap<>();
        for (String each : logs) {
            String[] tokens = each.split(" ");
            if (tokens[2].equals("sign-in")) {
                signInMap.put(tokens[0], Integer.parseInt(tokens[1]));
            } else if (tokens[2].equals("sign-out")) {
                signOutMap.put(tokens[0], Integer.parseInt(tokens[1]));
            }
        }
        for (Map.Entry<String, Integer> entity : signInMap.entrySet()) {
            String id = entity.getKey();
            if (signOutMap.containsKey(id) && (Math.abs(entity.getValue() - signOutMap.get(id))) <= maxSpan) {
                resTmp.add(Integer.parseInt(id));
            }
        }
        Collections.sort(resTmp);
        List<String> res = new ArrayList<>();
        for (Integer each : resTmp) {
            res.add(String.valueOf(each));
        }
        return res;
    }

}