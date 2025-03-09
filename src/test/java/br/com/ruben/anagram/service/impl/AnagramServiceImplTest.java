package br.com.ruben.anagram.service.impl;

import br.com.ruben.anagram.service.AnagramService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AnagramServiceImplTest {

    private AnagramService anagramService;

    private static final String INVALID_INPUT_ERROR =
            "Invalid input: must contain only letters and cannot be empty.";

    @BeforeEach
    public void setUp() {
        anagramService = new AnagramServiceImpl();
    }

    @Test
    void testGenerateAnagramsWithNormalInput() {
        // Caso normal, entrada com mais de uma letra
        String input = "abc";
        Set<String> result = anagramService.generateAnagrams(input);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertTrue(result.contains("abc"));
        assertTrue(result.contains("acb"));
        assertTrue(result.contains("bac"));
        assertTrue(result.contains("bca"));
        assertTrue(result.contains("cab"));
        assertTrue(result.contains("cba"));
    }

    @Test
    void testGenerateAnagramsWithSingleLetterInput() {
        // Caso extremo, entrada com uma única letra
        String input = "a";
        Set<String> result = anagramService.generateAnagrams(input);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertTrue(result.contains("a"));
    }

    @Test
    void testGenerateAnagramsWithEmptyInput() {
        // Caso extremo, entrada vazia
        String input = "";
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> anagramService.generateAnagrams(input)
        );

        assertEquals(INVALID_INPUT_ERROR, thrown.getMessage());
    }

    @Test
    void testGenerateAnagramsWithInvalidCharacters() {
        // Caso extremo, entrada com caracteres não permitidos (ex: números)
        String input = "ab1";
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> anagramService.generateAnagrams(input)
        );

        assertEquals(INVALID_INPUT_ERROR, thrown.getMessage());
    }
}