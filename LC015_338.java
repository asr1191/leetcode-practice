package com.teamblind.nygift75;

public class LC015_338 {
    //    338. Counting Bits
    //    Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

    static class SolutionA {
        static int[] countBits(int n) {
            int[] res = new int[n + 1];

            for (int i = 0; i < n + 1; i++) {
                res[i] = hammingWeight(i);
            }
            return res;
        }

        private static int hammingWeight(int n) {
            int count = 0;
            int bit = 0;
            while(bit < 32) {
                if (((n >>> bit++) & 1) == 1) {
                    count++;
                }
            }
            return count;
        }
    }

    static class SolutionB {
        static int[] countBits(int n) {
            int[] res = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                if ((i & 1) == 1) {
                    res[i] = res[i >> 1] + 1;
                } else {
                    res[i] = res[i >> 1];
                }
            }
            return res;
        }
    }

    static class SolutionC {
        static int[] countBits(int n) {
            int[] res = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                res[i] = res[i >> 1] + (i & 1);
            }
            return res;
        }
    }


    public static void main(String[] args) {
        int n = 10;
        int[] res = SolutionA.countBits(n);
        for (int i = 0; i < n + 1; i++) {
            System.out.println(Integer.toBinaryString(i) + " = " + res[i]);
        }
    }

}
