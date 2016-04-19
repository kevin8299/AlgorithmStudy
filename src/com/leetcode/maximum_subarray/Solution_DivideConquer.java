package com.leetcode.maximum_subarray;

/**
 * Created by Administrator on 2016/4/18.
 */
public class Solution_DivideConquer {
    public int maxSubArray(int[] nums) {
        // {-2, 1, -3, 4, -1, 2, 1, -5, 4} -- {4,−1,2,1} -- 6
        int max, x = 0, y = nums.length - 1;
        max = maxSub(nums, x, y);
        return max;
    }

    public int maxSub(int[] ns, int x, int y){
            if(x == y) return ns[x];

            int z = (x + y) / 2;
            int maxL = maxSub(ns, x, z);
            int maxR = maxSub(ns, z + 1, y);
            //show(ns, x, z, y);
            int maxAll = maxL > maxR ? maxL : maxR;

            int mL = ns[z], L = 0;
            for(int i = z; i >= x; i--) {
                L += ns[i];
                if (mL < L) mL = L;
            }

            int mR = ns[z + 1], R = 0;
            for(int i = z + 1; i <= y; i++) {
                R += ns[i];
                if (mR < R) mR = R;
            }

            if(mL + mR > maxAll)
                maxAll = mL + mR;

            return maxAll;
    }

    public void show(int[] ns, int x, int z, int y){
        for(int i = x; i <= z; i++)
            System.out.print(ns[i] + " ");
        System.out.print(" ---- ");
        for(int i = z + 1; i <= y; i++)
            System.out.print(ns[i] + " ");
        System.out.println();
    }
}
