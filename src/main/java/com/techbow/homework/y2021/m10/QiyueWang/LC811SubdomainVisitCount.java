package com.techbow.homework.y2021.m10.QiyueWang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC811SubdomainVisitCount {
    public static List<String> subdomainVisits(String[] cpdomains) {
        int n = cpdomains.length;
        Map<String, Integer> m = new HashMap<>();
        List<String> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String s = cpdomains[i];
            List<String> parsed = parse(s);
            int curNum = Integer.valueOf(parsed.get(0));
            for(int j = 1; j < parsed.size(); j++){
                int temp = m.getOrDefault(parsed.get(j), 0);
                m.put(parsed.get(j), curNum + temp);
            }
        }
        for(String s : m.keySet()){
            res.add(m.get(s) + " " + s);
        }
        return res;
    }
    private static List<String> parse(String s){
        String[] sArr = s.split(" ");
        String[] domains = sArr[1].split("\\.");
        List<String> res = new ArrayList<>();
        res.add(sArr[0]); // add repetition
        if(domains.length == 3){
            res.add((domains[0]+"."+domains[1]+"."+domains[2]));
            res.add((domains[1]+"."+domains[2]));
            res.add(domains[2]);
        }else{
            res.add((domains[0]+"."+domains[1]));
            res.add(domains[1]);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] cpdomains = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(subdomainVisits(cpdomains));// ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
    }
}
//time O(N) space O(N)
