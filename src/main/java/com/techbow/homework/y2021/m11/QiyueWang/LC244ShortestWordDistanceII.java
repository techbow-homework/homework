package com.techbow.homework.y2021.m11.QiyueWang;
//Example 1:
//
//Input
//["WordDistance", "shortest", "shortest"]
//[[["practice", "makes", "perfect", "coding", "makes"]], ["coding", "practice"], ["makes", "coding"]]
//Output
//[null, 3, 1]
//
//Explanation
//WordDistance wordDistance = new WordDistance(["practice", "makes", "perfect", "coding", "makes"]);
//wordDistance.shortest("coding", "practice"); // return 3
//wordDistance.shortest("makes", "coding");    // return 1

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC244ShortestWordDistanceII {
    private Map<String, List<Integer>> map;
    public LC244ShortestWordDistanceII(String[] wordsDict) {
        map = new HashMap<>();
        for(int i = 0; i < wordsDict.length; i++){
            List<Integer> temp = map.getOrDefault(wordsDict[i], new ArrayList<>());
            temp.add(i);
            map.put(wordsDict[i], temp);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        int i1 = 0;
        int i2 = 0;
        while(i1 < l1.size() && i2 < l2.size()){
            int cur = Math.abs(l1.get(i1) - l2.get(i2));
            res = Math.min(res,cur);
            if(l1.get(i1) < l2.get(i2)){
                i1++;
            }else{
                i2++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] dict = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        LC244ShortestWordDistanceII distance = new LC244ShortestWordDistanceII(dict);
        System.out.println(distance.shortest("coding", "practice")); //3
        System.out.println(distance.shortest("makes","coding")); // 1
    }
}
