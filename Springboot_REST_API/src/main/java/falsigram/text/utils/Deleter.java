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
     * @return Text
     */
    public static Text deleteLetters(Text text, float occurrence) {
        int charIndex;

        for (Sentence sentence : text) {
            for (List<Character> word : sentence) {
                charIndex = 0;
                for (Character c : word) {

                    if (occurrence != 1) {
                        /* On créer un nombre aléatoire entre 0 et 1 */
                        float randNbr = new Random().nextFloat();
                        if (occurrence > randNbr) {
                            word.remove(charIndex);
                        }
                    }
                    else
                        word.remove(charIndex);
                    charIndex += 1;

                }
            }
        }

        return text;
    }


    /**
     * @param text Text
     * @param occurrence float
     * @return Text
     */
    public static Text deleteSpaces(Text text, float occurrence) {
        int wordIndex;

        for (Sentence sentence : text) {
            wordIndex = 0;
            for (List<Character> word : sentence) {
                if (word.equals(sentence.getContent().get(0))) continue;

                if (occurrence != 1) {
                    /* On créer un nombre aléatoire entre 0 et 1 */
                    float randNbr = new Random().nextFloat();
                    if (occurrence > randNbr) {
                        for (Character c : word)
                            sentence.getContent().get(wordIndex).add(c);
                        word.clear();
                    }
                }
                else {
                    for (Character c : word)
                        sentence.getContent().get(wordIndex).add(c);
                    word.clear();
                }
                wordIndex += 1;

            }
        }

        return text;
    }


    /**
     * @param text Text
     * @param occurrence float
     * @return Text
     */
    public static Text deleteAccents(Text text, float occurrence) {
        for (Sentence sentence : text) {
            for (List<Character> word : sentence) {
                for (Character c : word) {
                    // TODO faire en sorte de ne prendre que les caracteres accentués

                    if (occurrence != 1) {
                        /* On créer un nombre aléatoire entre 0 et 1 */
                        float randNbr = new Random().nextFloat();
                        if (occurrence > randNbr) {
                            String tmp = Normalizer.normalize(String.valueOf(c), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
                            c = tmp.charAt(0);
                        }
                    }
                    else {
                        String tmp = Normalizer.normalize(String.valueOf(c), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
                        c = tmp.charAt(0);
                    }

                }
            }
        }

        return text;
    }

    /**
     * @param text Text
     * @param occurrence float
     * @return Text
     */
    public static Text deletePunctuations(Text text, float occurrence) {
        int sentenceIndex = 0;

        for (Sentence sentence : text) {
            if (sentence.equals(text.getContent().get(0))) continue;

            if (occurrence != 1) {
                /* On créer un nombre aléatoire entre 0 et 1 */
                float randNbr = new Random().nextFloat();
                if (occurrence > randNbr) {
                    for (List<Character> word : sentence)
                        text.getContent().get(sentenceIndex).getContent().add(word);
                    sentence.remove();
                }
            }
            else {
                for (List<Character> word : sentence)
                    text.getContent().get(sentenceIndex).getContent().add(word);
                sentence.remove();
            }
            sentenceIndex += 1;
        }

        return text;
    }

}