package com.leetcode.number_of_islands;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Administrator on 2016/4/19.
 */
public class Solution_UF {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] v = new boolean[row][col];

        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++)
                v[i][j] = false;

        Queue<Node> q = new LinkedList<>();
        UF uf = new UF(row * col);

        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++){
                if(!v[i][j] && grid[i][j] == '1')
                    q.add(new Node(i, j));
                while(q.size() > 0){
                    Node n = q.poll();
                    v[n.x][n.y] = true;

                    for(int k = 0; k < 4; k++) {
                        int x = n.x + dx[k];
                        int y = n.y + dy[k];

                        if (x >= 0 && x < row && y >= 0 && y < col && !v[x][y] && grid[x][y] == '1') {
                            q.add(new Node(x, y));
                            uf.union(x * col + y, n.x * col + n.y);
                        }
                    }
                }
            }

        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++)
                //System.out.println(i + " " + j);
                if (grid[i][j] == '0')
                    uf.ids[i * col + j] = -1;

        Set<Integer> num = new HashSet<>();
        for(int i = 0; i < row * col; i++)
            num.add(uf.ids[i]);

        return num.size() - 1;
    }

    class Node{
        int x, y;
        Node(int a, int b){
            x = a;
            y = b;
        }
    }

    class UF {
        int[] ids;
        int[] sz;

        UF(int n) {
            ids = new int[n];
            sz = new int[n];
            for (int i = 0; i < n; i++) {
                ids[i] = i;
                sz[i] = 1;
            }
        }

        int root(int i) {
            while (i != ids[i]) {
                ids[i] = ids[ids[i]];
                i = ids[i];
            }
            return i;
        }

        public void union(int p, int q) {
            int pr = root(p);
            int qr = root(q);

            if (pr == qr)
                return;

            if (sz[pr] > sz[qr]) {
                ids[qr] = pr;
                sz[pr] += sz[qr];
            } else {
                ids[pr] = qr;
                sz[qr] += sz[pr];
            }
        }

        public boolean find(int p, int q) {
            return root(p) == root(q);
        }
    }

    class UF_Slow{
        int[] ids;

        UF_Slow(int n){
            ids = new int[n];
            for(int i = 0; i < ids.length; i++)
                ids[i] = i;
        }

        void union(int x, int y){
            int xId = ids[x];
            int yId = ids[y];
            for(int i = 0; i < ids.length; i++)
                if(ids[i] == xId) ids[i] = yId;
        }

        boolean find(int x, int y){
            return ids[x] == ids[y];
        }
    }
}
