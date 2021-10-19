package LC;
import java.util.*;

public class LC0200_BFS_NumIsland {
    private static final int[][] DIRECTIONS = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args){
        LC0200_BFS_NumIsland sol = new LC0200_BFS_NumIsland();
        char[][] input = {{'1', '1', '1', '1','0'}, {'1','1','0','1','0'},{'1','1','0','0','0'}, {'0','0','0','0','0'}};
        int res = sol.numIslands(input);
        System.out.println(res);
    }

    public int numIslands(char[][] grid) {
        //cc
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;

        int count = 0;
        int nrow = grid.length;
        int ncol = grid[0].length;

        boolean[][] visited = new boolean[nrow][ncol];

        for(int x = 0; x < nrow; x++){
            for(int y = 0; y < ncol; y++){
                if(grid[x][y] == '1' && !visited[x][y]){
                    bfs(grid, visited, x, y);
                    count++;
                }
            }
        }
        return count;

    }
    private void bfs(char[][] grid, boolean[][] visited, int x, int y){
        Queue<Integer> que = new LinkedList<>();
        int nrow = grid.length;
        int ncol = grid[0].length;
        que.offer(x * ncol + y);

        while(!que.isEmpty()){
            int queSize = que.size();
            for(int k = 0; k < queSize; k++){
                int cur = que.poll();
                int i = cur / ncol;
                int j = cur % ncol;

                if(grid[i][j] == '1'){
                    for(int[] dir: DIRECTIONS){
                        int ii = i + dir[0];
                        int jj = j + dir[1];
                        if(ii >= 0 && ii < nrow && jj >= 0 && jj < ncol && !visited[ii][jj] && grid[ii][jj]=='1'){
                            que.offer(ii * ncol + jj);
                            visited[ii][jj] = true;
                        }
                    }
                }else{
                    continue;
                }


            }


        }
    }
}
