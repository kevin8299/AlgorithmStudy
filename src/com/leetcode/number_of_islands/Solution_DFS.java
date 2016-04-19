package com.leetcode.number_of_islands;

/**
 * Created by Administrator on 2016/4/19.
 */
public class Solution_DFS {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int num = 0;

        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++)
                if(grid[i][j] == '1'){
//
//                    for(int a = 0; a < row; a++) {
//                        for (int b = 0; b < col; b++)
//                            System.out.print(grid[a][b] + " ");
//                        System.out.println();
//                    }
//                    System.out.println();

                    num++;
                    dfs(grid, i, j);
                }

        return num;
    }

    void dfs(char[][] grid, int i, int j){
        grid[i][j] = '0';
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for(int k = 0; k < 4; k++){
            int x = i + dx[k];
            int y = j + dy[k];
            if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1')
                dfs(grid, x, y);
        }
    }

}
