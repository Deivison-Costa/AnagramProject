package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class AnagramGeneratorTest {

    @Test
    void testNormalCase() {
        List<String> result = AnagramGenerator.generateAnagrams("abc");
        assertEquals(6, result.size());
        assertTrue(result.containsAll(List.of("abc", "acb", "bac", "bca", "cab", "cba")));
    }

    @Test
    void testSingleLetter() {
        List<String> result = AnagramGenerator.generateAnagrams("x");
        assertEquals(1, result.size());
        assertEquals("x", result.getFirst());
    }

    @Test
    void testEmptyInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                AnagramGenerator.generateAnagrams("")
        );
        assertEquals("Input must be a non-empty string.", exception.getMessage());
    }

    @Test
    void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () ->
                AnagramGenerator.generateAnagrams("a1b")
        );
    }

    @Test
    void testUppercaseLetters() {
        List<String> result = AnagramGenerator.generateAnagrams("AbC");
        assertEquals(6, result.size());
        assertTrue(result.containsAll(List.of("AbC", "ACb", "bAC", "bCA", "CAb", "CbA")));
    }

    @Test
    void testLongStringPerformance() {
        List<String> result = AnagramGenerator.generateAnagrams("abcd");
        assertEquals(24, result.size());
    }
}
