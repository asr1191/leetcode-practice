package com.teamblind.nygift75;

public class LC016_268 {
    //    268. Missing Number
    //    Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

    static class SolutionA {
        static int missingNumber(int[] nums) {
            boolean zeroAccounted = false;
            for (int i = 0; i < nums.length; i++) {
                if (Math.abs(nums[i]) == nums.length) {
                    continue;
                } else {
                    if (nums[Math.abs(nums[i])] == 0) {
                        zeroAccounted = true;
                    }
                    nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if(nums[i] > 0 || ( nums[i] == 0 && !zeroAccounted)) {
                    return i;
                }
            }
            return nums.length;
        }
    }

    static class SolutionB {
        static int missingNumber(int[] nums) {
            int xor = 0;
            for (int i = 0; i < nums.length; i++) {
                xor = xor ^ i ^ nums[i];
            }
            return xor ^ nums.length;

        }
    }

    // A XOR A XOR B XOR B XOR C = C
    public static void main(String[] args) {
        int[] input = new int[]{9,6,4,2,3,5,7,0,1};
        System.out.println(SolutionB.missingNumber(input));
    }
}
