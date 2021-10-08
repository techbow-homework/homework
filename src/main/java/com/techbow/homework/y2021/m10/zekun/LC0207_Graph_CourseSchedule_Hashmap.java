package LC;

import java.util.*;

public class LC0207_Graph_CourseSchedule_Hashmap {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //cc
        if(numCourses == 0) return false;

        //convert 2d array to graph
        Map<Integer, List<Integer>> graph = new HashMap<>(prerequisites.length);
        for(int[] path : prerequisites){
            graph.put(path[0], Arrays.asList(path[1]));
        }
        //
        Set<Boolean> visited = new HashSet<>();
        Map<Integer, Boolean> mem = new HashMap<>();

        for (int cur : graph.keySet()){
            if(dfsGraph(cur, graph, visited, mem)){
                return true;
            }
        }
        return false;
    }

    private boolean dfsGraph(int cur, Map<Integer, List<Integer>> graph, Set<Boolean> visited, Map<Integer, Boolean> mem){
        //sucess base case;
        if(visited.contains(cur)) return true;

        if(mem.get(cur) != null) return mem.get(cur);

        visited.add(cur);
        for(Integer next : graph.get(cur)){
            if(dfsGraph(next, graph, visited, mem)){
                mem.put(cur, true);
                return true;
            }
        }
        visited.remove(cur);
        mem.put(cur, false);
        return false;

    }
}
