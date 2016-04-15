package com.leetcode.word_search;

/**
 * Created by Administrator on 2016/4/6.
 */
public class Test {

    public static void main(String[] args) {
        char[][] b = {{'A', 'B', 'C', 'E'},
                      {'S', 'F', 'C', 'S'},
                      {'A', 'D', 'E', 'E'}};

        Solution s = new Solution();
        String s1 = "ABCCED";  //true
        String s2 = "SEE";     //true
        String s3 = "ABCB";    //false

        System.out.println(s.exist(b, s1));
        System.out.println(s.exist(b, s2));
        System.out.println(s.exist(b, s3));

    }

}
