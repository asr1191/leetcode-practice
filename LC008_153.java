package com.teamblind.nygift75;


public class LC008_153 {
    //  153. Find Minimum in Rotated Sorted Array
    //  Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
    //
    //  [4,5,6,7,0,1,2] if it was rotated 4 times.
    //  [0,1,2,4,5,6,7] if it was rotated 7 times.
    //
    //  Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
    //  Given the sorted rotated array nums of unique elements, return the minimum element of this array.
    //  You must write an algorithm that runs in O(log n) time.

    // O(n)
    static class SolutionA {
        public static int findMin(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1]) {
                    return nums[i];
                }
            }
            return nums[0];
        }
    }

    static class SolutionB {
        public static int findMin(int[] nums) {

            if (nums.length == 1) {
                return nums[0];
            }

            int start = 0;
            int mid = nums.length / 2;
            int end = nums.length - 1;

            while (start != end) {
                if (nums[mid] > nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
                mid = (start + end) / 2;
            }

            return nums[start];

        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,3,4,5,-5,1};
        System.out.println(SolutionB.findMin(input));
    }
}
