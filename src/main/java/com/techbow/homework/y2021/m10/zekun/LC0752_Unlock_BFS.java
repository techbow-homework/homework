package LC;
import java.util.*;

public class LC0752_Unlock_BFS {
    public static void main(String[] args){
        String[] deadend = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        LC0752_Unlock_BFS sol = new LC0752_Unlock_BFS();
        int res = sol.openLock(deadend, target);
        System.out.println(res);
    }

    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet<>();

        //cc
        for(String de : deadends){
            if(de.equals("0000")){
                return -1;
            }else{
                deadendSet.add(de);
            }
        }
        if(deadendSet.contains(target)) return -1;

        String start = "0000";
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int minLen = 1;
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String cur = queue.poll();
                if(cur.equals(target)){
                    return minLen;
                }else{
                    List<String> nextString = convert(cur, deadendSet, visited);
                    for(String s : nextString){
                            queue.offer(s);
                            visited.add(s);
                        }
                    }
                }
            minLen++;
        }

        return -1;
    }

    private List<String> convert(String cur, Set<String> deadSet, Set<String> visited){
        char[] curchar = cur.toCharArray();//convert string to char
        List<String> nextChars = new ArrayList<>();

        for(int i = 0; i < curchar.length; i++){
            char ci = curchar[i];
            if(ci == '9'){
                curchar[i] = '0';
            }else{
                curchar[i] = (char)(ci + 1);
            }

            String str = String.valueOf(curchar);
            if(!deadSet.contains(str) && !visited.contains(str)){
                nextChars.add(String.valueOf(curchar));
            }
            if(ci == '0'){
                curchar[i] = '9';
            }else{
                curchar[i] = (char) (ci - 1);
            }
            str = String.valueOf(curchar);
            if(!deadSet.contains(str) && !visited.contains(str)){
                nextChars.add(String.valueOf(curchar));
            }
            curchar[i] = ci;
        }
        return nextChars;
    }
}
