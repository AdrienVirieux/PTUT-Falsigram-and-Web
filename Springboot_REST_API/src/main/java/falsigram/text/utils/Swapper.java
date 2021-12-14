/**
 *
 *  @author Quentin Meyer
 *
 */

package falsigram.text.utils;

import falsigram.text.core.Sentence;
import falsigram.text.core.Text;

import java.util.*;

import static java.util.Collections.swap;


public class Swapper {

    private static final Random randomGenerator = new Random();

    /**
     * @param text
     * @param occurrence
     * @return Text
     */
    public static void swapLettersInWord(Text text, float occurrence) {
        if (occurrence != 1) {           //On vérifie que la occurrence ne bloque pas la suite de la fonction
            for (Sentence sentence : text.getContent()) {
                for (List<Character> word : sentence.getContent()) {
                    for (int i = 0; i < word.size()-1; ++i) {
                        if (randomGenerator.nextFloat() < occurrence) {
                            swap(word, i, randomGenerator.nextInt(word.size() - 1));
                        }
                    }
                }
            }
        }
        else
        {
            for (Sentence sentence : text.getContent()) {
                for (List<Character> word : sentence.getContent()) {
                    for (int i = 0; i < word.size()-1; ++i) {
                        swap(word, i, randomGenerator.nextInt(word.size() - 1));
                    }
                }
            }
        }
    }


    /**
     * @param text
     * @param occurrence
     * @return Text
     */
    public static void swapContiguousLettersInWord(Text text, float occurrence) {
        if (occurrence != 1) {   //On vérifie que la occurrence ne bloque pas la suite de la fonction
            for (Sentence sentence : text.getContent()) {
                for (List<Character> word : sentence.getContent()) {
                    for (int i = 0; i < word.size() - 1; ++i) {
                        if (randomGenerator.nextFloat() < occurrence) {
                            Collections.swap(word, i, i + 1);
                        }
                    }
                }
            }
        }
        else
        {
            for (Sentence sentence : text.getContent()) {
                for (List<Character> word : sentence.getContent()) {
                    for (int i = 0; i < word.size() - 1; ++i) {
                        swap(word, i, i + 1);
                    }
                }
            }
        }
    }


    /**
     * @param text
     * @param occurrence
     * @return Text
     */
    public static void swapWordsInSentence(Text text, float occurrence) {
        if (occurrence != 1) {           //On vérifie que la occurrence ne bloque pas la suite de la fonction
            for (Sentence sentence : text.getContent()) {
                for (int i = 0; i < sentence.getContent().size() -1; ++i) {
                    if (randomGenerator.nextFloat() < occurrence) {
                        swap(sentence.getContent(), i, randomGenerator.nextInt(sentence.getContent().size() - 1));
                    }
                }
            }
        }
        else
        {
            for (Sentence sentence : text.getContent()) {
                for (int i = 0; i < sentence.getContent().size()-1; ++i) {
                    swap(sentence.getContent(), i, randomGenerator.nextInt(sentence.getContent().size() - 1));
                }
            }
        }
    }


    /**
     * @param text
     * @param occurrence
     * @return Text
     */
    public static void swapContiguousWordsInSentence(Text text, float occurrence) {
        if (occurrence != 1) {           //On vérifie que la occurrence ne bloque pas la suite de la fonction
            for (Sentence sentence : text.getContent()) {
                for (int i = 0; i < sentence.getContent().size() -1; ++i) {
                    if (randomGenerator.nextFloat() < occurrence) {
                        swap(sentence.getContent(), i, i+1);
                    }
                }
            }
        } else {
            for (Sentence sentence : text.getContent()) {
                for (int i = 0; i < sentence.getContent().size() -1; ++i) {
                    swap(sentence.getContent(), i, i+1);
                }
            }
        }
    }
}