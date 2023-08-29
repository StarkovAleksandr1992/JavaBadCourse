package ru.starkov.first_week.validpalindrome;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        String str = s.trim().replaceAll("\\W", "");
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();
        return stringBuilder.toString().equalsIgnoreCase(str);
    }
}
