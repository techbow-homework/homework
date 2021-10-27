package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_692 {
    public List<String> topKFrequent(String[] words, int k) {
        //hashmap get count
        //qp get top count
        //pq size larger than k poll
        //after while loop, poll
        HashMap<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(
                (c1, c2) -> count.get(c1).equals(count.get(c2)) ? c2.compareTo(c1) : count.get(c1) - count.get(c2)
        );
        for (String word : count.keySet()) {
            pq.add(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
