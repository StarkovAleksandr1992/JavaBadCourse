package ru.starkov.second_week.add_binary;

import java.math.BigInteger;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 */
public class AddBinary {
    /*
    100
     11

     */
    public String addBinary(String a, String b) {
        StringBuilder newA = new StringBuilder(a);
        StringBuilder newB = new StringBuilder(b);
        if (a.length() < b.length()) {
            for (int i = 0; i < b.length() - a.length(); i++) {
                newA.insert(0, "0");
            }
        } else if (b.length() < a.length()) {
            for (int i = 0; i < a.length() - b.length(); i++) {
                newB.insert(0, "0");
            }
        }
        a = newA.toString();
        b = newB.toString();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int cary = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0) {
            if (a.charAt(i) == '1' && b.charAt(j) == '1' && cary == 0) {
                result.append("0");
                cary++;
            } else if (a.charAt(i) == '1' && b.charAt(j) == '1' && cary > 0) {
                result.append("1");
            } else if (a.charAt(i) != b.charAt(j) && cary == 0) {
                result.append("1");
            } else if (a.charAt(i) != b.charAt(j) && cary > 0) {
                result.append("0");
            } else if (a.charAt(i) == '0' && b.charAt(j) == '0' && cary == 0) {
                result.append("0");
            } else if (a.charAt(i) == '0' && b.charAt(j) == '0' && cary > 0) {
                result.append("1");
                cary--;
            }
            i--;
            j--;
        }
        while (cary > 0) {
            if (cary == 1) {
                result.append("1");
                break;
            }
            result.append("0");
            cary--;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        BigInteger numA = new BigInteger("1111", 2);
        BigInteger numB = new BigInteger("1111", 2);
        BigInteger sum = numA.add(numB);
        System.out.println(sum.toString(2));
    }
}
