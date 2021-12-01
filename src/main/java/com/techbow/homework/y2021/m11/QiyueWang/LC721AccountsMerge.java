package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.*;
import java.util.stream.Collectors;

public class LC721AccountsMerge {
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> visited = new HashSet<>();
        for(int i = 0; i < n; i++){
            List<String> cur = accounts.get(i);
            String head = cur.get(1);// pick the first element as head
            for(int j = 2; j < cur.size(); j++){
                //head connect to others
                if(!graph.containsKey(head)){
                    graph.put(head, new ArrayList<>());
                }
                graph.get(head).add(cur.get(j));

                // connect to head
                if(!graph.containsKey(cur.get(j))){
                    graph.put(cur.get(j), new ArrayList<>());
                }
                graph.get(cur.get(j)).add(head);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String name = accounts.get(i).get(0);
            String head = accounts.get(i).get(1);
            if(!visited.contains(head)){
                List<String> emails = new ArrayList<>();
                emails.add(name);
                dfs(graph, visited, emails, head);
                Collections.sort(emails.subList(1, emails.size()));
                res.add(emails);
            }
        }
        return res;
    }

    private static void dfs(Map<String, List<String>> graph, Set<String> visited, List<String> cur, String email){
        visited.add(email);
        cur.add(email);

        List<String> next = graph.get(email);
        if(next == null) return;
        for(String s : next){
            if(!visited.contains(s)){
                dfs(graph, visited, cur, s);
            }
        }
    }

    public static void main(String[] args) {
        String[][] accounts = new String[][]{{"Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"},{"Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"},{"Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"},{"Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"},{"Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"}};
        List<List<String>> accountsList = Arrays.stream(accounts).map(Arrays::asList).collect(Collectors.toList());
        System.out.println(accountsMerge(accountsList));//[["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]
    }
}
// time O(NKlog(NK)) space O(NK)
