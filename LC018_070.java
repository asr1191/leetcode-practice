package com.teamblind.nygift75;

public class LC018_070 {
    //    70. Climbing Stairs
    //    You are climbing a staircase. It takes n steps to reach the top.
    //    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

    static class SolutionA {
        static int climbStairs(int n) {
            if (n < 2) {
                return n;
            }

            int[] results = new int[n + 1];
            results[0] = 0;
            results[1] = 1;
            results[2] = 2;

            for (int i = 3; i < n + 1; i++) {
                results[i] = results[i - 2] + results[i - 1] + 1;
            }

            return results[n];
        }
    }
    public static void main(String[] args) {
        System.out.println(SolutionA.climbStairs(3));
    }
}
