package falsigram.text.utils;

import org.apache.logging.log4j.util.Chars;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class ReplacerTest {

    @Test
    void testliste() {
        List<List<Character>> homophoneA = Data.homophoneA;
        List<Character> characters = homophoneA.get(0);
        for (int i = 0; i < 100; ++i) {
            List<Character> characters1 = homophoneA.stream()
                    .filter(e -> !e.equals(characters)).findAny().get();
            System.out.println(characters1);
        }

        List<List<Character>> collect = homophoneA.stream()
                .filter(e -> !e.equals(characters)).collect(Collectors.toList());
        System.out.println(collect.get(Data.randomGenerator.nextInt(collect.size())));

    }

    @Test
    void adzza() {
        List<List<Character>> content = new ArrayList<>();

        final String texte = "   Fablab Aix   ";
        Arrays.asList(texte.trim().split(" ")).forEach(s -> {
            List<Character> characters = new ArrayList<>();
            for (char c : s.toCharArray())
                characters.add(c);
            content.add(characters);
        });
        System.out.println(content);

    }

}