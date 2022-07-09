package com.teamblind.nygift75;

public class LC009_033 {
    //  33. Search in Rotated Sorted Array
    //  There is an integer array nums sorted in ascending order (with distinct values).

    //  Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length)
    //  such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
    //  For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

    //  Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
    //  You must write an algorithm with O(log n) runtime complexity.

    static class SolutionA {
        static public int search(int[] nums, int target) {
            int start = 0, end = nums.length - 1, mid;
            while (start != end) {
                mid = (start + end) / 2;
                if (nums[start] == target) {
                    return start;
                }
                if (nums[end] == target) {
                    return end;
                }
                if (nums[mid] == target) {
                    return mid;
                }

                if (nums[start] < nums[end]) {
                    if (target < nums[mid]) {
                        end = mid;
                    } else {
                        start = mid + 1;
                    }
                } else {
                    if (nums[mid] > nums[end]) {
                        if (target < nums[mid]) {
                            if (target > nums[start]) {
                                end = mid;
                            } else {
                                start = mid + 1;
                            }
                        } else {
                            start = mid + 1;
                        }
                    } else {
                        if (target > nums[mid]) {
                            if(target < nums[end]) {
                                start = mid + 1;
                            } else {
                                end = mid;
                            }
                        } else {
                            end = mid;
                        }
                    }
                }
            }
            if (nums[start] == target) {
                return start;
            } else {
                return -1;
            }
        }
    }



    public static void main(String[] args) {
        int[] input = new int[]{4,5,6,7,0,1,2};
        System.out.println(SolutionA.search(input, 0));
    }

}
