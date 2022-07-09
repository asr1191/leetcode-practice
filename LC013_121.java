package com.teamblind.nygift75;

public class LC013_121 {
    //    191. Number of 1 Bits
    //    Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

    static class SolutionA {
        // you need to treat n as an unsigned value
        static int hammingWeight(int n) {
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

    public static void main(String[] args) {
        int input = Integer.parseInt("00000000000000000000000000001011", 2);
        System.out.println(SolutionA.hammingWeight(input));
    }
}
