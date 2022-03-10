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
import static java.lang.Character.isUpperCase;

import java.util.*;


public class Replacer {
    /*    Fonctions    */

    /* Private fonctions */
    /**
     * @param text Text
     * @param occurrence float
     * @param Homophone List<String>
     */
    private static void replaceHomophone(Text text, float occurrence, List<String> Homophone) {
        int homophoneIndex;
        int newHomophoneIndex;
        if (occurrence != 1) {
            for (Sentence sentence : text.getContent()) {
                for (int i = 0; i < sentence.GetWordsNumber(); ++i) {
                    if ((homophoneIndex = Homophone.indexOf(sentence.getWord(i))) != -1) {
                        if (randomGenerator.nextFloat() < occurrence) {
                            do {
                                sentence.replaceWord(i, Homophone.get(newHomophoneIndex = randomGenerator.nextInt(Homophone.size())));
                            } while (newHomophoneIndex == homophoneIndex);
                        }
                    }
                }
            }
        }
        else {
            for (Sentence sentence : text.getContent()) {
                for (int i = 0; i < sentence.GetWordsNumber(); ++i) {
                    if ((homophoneIndex = Homophone.indexOf(sentence.getWord(i))) != -1) {
                            do {
                                sentence.replaceWord(i, Homophone.get(newHomophoneIndex = randomGenerator.nextInt(Homophone.size())));
                            } while (newHomophoneIndex == homophoneIndex);
                    }
                }
            }
        }
    }


    private static char replaceAccent(char c) {
        switch (c) {
            case 'é':
                switch (randomGenerator.nextInt(3)) {
                    case 0:
                        return 'è';
                    case 1:
                        return 'ê';
                    case 2:
                        return 'ë';
                } break;
            case 'è':
                switch (randomGenerator.nextInt(3)) {
                    case 0:
                        return 'é';
                    case 1:
                        return 'ê';
                    case 2:
                        return 'ë';
                } break;
            case 'ê':
                switch (randomGenerator.nextInt(3)) {
                    case 0:
                        return 'é';
                    case 1:
                        return 'è';
                    case 2:
                        return 'ë';
                } break;
            case 'ë':
                switch (randomGenerator.nextInt(3)) {
                    case 0:
                        return 'é';
                    case 1:
                        return 'è';
                    case 2:
                        return 'ê';
                } break;

            case 'É':
                switch (randomGenerator.nextInt(3)) {
                    case 0:
                        return 'È';
                    case 1:
                        return 'Ê';
                    case 2:
                        return 'Ë';
                } break;
            case 'È':
                switch (randomGenerator.nextInt(3)) {
                    case 0:
                        return 'É';
                    case 1:
                        return 'Ê';
                    case 2:
                        return 'Ë';
                    } break;
            case 'Ê':
                switch (randomGenerator.nextInt(3)) {
                    case 0:
                        return 'É';
                    case 1:
                        return 'È';
                    case 2:
                        return 'Ë';
                } break;
            case 'Ë':
                switch (randomGenerator.nextInt(3)) {
                    case 0:
                        return 'È';
                    case 1:
                        return 'É';
                    case 2:
                        return 'Ê';
                } break;


            case 'à':
                return 'â';
            case 'â':
                return 'à';

            case 'À':
                return 'Â';
            case 'Â':
                return 'À';


            case 'î':
                return 'ï';
            case 'ï':
                return 'î';

            case 'Î':
                return 'Ï';
            case 'Ï':
                return 'Î';


            case 'ù':
                return 'û';
            case 'û':
                return 'ù';

            case 'Ù':
                return 'Û';
            case 'Û':
                return 'Ù';
        }
        return c;
    }
    /* Public fonctions */
    /**
     * @param text Text
     * @param occurrence float
     */

