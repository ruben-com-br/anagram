package br.com.ruben.anagram.service;

import java.util.Set;

public interface AnagramService {
    Set<String> generateAnagrams(String str);
}
