package com.techbow.homework.y2021.m09.cma;
import java.util.*;

public class LC752 {
        public static int openLock(String[] deadends, String target) {
            HashSet<String> deadSet = new HashSet<>();
            if(target.equals("0000")){
                return 0;
            }
            for(String de: deadends){
                if(de.equals(target) || de.equals("0000")){
                    return -1;
                }
                deadSet.add(de);
            }

            HashSet<String> visited = new HashSet<>();
            Queue<char[]> queue = new LinkedList<>();
            queue.add(new char[] {'0','0','0','0'});
            visited.add("0000");
            int minLen = 0;

            while(!queue.isEmpty()){
                int size = queue.size();
                while(size -- > 0){
                    char[] cur = queue.poll();

                    List<char[]> nexts = convert(cur, deadSet, visited);
                    for(char[] next: nexts){
                        String nextString = String.valueOf(next);
                        if(nextString.equals(target)){
                            return minLen + 1;
                        }

                        queue.offer(next);
                        visited.add(nextString);
                    }
                }

                minLen ++;
            }

            return - 1;
        }

        private static List<char[]> convert(char[] cs, HashSet<String> deadSet, HashSet<String> visited){
            List<char[]> ret = new ArrayList<>();

            for(int i = 0 ; i < cs.length; i ++){
                char tmp = cs[i];

                if(tmp == '9'){
                    cs[i] = '0';
                } else{
                    cs[i] = (char) (tmp + 1);
                }
                String str = String.valueOf(cs);
                if(!deadSet.contains(str) && !visited.contains(str)){
                    ret.add(cs.clone());
                }


                if(tmp == '0'){
                    cs[i] = '9';
                } else{
                    cs[i] = (char) (tmp - 1);
                }
                str = String.valueOf(cs);
                if(!deadSet.contains(str) && !visited.contains(str)){
                    ret.add(cs.clone());
                }

                cs[i] = tmp;
            }

            return ret;
        }

        public static void main(String[] args){
            String[] deadends = {"1000"};
            int a = openLock(deadends, "0000");
            System.out.println(a);
        }
}
