package com.example;

import java.util.*;

/**
 * A utility class to generate all possible anagrams (permutations) of a given string containing distinct letters.
 * Uses recursion with backtracking for permutation generation.
 */
public class AnagramGenerator {

    /**
     * Generates all anagrams (permutations) of a given string containing distinct letters.
     *
     * @param input the string containing distinct letters
     * @return a sorted list of all possible anagrams
     * @throws IllegalArgumentException if input is null, empty, or contains non-letter characters
     */
    public static List<String> generateAnagrams(String input) {
        validateInput(input);
        List<String> result = new ArrayList<>();
        permute(input.toCharArray(), 0, result);
        Collections.sort(result);
        return result;
    }

    /**
     * Validates the input string to ensure it is non-empty and contains only letters.
     *
     * @param input the input string to validate
     * @throws IllegalArgumentException if input is invalid
     */
    private static void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input must be a non-empty string.");
        }
        if (!input.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Input must contain only alphabetic characters.");
        }
    }

    /**
     * Helper method to recursively generate permutations using backtracking.
     *
     * @param chars  the character array of the input string
     * @param index  the current position to swap characters
     * @param result the list to store anagrams
     */
    private static void permute(char[] chars, int index, List<String> result) {
        if (index == chars.length - 1) {
            result.add(new String(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            permute(chars, index + 1, result);
            swap(chars, index, i);
        }
    }

    /**
     * Swaps two characters in an array.
     *
     * @param chars the character array
     * @param i     first index
     * @param j     second index
     */
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
