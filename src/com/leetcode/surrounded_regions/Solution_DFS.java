package com.leetcode.surrounded_regions;

/**
 * Created by Administrator on 2016/4/8.
 */
public class Solution_DFS {

    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++){
            dfs(board, i, 0);
            dfs(board, i, n-1);
        }

        for(int j = 0; j < n; j++){
            dfs(board, 0, j);
            dfs(board, m-1, j);
        }

        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == 'q')
                    board[i][j] = 'O';
            }

    }

    void dfs(char[][] board, int m, int n){
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        if(board[m][n] == 'O'){
            board[m][n] = 'q';
            for(int i = 0; i < 4; i++){
                int x = m + dx[i];
                int y = n + dy[i];
                if(x >= 0 && y >= 0 && x < board.length && y < board[0].length)
                    dfs(board, x, y);
            }
        }
    }
}
