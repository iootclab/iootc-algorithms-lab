package com.iootc.lab.algocasts;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * P5.单身数字
 * <p>题目：给你一个非空的整数数组，这个数组中有一个整数只出现了一次，其它的整数都出现两次，你要找出这个只出现一次的整数。<br/>
 * <p>描述：1. 比如说，给你的数组是：5, 7, 5, 6, 6，这里 7 只出现了一次，因此你要返回的就是 7。
 *
 * @author Johnathon Yuan
 * @since 2021-05-13 23:40
 */
public class Question5 {

    // Time: O(n), Space: O(n)
    public int isSingleNumberWithSet(int[] nums) {
        Set<Integer> uniqueSet = Sets.newHashSet();
        int sum = 0;
        int uniqueSum = 0;
        for (int num : nums) {
            if (!uniqueSet.contains(num)) {
                uniqueSum += num;
                uniqueSet.add(num);
            }
            sum += num;
        }
        return 2 * uniqueSum - sum;
    }

    // Time: O(n), Space: O(1)
    public int isSingleNumberWithXOR(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }


}
