package LC;
import java.util.LinkedList;
import java.util.Queue;

public class LC0130_BDFS_CircumedRegion {
    public static void main(String[] args){
        LC0130_BDFS_CircumedRegion obj = new LC0130_BDFS_CircumedRegion();
        char[][] input = {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}};
        char[][] sol = obj.solve(input);
        System.out.println(sol);
    }
    private static final int[][] DIRECTIONS = {{1,0}, {-1,0}, {0,1},{0,-1}};
    public char[][] solve(char[][] board) {
        //CC
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0) return board;

        //
        int nrow = board.length;
        int ncol = board[0].length;
        Queue<Integer> que = new LinkedList<>();

        //add O at edges to the queue
        for(int j = 0; j < ncol; j++){
            if(board[0][j] == 'O'){
                que.offer(0 * ncol + j);
                board[0][j] = 'M';
            }
        }
        for(int j = 0; j < ncol ; j++){
            if(board[nrow - 1][j] == 'O'){
                que.offer((nrow - 1) * ncol + j);
                board[nrow - 1][j] = 'M';
            }
        }
        for(int i = 1; i < nrow - 1; i++){
            if(board[i][0] =='O'){
                que.offer(i * ncol + 0);
                board[i][0] = 'M';
            }
        }
        for(int i = 1; i < nrow - 1; i++){
            if(board[i][ncol - 1] == 'O'){
                que.offer(i * ncol + ncol - 1);
                board[i][ncol - 1] = 'M';
            }
        }

        while(!que.isEmpty()){
            int cur = que.poll();
            int i = cur / ncol;
            int j = cur % ncol;
            for(int[] dir : DIRECTIONS){
                int ii = i + dir[0];
                int jj = j + dir[1];

                if(ii >= 1 && ii < nrow-1 && jj >= 1 & jj < ncol-1 && board[ii][jj] == 'O' && board[ii][jj] != 'M'){

                    que.offer(ii * ncol + jj);
                    board[ii][jj] = 'M';
                }
            }
        }

        for(int i = 0; i < nrow; i++){
            for(int j = 0; j < ncol; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'M'){
                    board[i][j] = 'O';
                }
            }
        }
        return board;
    }
}
