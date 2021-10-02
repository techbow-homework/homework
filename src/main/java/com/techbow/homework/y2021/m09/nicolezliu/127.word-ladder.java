import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
class Solution {
public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       
        // change list to set for quick lookup
        Set<String> wordSet = new HashSet<String>(wordList);

        // add beginWord to q
        Queue<String> q = new LinkedList<>();   
        q.offer(beginWord);
        
        // pop q, loop thru a-z if exists in wordList, add to q, counter++
        int counter = 1;
        while (!q.isEmpty()) {
            String curr = q.poll();
            if (curr.equals(endWord)) return counter;
            
            outerloop:
            for (char c = 'a'; c <= 'z'; c++) {
                for (int i = 0; i < beginWord.length(); i++) {
                    StringBuilder currCopy = new StringBuilder();
                    currCopy.append(curr);
                    currCopy.setCharAt(i, c);
                    if (wordSet.contains(currCopy.toString())) {
                        q.offer(currCopy.toString());
                        wordSet.remove(currCopy.toString());
                        break outerloop;
                    }
                }
            }
            counter++;
            
        }
        
         // edge case: if endWord not in wordList return 0
        return 0; 

    }
    
}