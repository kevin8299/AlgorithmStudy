package com.leetcode.ReverseWordsInAString;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/15.
 */
public class Solution {

    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        // "the sky is blue"
        String[] parts = s.split(" ");
        List<String> list = new ArrayList<>();
        for(int i = parts.length - 1; i >= 0; i--){
            if(!"".equals(parts[i])){
                list.add(parts[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if(i != list.size() - 1) sb.append(" ");
        }
        String out = sb.toString();
        return out;
//        int num = -1;
//        for(int i = 0; i < parts.length; i++)
//            if("".equals(parts[i]))
//                num++;
//            else
//                break;
//        StringBuilder sb = new StringBuilder();
//        for(int i = parts.length - 1; i >= num + 1; i--) {
//            sb.append(parts[i]);
//            if(i != num + 1)
//                sb.append(" ");
//        }
//        return sb.toString();
    }

    public String reverseWords1(String s) {
        if(s == null || s.length() == 0) return s;
        // "the sky is blue"
        //List<Integer> stack = new ArrayList<>();
        char[] str = new char[s.length() + 1];
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i++){
            str[i] = ch[ch.length - i - 1];
        }
        str[s.length()] = '\0';
        System.out.println(str);
        return "";
    }
}
