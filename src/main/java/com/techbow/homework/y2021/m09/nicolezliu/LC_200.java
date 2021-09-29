package com.techbow.homework.y2021.m09.boyuan;

// to check if it is an island:
// if all island land's 4 edges are either water or already in set of lands

class Solution {
    private static final int[][] DIRECTIONS = new int[][] {
	    {0, 1}, {1, 0}, {-1, 0}, {0, -1}
    };
    
    public int numIslands(char[][] grid) {
        
    /*  start from 0,0 by adding it to queue
    change grid to 0
        use bfs to add lands to its(head of queue) UDLR to queue
        when queue is empty, island is finished, 
    */
        int res = 0;  
        Queue<int[]> q = new LinkedList<>();
        
        int m = grid.length;
        int n = grid[0].length;
        if (m == 0 || n == 0) return 0;
        
//         initiate first land
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == '1') {
                    q.add(new int[] {i, j});        
                    grid[i][j] = '0';
                    
                    while (!q.isEmpty()) {
                        int[] cord = q.poll();
                        int row = cord[0];
                        int col = cord[1];

                        for (int[] direction : DIRECTIONS) {
                            int r = row + direction[0];
                            int c = col + direction[1];

            //                 tets if valid cord
                            if (r < 0 || c < 0 || r >= m || c >= n) {
                                continue;
                            }

            //                 test if is land
                            if (grid[r][c] == '1') {
                                q.add(new int[] {r, c});
                                grid[r][c] = '0';            
                            }
                        }
                    }
                    
                    res++;
                    // System.out.println(res);
                }
            }
        }
        
        System.out.println(res);
        return res;
       
    
    }
    
}


