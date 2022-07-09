package com.teamblind.nygift75;

import java.util.HashSet;

import static com.teamblind.nygift75.LC004_217.SolutionB.containsDuplicate;

public class LC004_217 {

    // 217. Contains Duplicate
    // Given an integer array nums, return true if any value appears at least twice in the array, and return false if
    // every element is distinct.

    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        System.arraycopy(a, 0, l, 0, mid);
        if (n - mid >= 0) System.arraycopy(a, mid, r, 0, n - mid);
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    private static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    static class SolutionA {
        public static boolean containsDuplicate(int[] nums) {
            mergeSort(nums, nums.length);
            int prevElement = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (prevElement == nums[i]) {
                    return true;
                }
            }
            return false;
        }
    }

    static class SolutionB {
        public static boolean containsDuplicate(int[] nums) {
            HashSet<Integer> integerHashSet = new HashSet<>();
            for (int num : nums) {
                if (!integerHashSet.add(num)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{3, 1, 2, 3, 4};
        System.out.println(containsDuplicate(input));
    }

}
