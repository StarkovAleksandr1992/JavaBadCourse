package ru.starkov.third_week.reverse_bits;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * <p>
 * Note:
 * <p>
 * Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.
 */
public class ReverseBits {

    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        return Integer.reverse(n);
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(-3));
    }
}
