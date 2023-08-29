package ru.starkov.second_week.counting_bits;

/**
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
 * ans[i] is the number of 1's in the binary representation of i.
 */
public class CountingBits {

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i < result.length; i++) {
            int k = i;
            while (k != 0) {
                result[i] += k & 1;
                k >>= 1;
            }
        }
        return result;
    }
}
