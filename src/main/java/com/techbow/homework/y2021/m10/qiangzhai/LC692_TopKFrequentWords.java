package com.techbow.homework.y2021.m10.qiangzhai;

public class LC692_TopKFrequentWords {
    ```java
    //map.getOrDefault(a,b)当Map集合中有这个key时，就使用这个key值，如果没有就使用默认值defaultValue
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        //cc
        if (words == null || words.length == 0 || k <= 0) return result;
        Map<String, Integer> map = new HashMap<>();
        //create hashmap <key,value> --> <words,frequency>
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        //map.put(word,getOrDefault(word,0) + 1);
        //create min heap
        PriorityQueue<String> heap = new PriorityQueue<>(k,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                if(map.get(s1).equals(map.get(s2))) {//sort the words with same fre by lexicographical order
                    return s2.compareTo(s1);//字母表靠前，在这里表示大，所以S1,S2换了位置
                }
                return map.get(s1) > map.get(s2) ? 1 : -1;
            }
        });
        //sort
        for (String key : map.keySet()) {
            if (heap.size() < k) {
                heap.offer(key);
            } else {
                if (map.get(key) >= map.get(heap.peek())) {
                    heap.offer(key);
                    heap.poll();//如果调换poll与offer的顺序，有些test case跑不过！why？
                }
            }
        }
        //better sort here,heap管比大小
        for (String key : map.keySet()) {
            heap.offer(key);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        //
        //from highest to lowest
        while (!heap.isEmpty()) {
            result.add(0,heap.poll());//poll出来放在index 0的位置
        }
        return result;
    }
//can use word, frequency wrapped into a class
```
}
