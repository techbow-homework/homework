package LC;
import java.util.*;
public class LC0127_WordLadder_BFS {


    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {

            //cc
            if (wordList == null || wordList.size() == 0 || beginWord == null || endWord == null || beginWord.equalsIgnoreCase(endWord)) return 0;
            Set<String> dict = new HashSet<String>(wordList);
            if(!dict.contains(endWord)) return 0;


            Queue queue = new LinkedList<String>();
            int minLen = 1;
            queue.offer(beginWord);
            dict.remove(beginWord);

            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    String cur = (String) queue.poll();

                    List<String> nexts = changeOneCharacterInCurrentWord(cur);
                    for(String next : nexts){
                        if(next.equals(endWord)) return minLen + 1;
                        if(dict.contains(next) ){
                            queue.offer(next);
                            dict.remove(next);
                        }
                    }

                }
                minLen++;
            }
            return 0;
        }

        //add all possible other words to the dictionary
        public List<String> changeOneCharacterInCurrentWord(String word) {
            List<String> ret = new ArrayList<>();
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char curChar = chars[i];
                for (int j = 0; j < 26; j++) {
                    char charNext = (char) ('a' + j);
                    if (charNext == curChar) continue;
                    chars[i] = charNext;
                    ret.add(String.valueOf(chars));
                }
                chars[i] = curChar;//这里记住要把cur word变回去;
            }
            return ret;
        }

    }
}
