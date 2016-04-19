package com.leetcode.number_of_islands;

/**
 * Created by Administrator on 2016/4/18.
 */
public class Test {
    public static void main(String[] args){
        char[][] island1 = {{'1','1','1','1','0'},   //  1
                            {'1','1','0','1','0'},
                            {'1','1','0','1','0'},
                            {'0','0','0','0','0'}};

        char[][] island2 = {{'1','1','0','0','0'},   //  3
                            {'1','1','0','0','0'},
                            {'0','0','1','0','0'},
                            {'0','0','0','1','1'}};

        char[][] island3 ={};

        Solution_DFS s = new Solution_DFS();
        //System.out.println(s.numIslands(island1));
        //System.out.println(s.numIslands(island2));
        System.out.println(s.numIslands(island3));
    }
}
