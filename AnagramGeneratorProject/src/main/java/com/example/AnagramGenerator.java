package com.example;

import java.util.*;

/**
 * A utility class to generate all possible anagrams (permutations) of a given string containing distinct letters.
 * Uses Heap's Algorithm for efficient permutation generation.
 */
public class AnagramGenerator {

    /**
     * Generates all anagrams (permutations) of a given string containing distinct letters.
     *
     * @param input the string containing distinct letters
     * @return a list of all possible anagrams (already sorted in lexicographic order)
     * @throws IllegalArgumentException if input is null, empty, or contains non-letter characters
     */
    public static List<String> generateAnagrams(String input) {
        validateInput(input);
        List<String> result = new ArrayList<>();
        char[] chars = input.toCharArray();
        heapPermutation(chars, chars.length, result);
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
        for (char c : input.toCharArray()) {
            if (!Character.isLetter(c)) {
                throw new IllegalArgumentException("Input must contain only alphabetic characters.");
            }
        }
    }

    /**
     * Generates all permutations of the given character array using Heap's Algorithm.
     *
     * @param chars  the character array of the input string
     * @param n      the length of the remaining elements to permute
     * @param result the list to store anagrams
     */
    private static void heapPermutation(char[] chars, int n, List<String> result) {
        if (n == 1) {
            result.add(new String(chars));
            return;
        }

        for (int i = 0; i < n; i++) {
            heapPermutation(chars, n - 1, result);

            if (n % 2 == 1) {
                swap(chars, 0, n - 1);
            } else {
                swap(chars, i, n - 1);
            }
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
