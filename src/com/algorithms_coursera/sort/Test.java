package com.algorithms_coursera.sort;

/**
 * Created by Administrator on 2016/4/11.
 */
public class Test {
    public static void main(String[] args){
        System.out.println("test");
        int[] data = {1, 2, 9, 4, 3, 3, 1, 8, 5};

        for(int i = 0; i < data.length; i++)
            System.out.print(data[i] + "  ");
        System.out.println();

        Sort sort = new Sort();
        sort.SelectionSort(data);
        for(int i = 0; i < data.length; i++)
            System.out.print(data[i] + "  ");
        System.out.println();

        data = new int[]{1, 2, 9, 4, 3, 3, 1, 8, 5};
        sort.InsertionSort1(data);
        for(int i = 0; i < data.length; i++)
            System.out.print(data[i] + "  ");
        System.out.println();

        data = new int[]{1, 2, 9, 4, 3, 3, 1, 8, 5};
        sort.InsertionSort2(data);
        for(int i = 0; i < data.length; i++)
            System.out.print(data[i] + "  ");
        System.out.println();

        data = new int[]{1, 2, 9, 4, 3, 3, 1, 8, 5};
        sort.MergeSort(data, 0, data.length - 1);
        for(int i = 0; i < data.length; i++)
            System.out.print(data[i] + "  ");
        System.out.println();

        data = new int[]{1, 2, 9, 4, 3, 3, 1, 8, 5};
        sort.ShellSort(data);
        for(int i = 0; i < data.length; i++)
            System.out.print(data[i] + "  ");
        System.out.println();

    }
}
