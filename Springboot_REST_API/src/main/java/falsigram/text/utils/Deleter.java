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
import static falsigram.text.utils.Data.*;

import java.util.*;


public class Deleter {


    /* Private methods */

    /**
     * Removes the accented character at position index in the array word
     * @param word the list of characters that will be modified
     * @param index the index of the character to modify
     */
    private static void deleteAccent(List<Character> word, int index) {
        switch (word.get(index)) {
            case 'é': case 'è': case 'ê': case 'ë':
                word.set(index, 'e');
                break;
            case 'à': case 'â':
                word.set(index, 'a');
                break;
            case 'î': case 'ï':
                word.set(index, 'i');
                break;
            case 'ù': case 'û':
                word.set(index,'u');
                break;
            case 'ô':
                word.set(index, 'o');
                break;
            case 'ç':
                word.set(index, 'c');
                break;
            case 'É': case 'È': case 'Ê': case 'Ë':
                word.set(index, 'E');
                break;
            case 'À': case 'Â':
                word.set(index, 'A');
                break;
            case 'Î': case 'Ï':
                word.set(index, 'I');
                break;
            case 'Ù': case 'Ü':
                word.set(index,'U');
                break;
            case 'Ô':
                word.set(index, 'O');
                break;
            case 'Ç':
                word.set(index, 'C');
                break;
        }
    }


    /* Public methods */
    /**
     * @param text Text
     * @param occurrence float
     */


    public static void deleteLetters(Text text, float occurrence) {
        if (occurrence != 1) {
            for (Sentence sentence : text.getContent()) {
                for (List<Character> word : sentence.getContent()) {
                    Iterator<Character> iterator = word.iterator();
                    while (iterator.hasNext()) {
                        iterator.next();
                        if (randomGenerator.nextFloat() < occurrence) {
                            iterator.remove();
                        }
                    }
                }
            }
        }
        else {
            for (Sentence s : text.getContent()) {
                s.getContent().clear();
            }
        }
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void deleteSpaces(Text text, float occurrence) {
        if (occurrence != 1) {

            for (Sentence sentence : text.getContent()) {
                for (int wordIndex = 0; wordIndex < sentence.getContent().size()-1;) {
                    if (randomGenerator.nextFloat() < occurrence) {
                        sentence.getContent().get(wordIndex).addAll(sentence.getContent().get(wordIndex+1));
                        sentence.getContent().remove(wordIndex+1);
                        continue;
                    }
                    ++wordIndex;
                }
            }
        } else {
            for (Sentence sentence : text.getContent()) {
                for (int wordIndex = 0; wordIndex < sentence.getContent().size()-1;) {
                    sentence.getContent().get(wordIndex).addAll(sentence.getContent().get(wordIndex+1));
                    sentence.getContent().remove(wordIndex+1);
                }
            }
        }
    }



    /**
     * @param text Text
     * @param occurrence float
     */
    public static void deleteAccents(Text text, float occurrence) {
        if (occurrence != 1) {
            for (Sentence sentence : text.getContent()) {
                for (List<Character> word : sentence.getContent()) {
                    for (int charIndex = 0; charIndex < word.size(); ++charIndex) {
                        if (allAccents.indexOf(word.get(charIndex)) != -1) {
                            if (randomGenerator.nextFloat() < occurrence) {
                                deleteAccent(word, charIndex);
                            }
                        }
                    }
                }
            }
        } else {
            for (Sentence sentence : text.getContent()) {
                for (List<Character> word : sentence.getContent()) {
                    for (int charIndex = 0; charIndex < word.size(); ++charIndex) {
                        if (allAccents.indexOf(word.get(charIndex)) != -1) {
                            deleteAccent(word, charIndex);
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
            for (Sentence sentence : text) {
                /* On créer un nombre aléatoire entre 0 et 1 */
                if (randomGenerator.nextFloat() < occurrence) {
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