    public static void replaceLetters(Text text, float occurrence) {
        if (occurrence != 1) {
            for (Sentence s : text.getContent()) {
                for (int i = 0; i < s.GetWordsNumber(); ++i) {
                    for (int j = 0; j < s.getWordSize(i); ++j) {
                        if(randomGenerator.nextFloat() < occurrence) {
                            if (isUpperCase(s.getWord(i).charAt(j)))
                                s.replaceCharacter(i, j, Data.uCLettersAndAccents.get(randomGenerator.nextInt(uCLettersAndAccents.size())));
                            else
                                s.replaceCharacter(i, j, Data.lCLettersAndAccents.get(randomGenerator.nextInt(lCLettersAndAccents.size())));
                        }
                    }
                }
            }
        } else {
            for (Sentence sentence : text.getContent()) {
                for (Sentence s : text.getContent()) {
                    for (int i = 0; i < s.GetWordsNumber(); ++i) {
                        for (int j = 0; j < s.getWordSize(i); ++j) {
                            if (isUpperCase(s.getWord(i).charAt(j)))
                                s.replaceCharacter(i, j, Data.uCLettersAndAccents.get(randomGenerator.nextInt(uCLettersAndAccents.size())));
                            else
                                s.replaceCharacter(i, j, Data.lCLettersAndAccents.get(randomGenerator.nextInt(lCLettersAndAccents.size())));
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
    public static void replaceAccents(Text text, float occurrence) {
        if (occurrence != 1) {
            for (Sentence sentence : text.getContent()) {
                for (int i = 0; i < sentence.GetWordsNumber();++i) {
                    for (int j=0; j < sentence.getWordSize(i); ++j) {
                        if (allAccents.indexOf(sentence.getContent().charAt(sentence.getWordsIndexes().get(i)+j)) != -1) {
                            if(randomGenerator.nextFloat() < occurrence) {
                                sentence.getContent().setCharAt(sentence.getWordsIndexes().get(i)+j, replaceAccent(sentence.getContent().charAt(sentence.getWordsIndexes().get(i)+j)) );
                            }
                        }

                    }
                }
            }
        } else {
            for (Sentence sentence : text.getContent()) {
                for (int i = 0; i < sentence.GetWordsNumber();++i) {
                    for (int j=0; j < sentence.getWordSize(i); ++j) {
                        if (allAccents.indexOf(sentence.getContent().charAt(sentence.getWordsIndexes().get(i)+j)) != -1) {
                            sentence.getContent().setCharAt(sentence.getWordsIndexes().get(i)+j, replaceAccent(sentence.getContent().charAt(sentence.getWordsIndexes().get(i)+j)) );
                        }
                    }
                }
            }
        }
    }

    public static void replaceWords(Text text, float occurrence) {
        if (occurrence != 1) {
            for (Sentence s : text.getContent()) {
                for (int i = 0; i < s.GetWordsNumber(); ++i) {
                    if (randomGenerator.nextFloat() < occurrence) {
                        s.replaceWord(i, dict.get(randomGenerator.nextInt(dict.size())));
                    }
                }
            }
        }
        else {
            for (Sentence s : text.getContent()) {
                for (int i = 0; i < s.GetWordsNumber(); ++i) {
                    s.replaceWord(i, dict.get(randomGenerator.nextInt(dict.size())));
                }
            }
        }
    }

    public static void replaceWordsFromSentence(Text text, float occurrence) {
        if (occurrence != 1) {
            for (Sentence s : text.getContent()) {
                for (int i = 0; i < s.GetWordsNumber(); ++i) {
                    if (randomGenerator.nextFloat() < occurrence) {
                        s.replaceWord(i, s.getWord(randomGenerator.nextInt(s.GetWordsNumber())));
                    }
                }
            }
        }
        else {
            for (Sentence s : text.getContent()) {
                for (int i = 0; i < s.GetWordsNumber(); ++i) {
                    s.replaceWord(i, s.getWord(randomGenerator.nextInt(s.GetWordsNumber())));
                }
            }
        }
    }

    public static void replaceWordsFromList(Text text, float occurrence, List<String> wordList) {
        if (occurrence != 1) {
            for (Sentence s : text.getContent()) {
                for (int i = 0; i < s.GetWordsNumber(); ++i) {
                    if (randomGenerator.nextFloat() < occurrence) {
                        s.replaceWord(i, wordList.get(randomGenerator.nextInt(wordList.size())));
                    }
                }
            }
        }
        else {
            for (Sentence s : text.getContent()) {
                for (int i = 0; i < s.GetWordsNumber(); ++i) {
                    s.replaceWord(i, wordList.get(randomGenerator.nextInt(wordList.size())));
                }
            }
        }
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void replacePunctuations(Text text, float occurrence) {
        int tempRandom;
        if (occurrence != 1) {
            for (Sentence sentence : text.getContent()) {
                /* On créer un nombre aléatoire entre 0 et 1 */
                if (randomGenerator.nextFloat() < occurrence) {
                    do {
                        tempRandom = randomGenerator.nextInt(punctuations.length());
                    } while (tempRandom == punctuations.indexOf(sentence.getContent().charAt(sentence.getContent().length()-1)));
                    sentence.getContent().setCharAt(sentence.getContent().length()-1, punctuations.charAt(tempRandom));
                }
            }
        } else {
            for (Sentence sentence : text.getContent()) {
                do {
                    tempRandom = randomGenerator.nextInt(punctuations.length());
                } while (tempRandom == punctuations.indexOf(sentence.getContent().charAt(sentence.getContent().length()-1)));
                sentence.getContent().setCharAt(sentence.getContent().length()-1, punctuations.charAt(tempRandom));
            }
        }
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void replaceAHomophones(Text text, float occurrence) {
        replaceHomophone(text, occurrence, homophoneA);
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void replaceEtHomophones(Text text, float occurrence) {
        replaceHomophone(text, occurrence, homophoneEt);
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void replaceSaHomophones(Text text, float occurrence) {
        replaceHomophone(text, occurrence, homophoneSa);
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void replaceSeHomophones(Text text, float occurrence) {
        replaceHomophone(text, occurrence, homophoneSe);
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void replaceSaitHomophones(Text text, float occurrence) {
        replaceHomophone(text, occurrence, homophoneSait);
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void replaceDansHomophones(Text text, float occurrence) {
        replaceHomophone(text, occurrence, homophoneDans);
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void replaceLaHomophones(Text text, float occurrence) {
        replaceHomophone(text, occurrence, homophoneLa);
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void replaceMaisHomophones(Text text, float occurrence) {
        replaceHomophone(text, occurrence, homophoneMais);
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void replaceOnHomophones(Text text, float occurrence) {
        replaceHomophone(text, occurrence, homophoneOn);
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void replaceOuHomophones(Text text, float occurrence) {
        replaceHomophone(text, occurrence, homophoneOu);
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void replacePeuHomophones(Text text, float occurrence) {
        replaceHomophone(text, occurrence, homophonePeu);
    }

}