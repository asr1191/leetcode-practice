package com.teamblind.nygift75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC020_300 {
    //    300. Longest Increasing Subsequence
    //
    //    Given an integer array nums, return the length of the longest strictly increasing subsequence.
    //    A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing
    //    the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

    static class SolutionA {
        static int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int res = 1;
            for (int i = 1; i < nums.length; i++) {
                int j = i - 1, highestJ = 0;
                while(j >= 0) {
                    if (nums[j] <= nums[i]) {
                        highestJ = Math.max(highestJ, dp[j]);
                    }
                    j--;
                }
                    dp[i] = 1 + highestJ;
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }

    static class SolutionB {
        static int lengthOfLIS(int[] nums) {
            LinkedList<Integer> LISList = new LinkedList<>();
            LISList.add(nums[0]);

            for (int i = 1; i < nums.length; i++) {
                if (LISList.get(LISList.size() - 1) < nums[i]) {
                    LISList.add(nums[i]);
                } else {
                    replaceLowestFromList(LISList, nums[i]);
                }
            }
            return LISList.size();
        }

        static int replaceLowestFromList(LinkedList<Integer> list, int target) {
            int low = 0, hi = list.size() - 1;
            while (low < hi) {
                int mid = (low + hi) / 2;
                if (list.get(mid) == target) {
                    return mid;
                } else if (list.get(mid) < target) {
                    low = mid + 1;
                } else {
                    hi = mid;
                }
            }
            list.set(low, target);
            return low;
        }
    }

    public static void main(String[] args) {
        System.out.println(SolutionB.lengthOfLIS(new int[]{1,7,8,4,5,6,-1,9}));
//        System.out.println(SolutionB.replaceLowestFromList(new LinkedList<>(Arrays.asList(1,7,8,10,12,16,20)), 21 ));
    }
}
