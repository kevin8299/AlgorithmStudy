package com.leetcode.combination_sum;

import java.util.*;

/**
 * Created by Administrator on 2016/4/12.
 */
public class Solution_BuildTree {
    int num;
    int targ;
    int[] cdd;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        num = target /candidates[0];
        cdd = candidates;
        targ = target;
        Arrays.sort(candidates);

        Node init = new Node();
        init.setSum(0);

        buildTree(init, 0);

        return result(init);
    }

    List<List<Integer>> result(Node node){
        List<Node> all = new ArrayList<Node>();
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        while(!q.isEmpty()) {
            Node n = q.poll();
            if(n.next.isEmpty())
                all.add(n);
            for(int i = 0; i < n.next.size(); i++)
                q.add(n.next.get(i));
        }

        List<List<Integer>> out = new ArrayList<List<Integer>>();
        for(Node nn: all){
            if(nn.sum == targ) {
                List<Integer> l = new ArrayList<Integer>();
                for (int i : nn.arr) l.add(i);
                out.add(l);
            }
        }

        return out;
    }

    public void buildTree(Node node, int index){

        for(int j = index; j < cdd.length; j++) {
            int s = node.sum;
            if(s + cdd[j] > targ) continue;

            Node n = new Node();
            s += cdd[j];
            for(int d: node.arr)
                n.arr.add(d);

            n.arr.add(cdd[j]);

            n.setSum(s);
            node.insertNode(n);

            buildTree(n, j);
        }
    }

    class Node{
        int sum;
        List<Integer> arr;
        List<Node> next;

        Node(){
            next = new ArrayList<Node>();
            arr = new ArrayList<Integer>();
        }

        void setSum(int s){
            sum = s;
        }

        void insertIntoList(int in){
            arr.add(in);
        }

        void insertNode(Node node) {
            next.add(node);
        }
    }
}
