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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import static falsigram.text.utils.Data.*;



public class Inserter {


    private static char insertAccent(char c) {
        switch (c) {
            case 'e':
                switch (randomGenerator.nextInt(4)) {
                    case 0:
                        return 'é';
                    case 1:
                        return 'è';
                    case 2:
                        return 'ê';
                    case 3:
                        return 'ë';
                }
                break;
            case 'a':
                switch (randomGenerator.nextInt(2)){
                    case 0:
                        return 'à';
                    case 1:
                        return 'â';
                }
                break;
            case 'i':
                switch (randomGenerator.nextInt(2)){
                    case 0:
                        return 'î';
                    case 1:
                        return 'ï';
                }
                break;
            case 'o':
                return 'ô';
            case 'u':
                switch (randomGenerator.nextInt(2)){
                    case 0:
                        return 'ù';
                    case 1:
                        return 'û';
                }
                break;
            case 'c':
                return 'ç';
            case 'E':
                switch (randomGenerator.nextInt(4)) {
                    case 0:
                        return 'É';
                    case 1:
                        return 'È';
                    case 2:
                        return 'Ê';
                    case 3:
                        return 'Ë';
                }
                break;
            case 'A':
                switch (randomGenerator.nextInt(2)){
                    case 0:
                        return 'À';
                    case 1:
                        return 'Â';
                }
                break;
            case 'I':
                switch (randomGenerator.nextInt(2)){
                    case 0:
                        return 'Î';
                    case 1:
                        return 'Ï';
                }
                break;
            case 'O':
                return 'Ô';
            case 'U':
                switch (randomGenerator.nextInt(2)){
                    case 0:
                        return  'Ù';
                    case 1:
                        return 'Û';
                }
                break;
            case 'C':
                return 'Ç';
        }
        return c;
    }


    /*    Fonctions    */
    /**
     * Default constructor
     */
    public Inserter() {
    }



    /* Public fonctions */
    /**
     * @param text Text
     * @param occurrence float
     */
    // TODO a voir si on decide d'implementer les UpperCases
    public static void insertLetters(Text text, float occurrence) {
        if (occurrence != 1) {
            for(Sentence s : text.getContent()) {
                for (int i = 0; i < s.GetWordsNumber();++i) {
                    for (int j = 0; j < s.getWordSize(i); ++j) {
                        if(randomGenerator.nextFloat() < occurrence) {
                            s.insertCharacter(i,j, Data.allLetters.get(randomGenerator.nextInt(allLetters.size())));
                        }
                    }
                }
            }
        }
        else {
            for(Sentence s : text.getContent()) {
                for (int i = 0; i < s.GetWordsNumber();++i) {
                    for (int j = 0; j < s.getWordSize(i); ++j)
                        s.insertCharacter(i,j, Data.allLetters.get(randomGenerator.nextInt(allLetters.size())));
                }
            }
        }
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void insertSpaces(Text text, float occurrence) {
        if (occurrence != 1) {
            for(Sentence s : text.getContent()) {
                for (int i = 0; i < s.GetWordsNumber();++i) {
                    for (int j = 0; j < s.getWordSize(i); ++j) {
                        if(randomGenerator.nextFloat() < occurrence) {
                            s.insertCharacter(i,j, ' ');
                        }
                    }
                }
            }
        }
        else {
            for(Sentence s : text.getContent()) {
                for (int i = 0; i < s.GetWordsNumber();++i) {
                    for (int j = 0; j < s.getWordSize(i); ++j)
                        s.insertCharacter(i,j, ' ');
                }
            }
        }
    }


    /**
     * @param text Text
     * @param occurrence float
     */
    // TODO a voir si on decide d'implementer les UpperCases
    public static void insertAccents(Text text, float occurrence) {
        if (occurrence != 1) {
            for (Sentence sentence : text.getContent()) {
                for (int i = 0; i < sentence.GetWordsNumber(); ++i) {
                    for (int j = 0; j < sentence.getWordSize(i); ++j) {
                        if (nonAccentedLetters.indexOf(sentence.getContent().charAt(sentence.getWordsIndexes().get(i) + j)) != -1) {
                            if (randomGenerator.nextFloat() < occurrence) {
                                sentence.getContent().setCharAt(sentence.getWordsIndexes().get(i) + j, insertAccent(sentence.getContent().charAt(sentence.getWordsIndexes().get(i) + j)));
                            }
                        }

                    }
                }
            }
        } else {
            for (Sentence sentence : text.getContent()) {
                for (int i = 0; i < sentence.GetWordsNumber(); ++i) {
                    for (int j = 0; j < sentence.getWordSize(i); ++j) {
                        if (nonAccentedLetters.indexOf(sentence.getContent().charAt(sentence.getWordsIndexes().get(i) + j)) != -1) {
                            sentence.getContent().setCharAt(sentence.getWordsIndexes().get(i) + j, insertAccent(sentence.getContent().charAt(sentence.getWordsIndexes().get(i) + j)));
                        }
                    }
                }
            }
        }
    }

    public static void insertWords(Text text, float occurrence) {
        if (occurrence != 1) {
            for (Sentence s : text.getContent()) {
                for (int i = 0; i < s.GetWordsNumber(); ++i) {
                    if (randomGenerator.nextFloat() < occurrence) {
                        s.insertWord(i, dict.get(randomGenerator.nextInt(dict.size())));
                        ++i;
                    }
                }
            }
        }
        else {
            for (Sentence s : text.getContent()) {
                for (int i = 0; i < s.GetWordsNumber(); ++i) {
                    s.insertWord(i, dict.get(randomGenerator.nextInt(dict.size())));
                    ++i;
                }
            }
        }
    }

    public static void insertWordsFromSentence(Text text, float occurrence) {}

    public static void insertWordsFromList(Text text, float occurrence) {}

}