package com.leetcode.reverse_vowels_of_a_string;

/**
 * Created by Administrator on 2016/4/25.
 */
public class Solution {
    public String reverseVowels(String s) {
        //"hello"  --  "holle"    "leetcode"  --  "leotcede"
        if(s == null || s.length() == 0 || s.length() == 1) return s;

        char[] chs = s.toCharArray();
        int start = 0, end = chs.length - 1;
        while(start < end){
            if(!isVowel(chs[start])){
                start++;
                continue;
            }
            if(!isVowel(chs[end])){
                end--;
                continue;
            }
            swap(chs, start, end);
            start++;
            end--;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chs.length; i++)
            sb.append(chs[i]);
        return sb.toString();
    }

    void swap(char[] chs, int i, int j){
        char c = chs[i];
        chs[i] = chs[j];
        chs[j] = c;
    }

    boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'|| ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
            return true;
        else
            return false;
    }
}
