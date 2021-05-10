package com.iootc.lab.chapter1;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 1.设计一个有 getMin 功能的栈
 * <p>
 * 题目：实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。<br/>
 * 要求：1. pop、push、getMin 操作的时间复杂度都是 O(1)。<br/>
 *      2. 设计的栈类型可以使用现成的栈结构。
 *
 * @author Johnathon Yuan
 * @since 2020-06-11 00:01
 */
public class Question1 {

    private Stack<Integer> dataStack;

    private Stack<Integer> minStack;

    public Question1() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(Integer number) {
        if (this.minStack.empty() || number <= this.getMin()) {
            this.minStack.push(number);
        }
        this.dataStack.push(number);
    }

    public int pop() {
        if (this.dataStack.isEmpty()) {
            throw new RuntimeException("Data stack is empty.");
        }
        int value = this.dataStack.pop();
        if (value == this.getMin()) {
            value = this.minStack.pop();
        }
        return value;
    }

    public int getMin() {
        if (this.minStack.isEmpty()) {
            throw new RuntimeException("Min stack is empty.");
        }
        return this.minStack.peek();
    }

    public static void main(String[] args) {
        Question1 question1 = new Question1();
        List<Integer> numbers = Arrays.asList(6, 3, 5, 4, 1, 2, 3);
        for (Integer number : numbers) {
            question1.push(number);
        }
        System.out.println(question1.getMin());
    }

}
