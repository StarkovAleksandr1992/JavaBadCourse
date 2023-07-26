package ru.starkov.second_week.longest_palindrome;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
 * <p>
 * Letters are case-sensitive, for example, "Aa" is not considered a palindrome here.
 */
public class LongestPalindrome {
    /*
    Алгоритм решения задачи
    1. Создать Map, где ключем является Character, а значением является количество его вхождений в заданной строке.
    2. Пройти по всему словарю, проверяя значения больше 2 и кратные двум.
    Например если значение равно 3, то к длине палиндрома нужно прибавить его целую часть.
    Если значение кратно двум, то удалить этот ключ из словаря.
    3. Если размер Map > 0, то к результату прибавить единицу, так как любой символ можно добавить к строке, являющейся
    палиндромом и она останется палиндромом.
     */

    public int longestPalindrome(String s) {
        Map<Character, Long> collect = s.chars().mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(character -> character, Collectors.counting()));
        int palindromeLength = 0;
        Map<Character, Long> characterLongMap = Map.copyOf(collect);
        for (Map.Entry<Character, Long> entry : characterLongMap.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                palindromeLength += collect.remove(entry.getKey());
            } else if (entry.getValue() > 2) {
                palindromeLength += (entry.getValue() - entry.getValue() % 2);
            }
        }
        return collect.isEmpty() ? palindromeLength : palindromeLength + 1;
    }
}
