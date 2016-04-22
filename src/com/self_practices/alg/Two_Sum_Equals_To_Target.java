package com.self_practices.alg;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/4/20.
 */
public class Two_Sum_Equals_To_Target {

    public static void main(String[] args){
        int[] a = {1, 1, 6, 8, 1, 2, 7};
        int target = 10;
        int[] pair = getPair(a, target);
        System.out.println(pair[0] + " " + pair[1]);
    }

    public static int[] getPair(int[] a, int target){
        if(a == null || a.length == 0 || a.length == 1) return null;
        Arrays.sort(a);
        int[] result;
        int i = 0, j = a.length - 1, sum = 0;
        while(i != j){
            System.out.println("i= " + i + " j=" + j);
            sum = a[i] + a[j];
            if(sum < target)
                i++;
            else if(sum > target)
                j--;
            else
                break;
        }
        result = new int[]{a[i], a[j]};
        return result;
    }

}
