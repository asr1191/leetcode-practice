package com.teamblind.nygift75;

import static com.teamblind.nygift75.LC005_238.SolutionA.productExceptSelf;

public class LC006_053 {
    // 53. Maximum Subarray
    // Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest
    // sum and return its sum.

    static class SolutionA {
        // Kadane's Algorithm
        static int maxSubArraySum(int a[]) {
            int size = a.length;
            int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

            for (int i = 0; i < size; i++) {
                max_ending_here = max_ending_here + a[i];
                if (max_so_far < max_ending_here)
                    max_so_far = max_ending_here;
                if (max_ending_here < 0)
                    max_ending_here = 0;
            }
            return max_so_far;
        }
    }

    static class SolutionB {
        static int maxSubArraySum(int nums[]) {
            int sum = 0;
            int largestSum = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (sum > largestSum) {
                    largestSum = sum;
                }
                if (sum < 0) {
                    sum = 0;
                }
            }
            return largestSum;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{5,4,-1,7,8};
        System.out.println(SolutionB.maxSubArraySum(input));
    }
}
