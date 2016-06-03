package com.self_practices.brokerage;

/**
 * Created by Administrator on 2016/5/31.
 */
public class Company {
    int id;
    int parent;
    int leaf;
    int childNumber;
    int childNumberCpy;
    double earning;
    double bonus;
    double bonusCpy;

    double[] pers = {0.6,0.65,0.7,0.75,0.8,0.85,0.9,0.95,1};
    double[] section = {0,20000,50000,75000,100000,250000,500000,750000,1000000};


    Company(int i, int p, int l,int n, double e, double b){
        id = i;
        parent = p;
        bonus = b;
        earning = e;
        leaf = l;
        childNumber = n;
        childNumberCpy =n;
    }

    void calcBonus()
    {
        double[] value = new double[pers.length - 1];

        for(int i=0; i<pers.length - 1; i++) {
            value[i] = (section[i + 1]-section[i]) * pers[i];
        }

        if(section[0]<=earning && earning<=section[1])
            bonus = earning*pers[0];
        else if(section[1]<earning && earning<=section[2])
            bonus = (earning-section[1])*pers[1]+value[0];
        else if(section[2]<earning && earning<=section[3])
            bonus = (earning-section[2])*pers[2]+value[1]+value[0];
        else if(section[3]<earning && earning<=section[4])
            bonus = (earning-section[3])*pers[3]+value[2]+value[1]+value[0];
        else if(section[4]<earning && earning<=section[5])
            bonus = (earning-section[4])*pers[4]+value[3]+value[2]+value[1]+value[0];
        else if(section[5]<earning && earning<=section[6])
            bonus = (earning-section[5])*pers[5]+value[4]+value[3]+value[2]+value[1]+value[0];
        else if(section[6]<earning && earning<=section[7])
            bonus = (earning-section[6])*pers[6]+value[5]+value[4]+value[3]+value[2]+value[1]+value[0];
        else if(section[7]<earning && earning<=section[8])
            bonus = (earning-section[7])*pers[7]+value[6]+value[5]+value[4]+value[3]+value[2]+value[1]+value[0];
        else if(section[8]<earning)
            bonus = earning*pers[8];
        bonusCpy = bonus;
    }
}
