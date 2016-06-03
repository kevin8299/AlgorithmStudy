package com.self_practices.brokerage;

/**
 * Created by Administrator on 2016/5/31.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Main {

    //static int[] ids = {1,2,4,7,8,9,19,20,21};
    //static int[] ps = {0,1,0,1,1,2,4,0,1};
    //static int[] earnings = {36000,10000,48000,50000,120000,39000,40000,26000,20000};

    //sample 1
    /*
    static int[] ids = {1,2,3};
    static int[] ps = {0,1,1};
    static int[] earnings = {17000 * 2/3,42000 * 2/3,69000 * 2/3};
    */

    //sample 2
    /*
    static int[] ids = {1,2,3,4,5,6,7};
    static int[] ps = {0,1,1,2,2,3,3};
    static int[] earnings = {21000 * 2/3,42000 * 2/3,69000 * 2/3,54000*2/3,27000*2/3,54000*2/3,27000*2/3};
    */

    //sample 3
    /*
    static int[] ids = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
    static int[] ps = {0,1,1,2,2,3,3,0,8,8,9,9,10,10};
    static int[] earnings = {21000 * 2/3,42000 * 2/3,69000 * 2/3,54000*2/3,27000*2/3,54000*2/3,27000*2/3,
            21000 * 2/3,42000 * 2/3,69000 * 2/3,54000*2/3,27000*2/3,54000*2/3,27000*2/3};
    */

    //sample 4
    /*
    static int[] ids = {1,2,3,4,6,7};
    static int[] ps = {0,1,1,2,3,3};
    static int[] earnings = {21000 * 2/3,42000 * 2/3,69000 * 2/3,54000*2/3,54000*2/3,27000*2/3};
    */

    //sample 5
    /*
    static int[] ids = {1,2,3,4,5,8,9,10,13,14};
    static int[] ps = {0,1,1,1,2,3,3,3,4,4};
    static int[] earnings = {21000 * 2/3,42000 * 2/3,69000 * 2/3,18000 *2/3,54000*2/3,
                             54000*2/3,27000*2/3,18000 *2/3,54000*2/3,27000*2/3};
    */

    //sample 6
    /*
    static int[] ids = {5,1,8,2,9,4,14,3,13,10};
    static int[] ps = {2,0,3,1,3,1,4,1,4,3};
    static int[] earnings = {54000 * 2/3,21000 * 2/3,54000 * 2/3,42000 *2/3,27000*2/3,
            18000*2/3,27000*2/3,69000 *2/3,54000*2/3,18000*2/3};
    */

    //sample 7
    /*
    static int[] ids = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    static int[] ps = {0,1,1,1,2,3,3,4,4,5,5,11,11};
    static int[] earnings = {21000 * 2/3,42000 * 2/3,69000 * 2/3,0,54000*2/3,
            54000*2/3,27000*2/3,54000*2/3,27000*2/3,18000 *2/3,0,21000 *2/3,42000*2/3};
    */

    //sample 8
    /*
    static int[] ids = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    static int[] ps = {0,1,1,1,2,3,3,4,4,5,5,11,11};
    static int[] earnings = {0 * 2/3,0 * 2/3,0 * 2/3,0,0*2/3,
            0*2/3,0*2/3,0*2/3,0*2/3,0 *2/3,0,0 *2/3,0*2/3};
    */

    //sample 9
    static int[] ids = {2,3,4,5,6,7,8,9,10,11,12,13,1};
    static int[] ps = {1,1,1,2,3,3,4,4,5,5,11,11,0};
    static int[] earnings = {42000 * 2/3,69000 * 2/3,0,54000*2/3,
            54000*2/3,27000*2/3,54000*2/3,27000*2/3,18000 *2/3,0,21000 *2/3,42000*2/3,0 * 2/3};

    static int N = ids.length;
    static Company[] allCompany = new Company[N];
    static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public static void main(String[] args) {

        // Calculate brokerage
        System.out.println("============== Brokerage Calculation Start =================");
        init();
        getBrokerage();
        System.out.println("============== Brokerage Calculation End =================\n");
    }

    static void init(){
        int[] ps1 = new int[N];
        for(int i = 0; i < N; i++)
            ps1[i] = ps[i];
        Arrays.sort(ps1);

        int pNum = 0;
        for(int i = 1; i < N; i++){
            if(ps1[i] - ps1[pNum] != 0)
                ps1[++pNum] = ps1[i];
        }

        for(int i = 0; i < N; i++){
            int leaf = 1;
            for(int j = 1; j < pNum + 1; j++)
                if(ids[i] == ps1[j]) {
                    leaf = 0;
                    break;
                }

            int n=0;
            for(int j=0;j<N;j++)
            {
                if(ids[i]==ps[j])
                {
                    n++;
                }
            }

            Company c = new Company(ids[i], ps[i], leaf, n,earnings[i], -1);
            allCompany[i] = c;
            map.put(ids[i], i);
        }
    }

    static void getBrokerage(){
        int N = ids.length;

        System.out.println("Input:");
        for(int j=0;j<N;j++)
        {
            System.out.println("id-parent-isLeaf-childNumber-earnings:"+allCompany[j].id+", "+
                    allCompany[j].parent+", "+allCompany[j].leaf+", "+allCompany[j].childNumber+", "+allCompany[j].earning);
        }

        for(int i = 0; i < N; i++) //sum all earnings for different company
            if(allCompany[i].leaf == 1) {
                //System.out.println("One leaf is " + allCompany[i].id);
                sumEarnings(i);
            }

        System.out.println("\n=========1.Earnings Result===========");
        for(int j=0;j<N;j++)
        {
            allCompany[j].childNumber=allCompany[j].childNumberCpy;
            System.out.println("id-parent-isLeaf-childNumber-earnings:"+allCompany[j].id+", "+
                    allCompany[j].parent+", "+allCompany[j].leaf+", "+allCompany[j].childNumber+", "+allCompany[j].earning);
        }

        for(int i = 0; i < N; i++)  //calculate bonus
            allCompany[i].calcBonus();

        System.out.println("\n==========2.Bonus Result==========");
        for(int j=0;j<N;j++)
        {
            System.out.println("id-parent-isLeaf-earnings-bonus:"+allCompany[j].id+", "+
                    allCompany[j].parent+", "+allCompany[j].leaf+", "+allCompany[j].earning+", "+allCompany[j].bonus);
        }


        System.out.println("\n==========3.Bonus Final Result==========");
        for(int i = 0; i < N; i++)  //share bonus
            if(allCompany[i].leaf == 1) {
                // System.out.println("Parent is " + allCompany[i].id);
                shareBonus(i);  //sum all earnings
            }

        System.out.println("Summary: ");
        for(int i = 0; i < N; i++)
            System.out.println("id: " + allCompany[i].id + " earnings: " + allCompany[i].earning + " bonus: " + allCompany[i].bonus);

    }

    static void shareBonus(int index){
        int indexPrev = index;
        int idNext = allCompany[indexPrev].parent;
        //int c_id = allCompany[indexPrev].id;

        while(idNext != 0){
            // System.out.println("child-parent+bonus:"+", "+c_id+","+idNext + ", " + allCompany[indexPrev].bonus);
            int index1 = map.get(idNext);
            allCompany[index1].bonus -= allCompany[indexPrev].bonusCpy;
            allCompany[index1].childNumber--;

            if(allCompany[index1].childNumber>=1)
                break;
            indexPrev = index1;
            //c_id = allCompany[indexPrev].id;
            idNext = allCompany[index1].parent;
        }
    }

    static void sumEarnings(int index){
        int indexPrev = index;
        int idNext = allCompany[indexPrev].parent;
        //int c_id = allCompany[indexPrev].id;

        while(idNext != 0){
            //System.out.println("child-parent+earning:"+", "+c_id+","+idNext + ", " + allCompany[indexPrev].earning);
            int index1 = map.get(idNext);
            allCompany[index1].earning += allCompany[indexPrev].earning;
            allCompany[index1].childNumber--;

            if(allCompany[index1].childNumber>=1)
                break;
            indexPrev = index1;
            /// c_id = allCompany[indexPrev].id;
            idNext = allCompany[index1].parent;
        }
    }

/*
    static void dfsShow(){
        for(int i = 0; i < N; i++){
            if(ps[i] == 0){
                System.out.println("root: " + ids[i]);
                dfs(ids[i]);
            }
        }
    }

    static void dfs(int id){

        //add implementations here
        System.out.println(id);
        //......

        for(int i = 0; i < N; i++)
            if(ps[i] == id)
                dfs(ids[i]);
    }


    static void bfsShow(){
        Identity[] all = new Identity[N];
        for(int i = 0; i < N; i++)
            all[i] = new Identity(ids[i], ps[i]);

        Arrays.sort(all);

        int prev = all[0].parent;
        int stage = 0;
        for(int i = 0; i < N; i++){
            if(all[i].parent != prev){
                stage++;
                prev = all[i].parent;
            }
            System.out.println("stage " + stage + " : " + all[i].id);
        }
    }

    */
}
