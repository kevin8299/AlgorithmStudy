package com.leetcode.surrounded_regions;

/**
 * Created by Administrator on 2016/4/8.
 */
public class Test {
    public static void main(String[] args){
        System.out.println("test");
        char[][] b = {{'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}};
        char[][] b1 = {{'O','O','O'},
                {'O','O','O'},
                {'O','O','O'}};
        //Solution_BFS s = new Solution_BFS();
        //Solution_DFS s = new Solution_DFS();
        //Solution_UF1 s = new Solution_UF1();
        Solution_UF2 s = new Solution_UF2();
        s.solve(b);

        for(int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++)
                System.out.print(b[i][j] + "  ");
            System.out.println();
        }
    }
}
