package com.leetcode.longest_substring_without_repeating_characters;

/**
 * Created by Administrator on 2016/4/15.
 */
public class Test {
    public static void main(String[] args){
        String s1 = "abcabcbb"; //"abc" --  3.
        String s2 = "bbbbb";// "b" -- 1.
        String s3 = "pwwkew";// "wke" -- 3
        String s4 = "a";

        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring(s1));
        System.out.println(s.lengthOfLongestSubstring(s2));
        System.out.println(s.lengthOfLongestSubstring(s3));
        System.out.println(s.lengthOfLongestSubstring(s4));
    }
}
