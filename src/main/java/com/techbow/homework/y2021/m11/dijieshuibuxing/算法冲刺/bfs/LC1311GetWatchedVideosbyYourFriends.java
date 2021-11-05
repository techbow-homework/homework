package com.techbow.homework.y2021.m11.dijieshuibuxing.算法冲刺.bfs;

/*
There are n people, each person has a unique id between 0 and n-1. Given the arrays watchedVideos and friends, where watchedVideos[i] and friends[i] contain the list of watched videos and the list of friends respectively for the person with id = i.

Level 1 of videos are all watched videos by your friends, level 2 of videos are all watched videos by the friends of your friends and so on. In general, the level k of videos are all watched videos by people with the shortest path exactly equal to k with you. Given your id and the level of videos, return the list of videos ordered by their frequencies (increasing). For videos with the same frequency order them alphabetically from least to greatest.



Example 1:



Input: watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 1
Output: ["B","C"]
Explanation:
You have id = 0 (green color in the figure) and your friends are (yellow color in the figure):
Person with id = 1 -> watchedVideos = ["C"]
Person with id = 2 -> watchedVideos = ["B","C"]
The frequencies of watchedVideos by your friends are:
B -> 1
C -> 2
Example 2:



Input: watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 2
Output: ["D"]
Explanation:
You have id = 0 (green color in the figure) and the only friend of your friends is the person with id = 3 (yellow color in the figure).


Constraints:

n == watchedVideos.length == friends.length
2 <= n <= 100
1 <= watchedVideos[i].length <= 100
1 <= watchedVideos[i][j].length <= 8
0 <= friends[i].length < n
0 <= friends[i][j] < n
0 <= id < n
1 <= level < n
if friends[i] contains j, then friends[j] contains i
 */


import java.util.*;

public class LC1311GetWatchedVideosbyYourFriends {

    public static List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        //cc

        Queue<Integer> queue = new LinkedList<>();// contains friends id
        Set<Integer> visitedId = new HashSet<>();
        Map<String, Integer> freq = new HashMap<>();

        queue.offer(id);
        visitedId.add(id);
        int reachedLevel = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();

                for (int friend : friends[cur]) {
                    if (visitedId.add(friend)) {
                        queue.offer(friend);
                        for (String movie : watchedVideos.get(friend)) {
                            freq.put(movie, freq.getOrDefault(movie, 0) + 1);
                        }
                    }
                }
            }
            reachedLevel++;
            if (reachedLevel == level) {
                List<String> res = new ArrayList<>(freq.keySet());
                Collections.sort(res, (a, b) -> freq.get(a) == freq.get(b) ? a.compareTo(b) : freq.get(a) - freq.get(b));
                return res;
            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
       String[][] array =  {{"A","B"},{"C"},{"B","C"},{"D"}};
       List<List<String>> moives = new ArrayList<>();
       moives.add( Arrays.asList("A","B"));
        moives.add( Arrays.asList("C"));
        moives.add( Arrays.asList("B","C"));
        moives.add( Arrays.asList("D"));
       int[][] friends ={{1,2},{0,3},{0,3},{1,2}};
       watchedVideosByFriends(moives,friends,0,1);
    }

}
