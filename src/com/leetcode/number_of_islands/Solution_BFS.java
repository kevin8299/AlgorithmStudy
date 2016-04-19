package com.leetcode.number_of_islands;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Administrator on 2016/4/19.
 */
public class Solution_BFS {

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int row = grid.length;
        int col = grid[0].length;
        int num = 0;
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    q.add(i);
                    q.add(j);
                    num++;
                }

                while(q.size() > 0){
                    int xx = q.poll();
                    int yy = q.poll();
                    grid[xx][yy] = '0';
                    for(int k = 0; k < 4; k++) {
                        int x = xx + dx[k];
                        int y = yy + dy[k];

                        if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == '1') {
                            q.add(x);
                            q.add(y);
                        }
                    }
                }
            }

        return num;
    }

}
