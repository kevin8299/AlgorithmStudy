package com.leetcode.count_of_range_sum;

/**
 * Created by Administrator on 2016/4/20.
 */
public class Test {

    public static void main(String[] args){
        int[] a = {-2, 5, -1};
        int lower = -2, upper = 2;
//        int[] a = {5,-23,-5,-1,-21,13,15,7,18,4,7,26,29,-7,-28,11,-20,-29,19,22,15,25,17,-13,11,-15,19,-8,3,12,-1,2,-1,-21,-10,-7,14,-12,-14,-8,-1,-30,19,-27,16,2,-15,23,6,14,23,2,-4,4,-9,-8,10,20,-29,29};
//        int lower = -19, upper = 10;

//        int[] a = {-2147483647,0,-2147483647,2147483647};
//        int lower = -564, upper = 3864;

        //Solution_DFS s = new Solution_DFS();
        //Solution s = new Solution();
        Solution_DivideConquer s = new Solution_DivideConquer();
        System.out.println(s.countRangeSum(a, lower, upper));
        System.out.println((3 + 3) >> 1);
    }

}
