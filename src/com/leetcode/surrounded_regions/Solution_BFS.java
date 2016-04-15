package com.leetcode.surrounded_regions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2016/4/8.
 */
public class Solution_BFS {

    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++){
            bfs(board, i, 0);
            bfs(board, i, n-1);
        }

        for(int j = 0; j < n; j++){
            bfs(board, 0, j);
            bfs(board, m-1, j);
        }

        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == 'q')
                    board[i][j] = 'O';
            }
    }

    class Point{
        int x, y;
        Point(int x1, int y1){
            x = x1;
            y = y1;
        }
    }

    void bfs(char[][] board, int m, int n){
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        Queue<Point> q = new LinkedList<Point>();

        if(board[m][n] == 'O') {
            board[m][n] = 'q';
            q.add(new Point(m, n));
            while (!q.isEmpty()) {
                Point p = q.poll();
                board[p.x][p.y] = 'q';
                for (int i = 0; i < 4; i++) {
                    int x = p.x + dx[i];
                    int y = p.y + dy[i];
                    if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && board[x][y] == 'O')
                        q.add(new Point(x, y));
                }
            }
        }
    }
}
