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

    /**
     * Default constructor
     */
    public Deleter() {
    }

/*
    private static List<Character> deleteChar(List<Character> l, int index) {
        l.remove(index);
        return l;
    }
*/

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void deleteLetters(List<Sentence> text, float occurrence) {
        List<Character> tmp = new ArrayList<>();

        if (occurrence != 1) {
            for (Sentence sentence : text) {
                for (List<Character> word : sentence.getContent()) {
                    for (int charIndex = 0; charIndex < word.size(); ++charIndex) {
                        /* On créer un nombre aléatoire entre 0 et 1 */
                        float randNbr = new Random().nextFloat();
                        if (randNbr > occurrence)
                            tmp.add(word.get(charIndex));
                    }
                    word.clear();
                    word.addAll(tmp);
                    tmp.clear();
                }
            }
        } else {
            for (Sentence sentence : text) {
                for (List<Character> word : sentence.getContent())
                    word.clear();
            }
        }
    }


    /**
     * @param text Text
     * @param occurrence float
     */
    // TODO appeler la fonction
    public static String deleteLettersString(List<Sentence> text, float occurrence) {
        StringBuilder texteEntier = new StringBuilder(text.toString());

        if (occurrence != 1) {
            for (int charIndex = 0; charIndex < texteEntier.length();) {
                /* On créer un nombre aléatoire entre 0 et 1 */
                float randNbr = new Random().nextFloat();
                if (Character.isLetter(texteEntier.charAt(charIndex)) && randNbr < occurrence) {
                    texteEntier.deleteCharAt(texteEntier.charAt(charIndex));
                    continue;
                }
                ++charIndex;
            }
        } else {
            for (int charIndex = 0; charIndex < texteEntier.length(); ++charIndex)
                texteEntier.deleteCharAt(texteEntier.charAt(charIndex));
        }

        return texteEntier.toString();
    }


    /**
     * @param text Text
     * @param occurrence float
     */
    public static void deleteSpaces(List<Sentence> text, float occurrence) {
        if (occurrence != 1) {
            for (Sentence sentence : text) {
                for (int wordIndex = 1; wordIndex < sentence.getContent().size();) {
                    /* On créer un nombre aléatoire entre 0 et 1 */
                    float randNbr = new Random().nextFloat();
                    if (randNbr < occurrence) {
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
        // TODO ne fonctionne pas
        if (occurrence != 1) {
            for (Sentence sentence : text) {
                for (List<Character> word : sentence.getContent()) {
                    for (Character c : word) {
                        /* On créer un nombre aléatoire entre 0 et 1 */
                        float randNbr = new Random().nextFloat();
                        if (occurrence > randNbr) {
                            String tmp = Normalizer.normalize(String.valueOf(c), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
                            c = tmp.charAt(0);
                        }
                    }
                }
            }
        } else {
            for (Sentence sentence : text) {
                for (List<Character> word : sentence.getContent()) {
                    for (Character c : word) {
                        String tmp = Normalizer.normalize(String.valueOf(c), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
                        c = tmp.charAt(0);
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
            for (int sentenceIndex = 1; sentenceIndex < text.size();) {
                /* On créer un nombre aléatoire entre 0 et 1 */
                float randNbr = new Random().nextFloat();
                if (occurrence > randNbr) {
                    for (List<Character> word : text.get(sentenceIndex).getContent())
                        text.get(sentenceIndex - 1).getContent().add(word);
                    text.remove(sentenceIndex);
                    continue;
                }
                ++sentenceIndex;
            }
        } else {
            for (int sentenceIndex = 1; sentenceIndex < text.size(); ) {
                for (List<Character> word : text.get(sentenceIndex).getContent())
                    text.get(0).getContent().add(word);
                text.remove(sentenceIndex);
            }
        }
    }

}