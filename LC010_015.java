package com.teamblind.nygift75;

import java.sql.Array;
import java.util.*;

public class LC010_015 {
    //15. 3Sum
    //Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
    //Notice that the solution set must not contain duplicate triplets.

    static class SolutionA {
        public static List<List<Integer>> threeSum(int[] nums) {
            HashMap<Integer, Integer> numsMap = new HashMap<>();
            List<List<Integer>> finalList = new ArrayList<>();

            if (nums.length < 3) {
                return finalList;
            }

            for (int i = 0; i < nums.length; i++) {
                int existingValue = numsMap.get(nums[i]) == null ? 0 : numsMap.get(nums[i]);
                numsMap.put(nums[i], existingValue + 1);
            }

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (numsMap.containsKey(-(nums[i] + nums[j]))) {
                        if (-(nums[i] + nums[j]) == nums[i] || -(nums[i] + nums[j]) == nums[j]) {
                            if (!(numsMap.get(-(nums[i] + nums[j])) >= 2))
                                continue;
                        }
                        if (nums[i] == -nums[j]) {
                            if (!(numsMap.get(-(nums[i] + nums[j])) >= 3))
                                continue;
                        }
                        List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[j], -(nums[i] + nums[j])));
                        Collections.sort(triplet);
                        if (!finalList.contains(triplet)) {
                            finalList.add(triplet);
                        }
                    }
                }
            }
            return finalList;
        }
    }

    static class SolutionB {
        public static List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> finalList = new LinkedList<>();
            if(nums.length < 3) {
                return finalList;
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i] > 0) break;
                int left = i + 1, right = nums.length - 1, sum = -nums[i];
                while(left < right) {
                    if (nums[left] + nums[right] == sum) {
                        List<Integer> triplet = new LinkedList<>(Arrays.asList(nums[i], nums[left], nums[right]));
                        if(!finalList.contains(triplet))
                            finalList.add(triplet);
                        left++;
                        right--;
                    }
                     else if (nums[left] + nums[right] < sum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return finalList;
        }
    }

    static class SolutionC {
        static List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList();
            if (nums.length < 3) return res;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i] > 0) break;
                if (i == 0 || (i > 0) && (nums[i] != nums[i - 1])) {
                    int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                    while (lo < hi) {
                        if (nums[lo] + nums[hi] == sum) {
                            res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                            while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                            while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                            lo++;
                            hi--;
                        } else if (nums[lo] + nums[hi] < sum) lo++;
                        else hi--;
                    }
                }
            }
            return res;
        }
    }


    public static void main(String[] args) {
        int[] input = new int[]{-2,0,1,1,2};
        System.out.println(SolutionB.threeSum(input));
    }
}
