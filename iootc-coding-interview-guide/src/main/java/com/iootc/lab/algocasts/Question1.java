package com.iootc.lab.algocasts;

import org.apache.commons.lang3.StringUtils;

/**
 * 1.回文字符串判断
 * <p>题目：给你一个字符串，你要判断它是否是回文字符串。字符串里只考虑字母和数字，其它的字符可以无视。<br/>
 * <p>描述：1. 对于字母，可以忽略大小写。<br/>
 *         2. 比如说，给你的字符串是：" race a E-car "，只考虑字母数字并且忽略大小写，它是一个回文字符串，因此返回 true；
 *         再比如说，给你的字符串是：" race a car "，对比到最后，中间的 e 和 a 不相等，因此不是一个回文字符串，返回 false。
 *
 * @author Johnathon Yuan
 * @since 2021-05-10 15:40
 */
public class Question1 {

    private static boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    private static boolean isEqualIgnoreCase(char a, char b) {
        if (a >= 'A' && a <= 'Z') {
            a += 32;
        }
        if (b >= 'A' && b <= 'Z') {
            b += 32;
        }
        return a == b;
    }

    // Time: O(n), Space: O(1)
    public static boolean isPalindrome(String str) {
        if (StringUtils.isBlank(str)) {
            return true;
        }
        int i = 0, j = str.length() - 1;
        for (; i < j; ++i, --j) {
            while (i < j && !isAlphanumeric(str.charAt(i))) {
                ++i;
            }
            while (i < j && !isAlphanumeric(str.charAt(j))) {
                --j;
            }
            if (i < j && !isEqualIgnoreCase(str.charAt(i), str.charAt(j))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = " race a E-car ";
        // String str = " race a car ";
        System.out.println(isPalindrome(str));
    }

}
