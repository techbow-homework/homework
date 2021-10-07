/*
 * @lc app=leetcode id=692 lang=java
 *
 * [692] Top K Frequent Words
 */

// @lc code=start
class Solution {
    
    public List<String> topKFrequent(String[] words, int k) {
        Map<Integer, ArrayList<String> > map = new HashMap<Integer, ArrayList<String> >();
        Map<String, Integer> freq = new HashMap<String, Integer>();
        List<Integer> freqInt = new ArrayList<Integer>();
        for (String key: words) {
            freq.put(key, freq.containsKey(key) ? freq.get(key) + 1 : 1);
        }
        for (String word: freq.keySet()) {
            int f = freq.get(word);
            if(!map.containsKey(f)) {
                map.put(f, new ArrayList<String>());
            }
            map.get(f).add(word);
            freqInt.add(f);
        }
        
// //         heap
//         PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> b-a);
//         for (Integer i : map.keySet()) {
//             if (minHeap.size() <= k) minHeap.add(i);
//             else {
//                 minHeap.poll();
//                 minHeap.add(i);
//             }
//         }
        
        
        List<String> res = new ArrayList<String>();
        Collections.sort(freqInt, Collections.reverseOrder());
        for (Integer index: freqInt) {
            if (res.size() >= k) {
                for (int toRemove = res.size()-1; toRemove >= k; toRemove--) {
                    res.remove(toRemove);
                }
                return res;
            }
            List<String> tmp = map.get(freqInt.get(index));
            if (tmp.size() != 1) {
                Collections.sort(tmp);
            }
            for (String i : tmp) res.add(i);
        }
        return res;
        
//         while(!minHeap.isEmpty()) {
            
//             List<String> tmp = map.get(minHeap.poll());
// //                 break tie
//             if (tmp.size() != 1) {
//                     Collections.sort(tmp);
//             }
//             for (String i : tmp) res.add(i);
//         }
//         if (res.size() >= k) {
//             for (int toRemove = res.size()-1; toRemove >= k; toRemove--) {
//                 res.remove(toRemove);
//             }
//             return res;
//         }
//         if (res.size() == k) return res;
//         return res;
    }

}


// @lc code=end

