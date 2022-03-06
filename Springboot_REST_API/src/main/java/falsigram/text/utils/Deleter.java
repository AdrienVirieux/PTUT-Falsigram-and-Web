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
            for(Sentence s : text.getContent()) {
                for (int i = 0; i < s.GetWordsNumber();++i) {
                    for (int j=0; j < s.getWordSize(i); ++j) {
                        if(randomGenerator.nextFloat() < occurrence) {
                            s.removeCharacter(i, j);
                            --j;
                        }
                    }
                }
            }
        }
        else {
            for(Sentence s : text.getContent()) {
                s.getContent().setLength(0);
            }
        }
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void deleteSpaces(Text text, float occurrence) {
        if (occurrence != 1) {
            for (int i = 1; i < text.getContent().get(0).GetWordsNumber(); ++i) {
                if(randomGenerator.nextFloat() < occurrence) {
                    text.getContent().get(0).removeCharacter(i, -1);
                }
            }
            for (int i = 1; i < text.getContent().size(); ++i) {
                for (int j = 1; j < text.getContent().get(0).GetWordsNumber(); ++j) {
                    if (randomGenerator.nextFloat() < occurrence) {
                        text.getContent().get(0).removeCharacter(j, -1);
                    }
                }
            }
        } else {
            for (Sentence sentence : text.getContent()) {
                int lastSpace = sentence.getContent().indexOf(" ");
                while (lastSpace != -1) {
                    sentence.removeCharacter(0, lastSpace);
                    lastSpace = sentence.getContent().indexOf(" ");
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