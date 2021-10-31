package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法加强.bfs;

import java.util.*;

public class LC126WordLadderII_反相建图 {

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //cc

        Queue<String> queue = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);
        Map<String, List<String>> graph = new HashMap<>();

        queue.offer(beginWord);
        dict.remove(beginWord);
        List<List<String>> res = new ArrayList<>();
        boolean findEnd = false;


        while(!queue.isEmpty()){
            int size = queue.size();
            Set<String> levelVisited = new HashSet<>();

            while(size-- >0) {
                String cur = queue.poll();
                char[] chars = cur.toCharArray();

                for (int i = 0; i < cur.length(); i++) {
                    char origin = chars[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (j == origin) continue;
                        chars[i] = j;
                        String next = String.valueOf(chars);
                        if (dict.contains(next)) {
                            if(endWord.equals(next)){
                                findEnd = true;
                            }
                            graph.computeIfAbsent(next, s -> new ArrayList<>()).add(cur);
                            if(levelVisited.add(next)){
                                queue.offer(next);
                            }
                        }
                    }
                    chars[i] = origin;
                }
            }
            if(findEnd){
                List<String> path = new ArrayList<>();
                path.add(endWord);
                recover(res,endWord,beginWord,path,graph);
                return res;
            }
            dict.removeAll(levelVisited);
        }
        return res;
    }

    private static void recover(List<List<String>> res, String beginWord, String endWord, List<String>  path,Map<String, List<String>> graph) {

        if(beginWord.equals(endWord)){
            res.add(new ArrayList<>(path));
            return;

        }

        List<String> neighbors = graph.get(beginWord);
        for(String next:neighbors ){
            path.add(0,next);
            recover(res,next,endWord,path,graph);
            path.remove(0);
        }
    }

        public static void main(String[] args) {
            String begin = "hit";
            String end = "cog";
            String[] array = new String[]{"hot","dot","dog","lot","log","cog"};
            System.out.println(  findLadders(begin, end, Arrays.asList(array)));

    }

}
