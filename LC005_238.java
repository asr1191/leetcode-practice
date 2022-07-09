package com.teamblind.nygift75;

import java.util.Arrays;

import static com.teamblind.nygift75.LC005_238.SolutionB.productExceptSelf;

public class LC005_238 {

//     238. Product of Array Except Self
//     Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the
//     elements of nums except nums[i].
//     The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//     You must write an algorithm that runs in O(n) time and without using the division operation.

    static class SolutionA {
        public static int[] productExceptSelf(int[] nums) {
            int[] rightToLeft = new int[nums.length];

            rightToLeft[nums.length - 1] = nums[nums.length - 1];
            for (int i = nums.length - 2; i >= 0; i--) {
                rightToLeft[i] = nums[i] * rightToLeft[i + 1];
            }

            int[] result = new int[nums.length];
            result[0] = rightToLeft[1];
            int prev = nums[0];
            for (int i = 1; i < result.length - 1; i++) {
                result[i] = prev * rightToLeft[i + 1];
                prev *= nums[i];
            }
            result[nums.length - 1] = prev;

            return result;
        }
    }

    static class SolutionB {
        public static int[] productExceptSelf(int[] nums) {
            int[] result = new int[nums.length];
            result[0] = 1;
            for (int i = 1; i < result.length; i++) {
                result[i] = nums[i - 1] * result[i - 1];
            }

            int cumulativeProductR2L = 1;
            for (int i = result.length - 1; i >= 0; i--) {
                result[i] = result[i] * cumulativeProductR2L;
                cumulativeProductR2L *= nums[i];
            }

            return result;
        }
    }


    public static void main(String[] args) {
        int[] input = new int[]{2, 3, 4, 5};
        System.out.println(Arrays.toString(productExceptSelf(input)));
    }


}
