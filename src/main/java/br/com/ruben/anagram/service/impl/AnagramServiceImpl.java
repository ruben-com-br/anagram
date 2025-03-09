package br.com.ruben.anagram.service.impl;

import br.com.ruben.anagram.service.AnagramService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AnagramServiceImpl implements AnagramService {

    /**
     * Gera todos os anagramas possíveis de uma string fornecida.
     *
     * O método começa validando a entrada para garantir que a string seja válida (não nula, não vazia e contenha apenas letras).
     * Em seguida, o método usa uma estrutura de controle `switch` para decidir como gerar os anagramas com base no comprimento da string:
     * <ul>
     *     <li>Se o comprimento da string for 1, o único anagrama possível é a própria string.</li>
     *     <li>Se o comprimento for 2, o método gera os dois anagramas possíveis trocando os caracteres.</li>
     *     <li>Para strings com comprimento maior que 2, o método utiliza recursão para gerar todos os anagramas possíveis.</li>
     * </ul>
     *
     * @param str A string de entrada para gerar os anagramas. Deve conter apenas letras e não pode estar vazia.
     * @return Um conjunto de strings que contém todos os anagramas únicos gerados da string de entrada.
     * @throws IllegalArgumentException Se a string fornecida for inválida (nula, vazia ou contiver caracteres não permitidos).
     */
    @Override
    public Set<String> generateAnagrams(String str) {
        // Valida a entrada para garantir que a string seja válida (não nula, não vazia e apenas letras)
        validateInput(str);

        // Usando uma expressão switch para determinar a forma de gerar os anagramas
        return switch (str.length()) {
            case 1 -> Set.of(str);  // Para uma string de comprimento 1, apenas retorna a própria string como anagrama.
            case 2 -> Set.of(str, str.charAt(1) + "" + str.charAt(0));  // Para uma string de comprimento 2, gera os dois anagramas possíveis trocando os caracteres.
            default -> generateAnagramsPosValid(str);  // Para strings maiores, chama a função recursiva para gerar os anagramas.
        };
    }

    /**
     * Este método é responsável por gerar os anagramas de forma recursiva.
     * Para cada caractere na string, ele seleciona um caractere fixo e gera os anagramas
     * dos caracteres restantes recursivamente. A combinação é feita concatenando o caractere fixo
     * com os resultados das recursões.
     *
     * @param str A string para gerar os anagramas.
     * @return Um Set contendo os anagramas gerados de forma recursiva.
     */
    /**
     * Gera todos os anagramas possíveis de uma string fornecida, considerando apenas permutações únicas.
     *
     * Este método utiliza recursão para gerar os anagramas. A cada chamada recursiva, ele fixa um caractere da string
     * e gera os anagramas das substrings restantes, concatenando o caractere fixo com cada permutação gerada.
     * O processo continua até que a string tenha apenas um caractere, momento em que a recursão para e retorna o único anagrama possível.
     *
     * O resultado é um conjunto (`Set`) de anagramas, garantindo que não haja repetições de permutações.
     *
     * @param str A string de entrada para gerar os anagramas. A string deve ter pelo menos um caractere.
     * @return Um conjunto de strings (`Set<String>`) que contém todos os anagramas únicos gerados a partir da string fornecida.
     */
    private Set<String> generateAnagramsPosValid(String str) {
        // Caso base: se a string tem apenas um caractere, retorna ela mesma como único anagrama
        if (str.length() == 1) return Set.of(str);

        // Cria um HashSet para armazenar os anagramas, garantindo que não haja duplicatas
        Set<String> result = new HashSet<>();

        // Para cada caractere da string, fixa o caractere e gera os anagramas da substring restante
        for (int i = 0; i < str.length(); i++) {
            char fixedChar = str.charAt(i);  // O caractere fixo
            String remaining = str.substring(0, i) + str.substring(i + 1);  // Substring sem o caractere fixo

            // Chama recursivamente o método para gerar os anagramas da substring restante
            // Para cada anagrama da substring, adiciona o caractere fixo na frente
            generateAnagramsPosValid(remaining).forEach(sub -> result.add(fixedChar + sub));
        }

        // Retorna o conjunto de anagramas gerados
        return result;
    }

    /**
     * Este método valida a entrada, garantindo que a string não seja nula, vazia
     * e que contenha apenas caracteres alfabéticos.
     *
     * @param str A string a ser validada.
     * @throws IllegalArgumentException Se a string for inválida.
     */
    private void validateInput(String str) {
        if (str == null || str.isEmpty() || !str.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("Invalid input: must contain only letters and cannot be empty.");
        }
    }
}
