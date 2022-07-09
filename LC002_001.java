package com.teamblind.nygift75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LC002_001 {

    // 1. Two Sum
    // Given an array of integers nums and an integer target, return indices of the two numbers such that they add
    // up to target.
    // You may assume that each input would have exactly one solution, and you may not use the same element twice.
    // You can return the answer in any order.

    static class SolutionA {
        public static int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> valueVsPosition = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                valueVsPosition.put(nums[i],i);
            }
            for (int i = 0; i < nums.length; i++) {
                if(valueVsPosition.containsKey(target - nums[i]) && valueVsPosition.get(target - nums[i]) != i) {
                    return new int[]{i, valueVsPosition.get(target - nums[i])};
                }
            }
            return null;
        }
    }

    static class SolutionB {
        public static int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> valueVsPosition = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (!valueVsPosition.containsKey(target - nums[i])) {
                    valueVsPosition.put(nums[i],i);
                } else {
                    return new int[]{i, valueVsPosition.get(target - nums[i])};
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{3,2,4};
        System.out.println(Arrays.toString(SolutionB.twoSum(input, 6)));
    }
}
