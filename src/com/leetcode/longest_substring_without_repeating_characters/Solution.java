package com.leetcode.longest_substring_without_repeating_characters;

/**
 * Created by Administrator on 2016/4/15.
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int[] location = new int[256];

        for(int i = 0; i < 256; i++)
            location[i] = -1;

        int idx = -1, length = 0, max = 0;
        for(int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if(location[c] > idx)
                idx = location[c];
            length = i - idx;
            if(max < length) max = length;
            location[c] = i;
        }
        return max;
    }

    public int lengthOfLongestSubstring1(String s) {
        // "abcabcbb" -- "abc" --  3.
        // "bbbbb" -- "b" -- 1.
        // "pwwkew" -- "wke" -- 3
        int start = 0, longest = 0, len = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = start; j < i; j++) {
                if(s.charAt(j) == s.charAt(i)) {
                    start = j + 1;
                    break;
                }
            }
            len = i - start + 1;
            if(len > longest) longest = len;
        }
        return longest ;
    }
}
