package com.leetcode.maximum_subarray;

/**
 * Created by Administrator on 2016/4/13.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("test");
        //int[] data = {-2, 1, -3, 4, -1, 2, 1, -5, 4};  // {4,−1,2,1} -- 6
        int[] data = {-1}; //{8, -19, 5, -4, 20};
        Solution s = new Solution();
        //Solution_DividConquer s = new Solution_DividConquer();
        //Solution_SumFirst s = new Solution_SumFirst();
        int result = s.maxSubArray(data);

        System.out.println("Max subarray sum: " + result);

    }
}
