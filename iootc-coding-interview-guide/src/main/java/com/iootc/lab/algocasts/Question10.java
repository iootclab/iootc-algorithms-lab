package com.iootc.lab.algocasts;

/**
 * P10.数值的 n 次方
 * <p>题目：你要实现一个函数，用它来计算浮点数的 n 次方。<br/>
 * <p>描述：给你 2 和 11，你要计算出 2 的 11 次方的结果：
 *
 * f(2, 11) = 2^11
 *
 * @author Johnathon Yuan
 * @since 2021-05-18 23:17
 */
public class Question10 {

    // Time: O(n), Space: O(1)
    public double pow(double num, int n) {
        double result = 1;
        long absoluteN = Math.abs((long) n);
        for (int i = 0; i < absoluteN; i++) {
            result = result * num;
        }
        return n < 0 ? 1/result : result;
    }

    // Time: O(log(n)), Space: O(1)
    public double powFast(double num, int n) {
        double result = 1;
        long absoluteN = Math.abs((long) n);
        while (absoluteN != 0) {
            if ((absoluteN & 1) == 1) {
                result = result * num;
            }
            num *= num;
            absoluteN >>= 1;
        }
        return n < 0 ? 1/result : result;
    }

    public static void main(String[] args) {
        Question10 question10 = new Question10();
        //System.out.println(question10.pow(10, 5));
        System.out.println(question10.powFast(10, 5));
        System.out.println(question10.powFast(10, -5));
    }


}
