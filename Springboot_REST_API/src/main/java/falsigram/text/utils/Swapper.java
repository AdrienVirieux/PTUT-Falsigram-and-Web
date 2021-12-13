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

    /**
     * Default constructor
     */
    public Swapper() {
    }


    /**
     * @param Text t
     * @param float proba
     * @return Text
     */
    public Text swapCharsInWord(Text t, float proba) {
        Random r = new Random();    //On crée un nombre aléatoire entre 0 et 1
        if (proba != 1) {           //On vérifie que la proba ne bloque pas la suite de la fonction
            for (Sentence s : t) {
                for (List<Character> word : s) {
                    for (int i = 0; i < word.size(); ++i) {
                        if (proba > r.nextFloat()) {
                            swap(word, i, r.nextInt(word.size() - 1));
                        }
                    }
                }
            }
            return t;
        }
        else
        {
            for (Sentence s : t) {
                for (List<Character> word : s) {
                    for (int i = 0; i < word.size(); ++i) {
                        swap(word, i, r.nextInt(word.size() - 1));
                    }
                }
            }
            return t;
        }
    }


    /**
     * @param Text t
     * @param float proba
     * @return Text
     */
    public Text swapContiguousLettersInWord(Text t, float proba) {
        if (proba != 1) {   //On vérifie que la proba ne bloque pas la suite de la fonction
            Random r = new Random();    //On crée un nombre aléatoire entre 0 et 1
            for (Sentence s : t) {
                for (List<Character> word : s) {
                    for (int i = 0; i < word.size() - 1; ++i) {
                        if (proba > r.nextFloat()) {
                            swap(word, i, i + 1);
                        }
                    }
                }
            }
            return t;
        }
        else
        {
            for (Sentence s : t) {
                for (List<Character> word : s) {
                    for (int i = 0; i < word.size() - 1; ++i) {
                        swap(word, i, i + 1);
                    }
                }
            }
            return t;
        }
    }


    /**
     * @param Text t
     * @param float proba
     * @return Text
     */
    public Text swapWordsInSentence(Text t, float proba) {
        Random r = new Random();    //On crée un nombre aléatoire entre 0 et 1
        if (proba != 1) {           //On vérifie que la proba ne bloque pas la suite de la fonction
            for (Sentence s : t) {
                for (int i = 0; i < s.getContent().size(); ++i) {
                    if (proba > r.nextFloat()) {
                        List<List<Character>> temp = s.getContent();
                        swap(temp, i, r.nextInt(temp.size() - 1));
                        s.setContent(temp);
                    }
                }
            }
            return t;
        }
        else
        {
            for (Sentence s : t) {
                for (int i = 0; i < s.getContent().size(); ++i) {
                    List<List<Character>> temp = s.getContent();
                    swap(temp, i, r.nextInt(temp.size() - 1));
                    s.setContent(temp);
                }
            }
            return t;
        }
    }


    /**
     * @param Text t
     * @param float proba
     * @return Text
     */
    public Text swapContiguousWordsInSentence(Text t, float proba) {
        Random r = new Random();    //On crée un nombre aléatoire entre 0 et 1
        if (proba != 1) {           //On vérifie que la proba ne bloque pas la suite de la fonction
            for (Sentence s : t) {
                for (int i = 0; i < s.getContent().size(); ++i) {
                    if (proba > r.nextFloat()) {
                        List<List<Character>> temp = s.getContent();
                        swap(temp, i, i  + 1);
                        s.setContent(temp);
                    }
                }
            }
            return t;
        } else {
            for (Sentence s : t) {
                for (int i = 0; i < s.getContent().size(); ++i) {
                    List<List<Character>> temp = s.getContent();
                    swap(temp, i, i  + 1);
                    s.setContent(temp);
                }
            }
            return t;
        }
    }
}