package com.algorithms_coursera.shuffle;

/**
 * Created by Administrator on 2016/4/14.
 */
public class Test {
    public static void main(String[] args){
        int N = 52;
        int[] a = new int[N + 1];
        for(int i = 0; i < N + 1; i++)
            a[i] = i;

        Shuffle sf = new Shuffle();
        sf.KnuthShuffle(a);
        for(int i = 1; i < N + 1; i++)
            System.out.print(a[i] + " ");

    }
}
