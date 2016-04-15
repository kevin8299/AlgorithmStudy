package com.algorithms_coursera.shuffle;

import java.util.Random;

/**
 * Created by Administrator on 2016/4/14.
 */
public class Shuffle {
    public void KnuthShuffle(int[] a){
        Random r = new Random();
        for(int i = 1; i < a.length; i++){
            int rd =  r.nextInt(i);
            swap(a, i, rd);
        }
    }

    void swap(int[] arr, int x, int y){
        int d = arr[x];
        arr[x] = arr[y];
        arr[y] = d;
    }


}
