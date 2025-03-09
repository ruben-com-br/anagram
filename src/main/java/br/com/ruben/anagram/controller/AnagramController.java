package br.com.ruben.anagram.controller;

import br.com.ruben.anagram.service.AnagramService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
class AnagramController {

    private final AnagramService anagramService;

    public AnagramController(AnagramService anagramService) {
        this.anagramService = anagramService;
    }

    @GetMapping("/anagram")
    public String generateAnagrams(@RequestParam(name = "text") String text, Model model) {
        try {
            Set<String> result = anagramService.generateAnagrams(text);
            model.addAttribute("anagrams", result);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", "Erro: " + e.getMessage());
        }
        return "anagramTemplate"; // Nome do arquivo HTML em src/main/resources/templates/
    }
}
