package com.iootc.lab.algocasts;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 1.数组中和为指定值的两个数
 * <p>题目：给你一个整数数组和一个目标值，你要找到数组里两个整数， 它们的和等于目标值。然后返回这两个整数的下标。<br/>
 * <p>描述：1. 比如说给你的整数数组是：1, 2, 3, 6, 8, 11，目标值是 10。那么，满足条件的两个整数是，2 和 8，它们的和是 10。
 *         所以你要返回它们的下标是 1 和 4。<br/>
 *
 * @author Johnathon Yuan
 * @since 2021-05-10 15:40
 */
public class Question2 {

    // Time: O(n^2), Space: O(1)
    public static int[] findTwoNumSumFromArraysByVioence(int[] nums, int target) {
        if (nums.length <= 0) {
            return new int[]{-1, -1};
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // Time: O(n), Space: O(n)
    public static int[] findTwoNumSumFromArraysByHash(int[] nums, int target) {
        if (nums.length <= 0) {
            return new int[]{-1, -1};
        }
        Map<Integer, Integer> data = Maps.newHashMap();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (data.containsKey(num)) {
                return new int[]{data.get(num), i};
            }
            data.put(nums[i], i);
        }
        return new int[]{-1, -1};

    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 4, 0, -1};
        // System.out.println(findTwoNumSumFromArraysByVioence(nums, 10));
        System.out.println(findTwoNumSumFromArraysByHash(nums, 10));
    }

}
