package com.iootc.lab.algocasts;

/**
 * P3.有序数组中求和为给定值的两个数
 * <p>题目：给你一个整数数组，并且这个数组是按递增排序的，你要找到数组中的两个整数，它们的和等于给定的目标值，然后返回它们的下标。
 *         题目假设给你的数组总是有且只有一个解，而且同一个元素不能使用两次。另外，返回结果的下标要从 1 开始。。<br/>
 * <p>描述：1. 比如说给你的数组是：1, 2, 3, 6, 8, 11，目标值是 10。那么，满足条件的两个整数是，2 和 8，它们的和是 10。
 *         所以你要返回它们的下标是 [2, 5]。<br/>
 *
 * @author Johnathon Yuan
 * @since 2021-05-12 22:10
 */
public class Question3 {

    // Time: O(n), Space: O(1)
    public static int[] findTwoNumSumFromArraysByVioence(int[] nums, int target) {
        if (nums.length <= 0) {
            return new int[]{-1, -1};
        }
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] > target) {
                --j;
            } else if (nums[i] + nums[j] < target) {
                ++i;
            } else {
                return new int[] {i + 1, j + 1};
            }
        }
        return new int[]{-1, -1};
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7, 10, 11};
        System.out.println(findTwoNumSumFromArraysByVioence(nums, 14));
    }

}
