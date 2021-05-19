package com.iootc.lab.algocasts;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * P11.数组的全排列
 * <p>题目：给你一个整数数组，并且数组中没有重复元素，你要返回这个数组所有可能的排列。<br/>
 * <p>描述：比如说给你的数组是：
 * 0, 1, 2
 *
 * 你要返回的所有排列是：
 *
 * 0, 1, 2
 * 0, 2, 1
 * 1, 0, 2
 * 1, 2, 0
 * 2, 0, 1
 * 2, 1, 0
 *
 * @author Johnathon Yuan
 * @since 2021-05-19 22:59
 */
public class Question11 {

    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numberList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        permuteWithRecursive(numberList, 0, result);
        return result;
    }

    // Time: O(n*n!), Space: O(n)
    private static void permuteWithRecursive(List<Integer> nums, int start, List<List<Integer>> result) {
        if (start == nums.size()) {
            result.add(Lists.newArrayList(nums));
        } else {
            for (int i = start; i < nums.size(); i++) {
                Collections.swap(nums, i, start);
                permuteWithRecursive(nums, start + 1, result);
                Collections.swap(nums, i, start);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }


}
