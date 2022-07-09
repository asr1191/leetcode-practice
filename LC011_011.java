package com.teamblind.nygift75;

import java.util.*;

public class LC011_011 {

    //    11. Container With Most Water
    //    You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
    //    Find two lines that together with the x-axis form a container, such that the container contains the most water.
    //    Return the maximum amount of water a container can store.
    //    Notice that you may not slant the container.

    static class SolutionA {
        public static int maxArea(int[] height) {
            long time = System.currentTimeMillis();
            HashMap<Integer, List<Integer>> heightVsPos = new HashMap<>();
            for (int i = 0; i < height.length; i++) {
                if (heightVsPos.containsKey(height[i])) {
                    heightVsPos.get(height[i]).add(i);
                } else {
                    heightVsPos.put(height[i], new LinkedList<>(Arrays.asList(i)));
                }
            }

            Arrays.sort(height);

            int maxArea = 0;
            int right = Integer.MIN_VALUE, left = Integer.MAX_VALUE;
            for (int i = height.length - 1; i >= 0; i--) {
                List<Integer> positions = heightVsPos.get(height[i]);
                left = Math.min(positions.get(0), left);
                right = Math.max(positions.get(positions.size() - 1), right);
                maxArea = Math.max(maxArea, (right - left) * height[i]);
            }
            System.out.println((System.currentTimeMillis() - time));
            return maxArea;
        }
    }

    static class SolutionB {
        public static int maxArea(int[] height) {
            int left = 0, right = height.length - 1;
            int maxArea = 0;
            while (left < right) {
                if (height[left] == height[right]) {
                    maxArea = Math.max(maxArea, (right - left) * height[left]);
                    left++;
                    right--;
                } else if (height[left] < height[right]) {
                    maxArea = Math.max(maxArea, (right - left) * height[left]);
                    left++;
                } else {
                    maxArea = Math.max(maxArea, (right - left) * height[right]);
                    right--;
                }
            }
            return maxArea;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(SolutionB.maxArea(input));
    }
}
