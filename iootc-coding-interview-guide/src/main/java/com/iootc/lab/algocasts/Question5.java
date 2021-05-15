package com.iootc.lab.algocasts;

/**
 * P5.不用+/-求两数之和
 * <p>题目：给你两个整数，在不使用 +/- 这两个运算符的前提下，求它们的和。<br/>
 * <p>描述：1. 比如说，给你的数组是：18、25，不用运算符求出它们之和。
 *
 * @author Johnathon Yuan
 * @since 2021-05-15 20:12
 */
public class Question5 {

    public int getSumRecursive(int a, int b) {
        return b == 0 ? a : getSumRecursive(a^b, (a&b) << 1);
    }

    // Time: O(m), Space: O(1)
    public int getSumIterative(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        Question5 question = new Question5();

        System.out.println(question.getSumRecursive(18, 25));
        System.out.println(question.getSumIterative(18, 25));
    }
}
