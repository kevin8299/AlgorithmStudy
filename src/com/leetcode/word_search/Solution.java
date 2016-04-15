package com.leetcode.word_search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2016/4/6.
 */
public class Solution {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || "".equals(word))
            return false;

        int m = board.length;
        int n = board[0].length;
        int[][] sign = new int[m][n];

        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(word.charAt(0) == board[i][j]) {
                    sign[i][j] = 1;
                    if(word.length() == 1 || find(word, 0, board, i, j, sign))
                        return true;
                    sign[i][j] = 0;
                }
        return false;
    }

    public boolean find(String wd, int num, char[][] b, int x, int y, int[][] sign){
        //System.out.println(num);
        int[][] dxy = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        if(num == wd.length() - 1)
            return true;

        for(int i = 0; i < dxy.length; i++){
            int p = x + dxy[i][0];
            int q = y + dxy[i][1];

            if(p >= 0 && p < b.length && q >= 0 && q  < b[0].length && sign[p][q] != 1
                     && wd.charAt(num + 1) == b[p][q]) {
                sign[p][q] = 1;
                if(find(wd, num + 1, b, p, q, sign))
                    return true;
                sign[p][q] = 0;
            }
        }

        return false;
    }














    public boolean exist1(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0 || word == null || "".equals(word))
            return false;

        int m = board.length;
        int n = board[0].length;
        int[][] sign = new int[m][n];

        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(board[i][j] == word.charAt(0)){
                    sign[i][j] = 1;
                    if(search(board, i, j, word, sign))
                        return true;
                    sign[i][j] = 0;
                }

        return false;
    }

    class Point{
        int x, y, num;
        Point(int x1, int y1, int num1){
            x = x1;
            y = y1;
            num = num1;
        }
    }

    public boolean search(char[][] b, int x, int y, String wd, int[][] sign){
        Queue<Point> q = new LinkedList<Point>();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        q.add(new Point(x, y, 0));
        while(!q.isEmpty()){
            Point p = q.poll();
            sign[p.x][p.y] = 1;
            if(p.num == wd.length() - 1)
                return true;

            for(int i = 0; i < 4; i++){
                int x1 = p.x + dx[i];
                int y1 = p.y + dy[i];

                if(x1 >= 0 && x1 < b.length && y1 >= 0 && y1 < b[0].length && p.num + 1 < wd.length()
                        && wd.charAt(p.num + 1) == b[x1][y1] && sign[x1][y1] != 1) {

                    q.add(new Point(x1, y1, p.num + 1));
                }
            }
        }

        return false;
    }
}
