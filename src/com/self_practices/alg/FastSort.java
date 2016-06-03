package com.self_practices.alg;

/**
 * Created by Administrator on 2016/5/31.
 */
public class FastSort {

    public static void main(String[] args) {

        int[] ds = {1, 8, 6, 7, 4, 3, 6, 7, 8, 9, 2};
        fastSort(ds, 0, ds.length - 1);
        for(int d: ds)
            System.out.print(d + " ");
    }

    public static void fastSort(int[] ds, int s, int e) {
        if (s < e) {
            System.out.println("Start: " + s +"  End: " + e);
            for(int d: ds)
                System.out.print(d + " ");
            System.out.println("");

            int flag = ds[e];
            int idx = -1;
            for(int i = s; i <= e; i++) {
                if(ds[i] > flag){
                    if(idx == -1)
                        idx = i;
                }
                else{
                    if(idx != -1) {
                        int inter = ds[i];
                        ds[i] = ds[idx];
                        ds[idx] = inter;
                        idx++;
                    }
                }
            }

            if(idx == -1)
                idx = e;
            else
                --idx;

            System.out.println("index: " + idx);
            fastSort(ds, s, idx - 1);
            fastSort(ds, idx + 1, e);
        }
    }


}



