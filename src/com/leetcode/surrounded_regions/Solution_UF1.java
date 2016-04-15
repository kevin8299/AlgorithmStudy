package com.leetcode.surrounded_regions;

/**
 * Created by Administrator on 2016/4/8.
 */
public class Solution_UF1 {

    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length;
        int n = board[0].length;
        int N = m * n;

        UnionFind uf = new UnionFind(N + 1);
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++) {
                int cur = i * n + j;
                if (board[i][j] == 'O') {
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1)
                        uf.union(cur, N);
                    else{
                        if(i + 1 < m && board[i + 1][j] == 'O')
                            uf.union(cur, (i + 1) * n + j);
                        if(i - 1 >= 0 && board[i - 1][j] == 'O')
                            uf.union(cur, (i - 1) * n + j);
                        if(j + 1 < m && board[i][j + 1] == 'O')
                            uf.union(cur, i * n + j + 1);
                        if(j - 1 >= 0 && board[i][j - 1] == 'O')
                            uf.union(cur, i * n + j - 1);
                    }
                }
            }

        for(int i = 1; i < m - 1; i++)
            for(int j = 1; j < n - 1; j++)
                if(!uf.find(i * n + j, N))
                    board[i][j] = 'X';
    }

    class UnionFind {
        int[] index;

        UnionFind(int n){
            index = new int[n];
            for(int i = 0; i < n; i++) {
                index[i] = i;
            }
        }

        public void union(int p, int q) {
            int pid = index[p];
            int qid = index[q];

            for (int i = 0; i < index.length; i++)
                if (index[i] == pid)
                    index[i] = qid;

        }

        public boolean find(int p, int q) {
            return index[p] == index[q];
        }
    }
}
