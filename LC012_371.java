package com.teamblind.nygift75;

public class LC012_371 {
    //    371. Sum of Two Integers
    //    Given two integers a and b, return the sum of the two integers without using the operators + and -.

    static class SolutionA {
        static int getSum(int a, int b) {
            while (b != 0) {
                int temp = (a ^ b) & ((a & b) << 1);
                a = (a ^ b) ^ ((a & b) << 1);
                b = temp << 1;
            }
            return a;
        }

    }

    public static void main(String[] args) {
        System.out.println(SolutionA.getSum(6, 3));
    }
}
