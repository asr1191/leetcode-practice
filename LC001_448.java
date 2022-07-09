package com.teamblind.nygift75;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static java.lang.Math.abs;

public class LC001_448 {

    // 448. Find All Numbers Disappeared in an Array
    // Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in
    // the range [1, n] that do not appear in nums.

    static class SolutionA {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            HashSet<Integer> numbers = new HashSet<>();
            for (int i = 1; i <= nums.length; i++) {
                numbers.add(i);
            }
            for (int num : nums) {
                numbers.remove(num);
            }

            return new ArrayList<>(numbers);
        }
    }

    static class SolutionB {
        public static List<Integer> findDisappearedNumbers(int[] nums) {

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == -1) {
                    continue;
                }

                while (nums[i] != -1) {
                    if (nums[nums[i] - 1] != -1) {
                        int targetNumber = nums[nums[i] - 1];
                        nums[nums[i] - 1] = -1;
                        nums[i] = targetNumber;
                    } else {
                        break;
                    }
                }
                if (nums[i] == i + 1) {
                    nums[i] = -1;
                }
            }

            List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > -1) {
                    numbers.add(i + 1);
                }
            }
            return numbers;
        }
    }

    static class SolutionC {
        public static List<Integer> findDisappearedNumbers(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[abs(nums[i]) - 1] > 0) {
                    nums[abs(nums[i]) - 1] = -nums[abs(nums[i]) - 1];
                }
            }
            List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] > 0) {
                    numbers.add(i + 1);
                }
            }
            return numbers;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(SolutionC.findDisappearedNumbers(input));
    }


}
