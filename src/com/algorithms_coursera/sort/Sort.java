package com.algorithms_coursera.sort;

/**
 * Created by Administrator on 2016/4/13.
 */
public class Sort {

    public void SelectionSort(int[] arr){
        for(int i = 0; i < arr.length; i++) {
            int min = i;
            for(int j = i + 1; j < arr.length; j++)
                if(arr[j] < arr[min])
                    min = j;
            swap(arr, min, i);
        }
    }

    public void InsertionSort1(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j > 0; j--){
                if(arr[j] < arr[j - 1])
                    swap(arr, j, j - 1);
                else
                    break;
            }
        }
    }

    public void InsertionSort2(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j = i - 1;
            while(j > 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = key;
        }
    }

    void swap(int[] arr, int x, int y){
        int d = arr[x];
        arr[x] = arr[y];
        arr[y] = d;
    }

    void MergeSort(int[] a, int p, int q){
        if(p < q) {
//            for(int i = p; i <= q; i++)
//                System.out.print(a[i] + "  ");
//            System.out.println();
            int m = (p + q) / 2;
            MergeSort(a, p, m);
            MergeSort(a, m + 1, q);
            Merge(a, p, m, q);
        }
    }

    void Merge(int[] a, int p, int m, int q){
//        for(int i = p; i <= m; i++)
//            System.out.print(a[i] + "  ");
//        System.out.println();
//        for(int i = m + 1; i <= q; i++)
//            System.out.print(a[i] + "  ");
//        System.out.println();
//        System.out.println();

        int len1 = m - p + 1, len2 = q - m;
        int[] ap = new int[len1 + 1];
        int[] aq = new int[len2 + 1];

        for(int i = 0; i < len1; i++)
            ap[i] = a[p + i];
        ap[len1] = Integer.MAX_VALUE;
        for(int i = 0; i < len2; i++)
            aq[i] = a[m + i + 1];
        aq[len2] = Integer.MAX_VALUE;

        int x = 0, y = 0;
        for(int i = p; i < q + 1; i++){
            if(ap[x] > aq[y]){
                a[i] = aq[y];
                y++;
            }
            else{
                a[i] = ap[x];
                x++;
            }
        }
    }

    void QuickSort(int[] a, int p, int q){

    }

    void ShellSort(int[] a){
        int N = a.length;
        int h = 1;
        while(h < N / 3) h = 3 * h + 1;
        while(h >= 1) {
            for(int i = h; i < N; i++){
                for(int j = i; j >= h && a[j] < a[j - h]; j -= h)
                    swap(a, j, j - h);
            }
            h /= 3;
        }
    }
}
