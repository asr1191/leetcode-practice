package com.teamblind.nygift75;

public class LC007_152 {
    // 152. Maximum Product Subarray
    //
    // Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product,
    // and return the product.
    //
    // It is guaranteed that the answer will fit in a 32-bit integer.
    // A subarray is a contiguous subsequence of the array.

    // 1ms
    static class SolutionA {
        public static int maxProduct(int[] nums) {
            int product = 1;
            int negativeProduct = 1;
            int largestProduct = Integer.MIN_VALUE;

            boolean firstNegativeEncountered = false;
            for (int i = 0; i < nums.length; i++) {

                if (product < 0) {
                    firstNegativeEncountered = true;
                } else if (product == 0) {
                    product = 1;
                    negativeProduct = 1;
                    firstNegativeEncountered = false;
                }

                product *= nums[i];
                if (firstNegativeEncountered)
                negativeProduct *= nums[i];

                if (product > largestProduct) {
                    largestProduct = product;
                }
                if (negativeProduct > largestProduct && firstNegativeEncountered) {
                    largestProduct = negativeProduct;
                }
            }

            return largestProduct;
        }
    }
    // 2ms
    static class SolutionB {
        public static int maxProduct(int[] nums) {
            int max = nums[0];
            int min = nums[0];
            int largest = nums[0];

            for (int i = 1; i < nums.length; i++) {
                int temp = max;
                max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
                min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);

                if (largest < max) {
                    largest = max;
                }
            }

            return largest;
        }
    }

    // 0ms solution, largest product from left to right, largest product from right to left. Largest of those is the
    // answer.

    public static void main(String[] args) {
        int[] input = new int[]{2,-5,-2,-4,3};
        System.out.println(LC007_152.SolutionB.maxProduct(input));
    }
}
