package com.leetcode.reverse_vowels_of_a_string;

/**
 * Created by Administrator on 2016/4/25.
 */
public class Test {
    public static void main(String[] args){
        String s1 = "hello";  // "holle"
        String s2 = "leetcode";  // "leotcede"
        Solution s = new Solution();
        System.out.println(s.reverseVowels(s1));
        System.out.println(s.reverseVowels(s2));
    }

}
