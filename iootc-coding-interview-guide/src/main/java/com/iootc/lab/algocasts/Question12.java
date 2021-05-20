package com.iootc.lab.algocasts;

import org.apache.commons.lang3.StringUtils;

/**
 * P12.回文子串个数
 * <p>题目：给你一个字符串，你要计算出它所包含的回文子串个数。只要起始下标或终止下标不同，即使子串相同，我们也认为是不同的回文子串。<br/>
 * <p>描述：比如说，给你的字符串是：abc
 *  这个字符串中总共有 3 个回文子串，分别是 a， b 和 c。因此你要返回的个数是 3。
 *  再比如说，给你的字符串是：aba
 *  这个字符串中总共有 4 个回文子串，分别是 a，b，a，和 aba。
 *  因此你要返回的个数是 4。
 *
 * @author Johnathon Yuan
 * @since 2021-05-20 23:23
 */
public class Question12 {

    // Time: O(n^2), Space: O(n^2)
    public static int countPalindromicSubstringsForDP(String str) {
        if(StringUtils.isBlank(str)) {
            return 0;
        }
        int n = str.length(), count = 0;
        boolean[][] d = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    d[i][j] = true;
                } else if (i + 1 == j) {
                    d[i][j] = (str.charAt(i) == str.charAt(j));
                } else {
                    d[i][j] = str.charAt(i) == str.charAt(j) && d[i + 1][j - 1];
                }
                if (d[i][j]) {
                    ++count;
                }
            }
        }
        return count;
    }

    // Time: O(n^2), Space: O(1)
    public static int countPalindromicSubstringsExpand(String str) {
        if(StringUtils.isBlank(str)) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < str.length(); ++i) {
            count += expand(str, i, i);
            count += expand(str, i, i + 1);
        }
        return count;
    }

    private static int expand(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            ++count;
            --left;
            ++right;
        }
        return count;
    }


}
