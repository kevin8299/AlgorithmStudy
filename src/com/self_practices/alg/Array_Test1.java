package com.self_practices.alg;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/4/28.
 */
public class Array_Test1 {

    static void quicksort(char n[], int left, int right) {
        int dp;
        if (left < right) {
            dp = partition(n, left, right);
            quicksort(n, left, dp - 1);
            quicksort(n, dp + 1, right);
        }
    }

    static int partition(char n[], int left, int right) {
        char pivot = n[left];
        while (left < right) {
            while (left < right && n[right] >= pivot)
                right--;
            if (left < right)
                n[left++] = n[right];
            while (left < right && n[left] <= pivot)
                left++;
            if (left < right)
                n[right--] = n[left];
        }
        n[left] = pivot;
        return left;
    }

    public static void main(String[] args){
        String str = "aabcdefff";// abcdef
        char[] chs = str.toCharArray();

        //Arrays.sort(chs);
        quicksort(chs, 0, chs.length - 1);
        int idx = 0;
        for(int i = 1; i < chs.length; i++){
            if(chs[i] - chs[idx] != 0){
                chs[++idx] = chs[i];
            }
        }

        String result = String.valueOf(chs).substring(0, idx + 1);
        System.out.println(result);
    }

}
