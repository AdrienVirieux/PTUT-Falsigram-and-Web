/**
 *
 *
 *
 * @author Adrien Virieux
 *
 */

package falsigram.text.utils;

import falsigram.text.core.Sentence;
import falsigram.text.core.Text;

import java.text.Normalizer;
import java.util.*;


public class Deleter {

    /*    Fonctions    */
    /**
     * Default constructor
     */
    public Deleter() {
    }

    /* Public fonctions */
    /**
     * @param text Text
     * @param occurrence float
     */
    public static void deleteLetters(List<Sentence> text, float occurrence) {
        List<Character> tmp = new ArrayList<>();

        if (occurrence != 1) {
            Random rand = new Random();  // Initialisation d'un nombre Random
            for (Sentence sentence : text) {
                for (List<Character> word : sentence.getContent()) {
                    for (Character c : word) {
                        /* On créer un nombre aléatoire entre 0 et 1 */
                        if (rand.nextFloat() > occurrence)
                            tmp.add(c);
                    }
                    word.removeAll(tmp);
                }
            }
        } else {
            for (Sentence sentence : text)
                sentence.getContent().clear();
        }
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void deleteSpaces(List<Sentence> text, float occurrence) {
        if (occurrence != 1) {
            Random rand = new Random();  // Initialisation d'un nombre Random
            for (Sentence sentence : text) {
                for (int wordIndex = 1; wordIndex < sentence.getContent().size();) {
                    /* On créer un nombre aléatoire entre 0 et 1 */
                    if (rand.nextFloat() < occurrence) {
                        sentence.getContent().get(wordIndex-1).addAll(sentence.getContent().get(wordIndex));
                        sentence.getContent().remove(wordIndex);
                        continue;
                    }
                    ++wordIndex;
                }
            }
        } else {
            for (Sentence sentence : text) {
                for (int wordIndex = 1; wordIndex < sentence.getContent().size();) {
                    sentence.getContent().get(0).addAll(sentence.getContent().get(wordIndex));
                    sentence.getContent().remove(wordIndex);
                }
            }
        }
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void deleteAccents(List<Sentence> text, float occurrence) {
        if (occurrence != 1) {
            Random rand = new Random();  // Initialisation d'un nombre Random
            for (Sentence sentence : text) {
                for (List<Character> word : sentence.getContent()) {
                    for (int charIndex = 0; charIndex < word.size(); ++charIndex) {
                        if (word.get(charIndex).toString().matches("[À-ÿ]")) {
                            /* On créer un nombre aléatoire entre 0 et 1 */
                            if (rand.nextFloat() < occurrence) {
                                String tmp = Normalizer.normalize(String.valueOf(word.get(charIndex)), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
                                word.set(charIndex, tmp.charAt(0));
                            }
                        }
                    }
                }
            }
        } else {
            for (Sentence sentence : text) {
                for (List<Character> word : sentence.getContent()) {
                    for (int charIndex = 0; charIndex < word.size(); ++charIndex) {
                        if (word.get(charIndex).toString().matches("[À-ÿ]")) {
                            String tmp = Normalizer.normalize(String.valueOf(word.get(charIndex)), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
                            word.set(charIndex, tmp.charAt(0));
                        }
                    }
                }
            }
        }
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void deletePunctuations(List<Sentence> text, float occurrence) {
        if (occurrence != 1) {
            Random rand = new Random();  // Initialisation d'un nombre Random
            for (Sentence sentence : text) {
                /* On créer un nombre aléatoire entre 0 et 1 */
                if (rand.nextFloat() < occurrence) {
                    sentence.setPunctuation(' ');  // impossible de set un caractere a NULL
                }
            }
        } else {
            for (Sentence sentence : text) {
                sentence.setPunctuation(' ');
            }
        }
    }

}