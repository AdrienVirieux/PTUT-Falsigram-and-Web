/**
 *
 *  @author Quentin Meyer
 *
 */

package falsigram.text.utils;

import falsigram.text.core.Sentence;
import falsigram.text.core.Text;
import static falsigram.text.utils.Data.*;
import java.util.*;

import static java.util.Collections.swap;


public class Swapper {

    /**
     * @param text
     * @param occurrence
     * @return Text
     */
    public static void swapLettersInWord(Text text, float occurrence) {
        if (occurrence != 1) {   //On vérifie que la occurrence ne bloque pas la suite de la fonction
            for(Sentence s : text.getContent()) {
                for (int i = 0; i < s.GetWordsNumber()-1;++i) {
                    for(int j = 0; j < s.getWordSize(i)-1; ++j) {
                        if(randomGenerator.nextFloat() < occurrence) {
                            s.swapCharacters(i, j, j+randomGenerator.nextInt(s.getWordSize(i)-j));
                        }

                    }
                }
                for (int j = 0; j < s.getWordSize(s.GetWordsNumber()-1)-1; ++j) {
                    if(randomGenerator.nextFloat() < occurrence) {
                        s.swapCharacters(s.GetWordsNumber()-1, j, j+randomGenerator.nextInt(s.getWordSize(s.GetWordsNumber()-1)-j));
                    }

                }
            }
        }
        else
        {
            for(Sentence s : text.getContent()) {
                for (int i = 0; i < s.GetWordsNumber()-1;++i) {
                    for(int j = 0; j < s.getWordSize(i)-1; ++j) {
                        s.swapCharacters(i, j, j+randomGenerator.nextInt(s.getWordSize(i)-j));
                    }
                }
                for (int j = 0; j < s.getWordSize(s.GetWordsNumber()-1)-1; ++j) {
                    s.swapCharacters(s.GetWordsNumber()-1, j, j+randomGenerator.nextInt(s.getWordSize(s.GetWordsNumber()-1)-j));
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
            for(Sentence s : text.getContent()) {
                for (int i = 0; i < s.GetWordsNumber()-1;++i) {
                    for(int j = 0; j < s.getWordSize(i)-1; ++j) {
                        if(randomGenerator.nextFloat() < occurrence) {
                            s.swapCharacters(i, j, j+1);
                        }

                    }
                }
                for (int j = 0; j < s.getWordSize(s.GetWordsNumber()-1)-1; ++j) {
                    if(randomGenerator.nextFloat() < occurrence) {
                        s.swapCharacters(s.GetWordsNumber()-1, j, j+1);
                    }

                }
            }
        }
        else
        {
            for(Sentence s : text.getContent()) {
                for (int i = 0; i < s.GetWordsNumber()-1;++i) {
                    for(int j = 0; j < s.getWordSize(i)-1; ++j) {
                        s.swapCharacters(i, j, j+1);
                    }
                }
                for (int j = 0; j < s.getWordSize(s.GetWordsNumber()-1)-1; ++j) {
                    s.swapCharacters(s.GetWordsNumber()-1, j, j+1);
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
            for(Sentence s : text.getContent()) {
                for (int i = 0; i < s.GetWordsNumber()-1;++i) {
                    if (randomGenerator.nextFloat() < occurrence) {
                        s.swapWords(i, i+randomGenerator.nextInt(s.GetWordsNumber()-1-i));
                    }
                }
            }
        } else {
            for(Sentence s : text.getContent()) {
                for (int i = 0; i < s.GetWordsNumber()-1;++i) {
                    s.swapWords(i, i+randomGenerator.nextInt(s.GetWordsNumber()-1-i));
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
            for(Sentence s : text.getContent()) {
                for (int i = 0; i < s.GetWordsNumber()-1;++i) {
                    if (randomGenerator.nextFloat() < occurrence) {
                        s.swapWords(i, i + 1);
                    }
                }
            }
        } else {
            for(Sentence s : text.getContent()) {
                for (int i = 0; i < s.GetWordsNumber()-1;++i) {
                    s.swapWords(i, i+1);
                }
            }
        }
    }
}