package com.teamblind.nygift75;

public class LC017_190 {
    //    190. Reverse Bits
    //    Reverse bits of a given 32 bits unsigned integer.

    static class SolutionA {
        // you need treat n as an unsigned value

        public static int reverseBits(int n) {
            int res = 0;
            for (int i = 0; i < 32; i++) {
                res <<= 1;
                res += ((n >>> i) & 1);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int input = Integer.parseInt("00000010100101000001111010011100", 2);
        System.out.println(Integer.toBinaryString(SolutionA.reverseBits(input)) + "(" + SolutionA.reverseBits(input) + ")" + " | " + Integer.toBinaryString(input) + "(" + input + ")");
    }
}
