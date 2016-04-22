package com.leetcode.merge_sorted_array;

/**
 * Created by Administrator on 2016/4/22.
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //  {1,3,6,7,11}  {4,8,10}

        int[] n1 = new int[m + 1];
        int[] n2 = new int[n + 1];

        for(int i = 0; i < m; i++)
            n1[i] = nums1[i];
        n1[m] = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++)
            n2[i] = nums2[i];
        n2[n] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for(int k = 0; k < m + n; k++){
            if(n1[i] < n2[j]){
                nums1[k] = n1[i];
                i++;
            }
            else{
                nums1[k] = n2[j];
                j++;
            }
        }
    }
}
