package com.self_practices.alg;

import java.util.Random;

/**
 * Created by Administrator on 2016/5/17.
 */
public class Kmeans2 {

    public static void main(String[] args) {
        int[] ds = {1,2,3,7,8,11,12};
        int k = 3;
        int[] centers = kmeans(ds, k);
        for(int c: centers)
            System.out.print(c + "  ");

    }

    static int[] kmeans(int[] ds, int k){
        int[] centers = new int[k];
        int[] centersOld = new int[k];
        int[] belongs = new int[ds.length];
        boolean first = true;

        Random r = new Random();
        for(int i = 0; i < k; i++){
            int idx = r.nextInt(ds.length);
            centers[i] = ds[idx];
        }

        int iterNum = 100;
        for(int i = 0; i < iterNum; i++){
            System.out.println("Iterations Num : " + i);
            for(int j = 0; j < ds.length; j++)
                belongs[j] = -1;

            for(int j = 0; j < ds.length; j++){
                int min = Integer.MAX_VALUE;
                for(int x = 0; x < centers.length; x++){
                    int dist = Math.abs(centers[x] - ds[j]);

                    if(min > dist){
                        min = dist;
                        belongs[j] = x;
                    }
                }
            }

            for(int h = 0; h < ds.length; h++)
                System.out.print(belongs[h] + "  ");
            System.out.println();

            for(int x = 0; x < centers.length; x++){
                int centerSum = 0;
                int centerNum = 0;
                for(int y = 0; y < belongs.length; y++)
                    if(belongs[y] == x){
                        centerSum += ds[y];
                        centerNum++;
                    }
                if(centerNum != 0)
                    centers[x] = centerSum / centerNum;
            }

            if(!first)
                for (int y = 0; y < centers.length; y++)
                    if (centers[y] != centersOld[y])
                        break;

            for(int y = 0; y < centers.length; y++)
                centersOld[y] = centers[y];
            first = false;

        }

        return belongs;
    }

}
