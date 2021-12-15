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


public class Replacer {
    /*    Fonctions    */

    /* Private fonctions */
    /**
     * @param text Text
     * @param occurrence float
     * @param Homophone List<String>
     */
    private static void replaceHomophone(Text text, float occurrence, List<List<Character>> Homophone) {
        int tempRandom;
        if (occurrence != 1) {
            for (Sentence sentence : text.getContent()) {
                for (int wordIndex = 0; wordIndex < sentence.getContent().size(); ++wordIndex)  {
                    if (Homophone.contains(sentence.getContent().get(wordIndex))) {
                        if (randomGenerator.nextFloat() < occurrence) {
                            do {
                                tempRandom = randomGenerator.nextInt(Homophone.size());
                            }  while (tempRandom == Homophone.indexOf(sentence.getContent().get(wordIndex)));
                            sentence.getContent().set(wordIndex,Homophone.get(randomGenerator.nextInt(Homophone.size())));
                        }
                    }
                }
            }
        } else {
            for (Sentence sentence : text.getContent()) {
                for (int wordIndex = 0; wordIndex < sentence.getContent().size(); ++wordIndex)  {
                    if (Homophone.contains(sentence.getContent().get(wordIndex))) {
                        do {
                            tempRandom = randomGenerator.nextInt(Homophone.size());
                        } while (tempRandom == Homophone.indexOf(sentence.getContent().get(wordIndex)));
                        sentence.getContent().set(wordIndex,Homophone.get(tempRandom));
                    }
                }
            }
        }
    }

    private static void replaceCharacter(List<Character> word, int charIndex, List<Character> upperCase, List<Character> lowerCase) {
        int tempRandom;
        if (upperCase.indexOf(word.get(charIndex)) != -1) {
            do {
                tempRandom = randomGenerator.nextInt(upperCase.size());
            } while (tempRandom == upperCase.indexOf(word.get(charIndex)));
            word.set(charIndex, upperCase.get(tempRandom));
        }
        else if (lowerCase.indexOf(word.get(charIndex)) != -1){
            do {
                tempRandom = randomGenerator.nextInt(lowerCase.size());
            } while (tempRandom == lowerCase.indexOf(word.get(charIndex)));
            word.set(charIndex, lowerCase.get(tempRandom));
        }
    }

    private static void determineAccentLetter(List<Character> word, int charIndex) {
        switch (word.get(charIndex)) {
            case 'é': case 'è': case 'ê': case 'ë':
            case 'É': case 'È': case 'Ê': case 'Ë':
                replaceCharacter(word, charIndex, eLCAccents, eUCAccents);
                break;
            case 'à': case 'â':
            case 'À': case 'Â':
                replaceCharacter(word, charIndex, aLCAccents, aUCAccents);
                break;
            case 'î': case 'ï':
            case 'Î': case 'Ï':
                replaceCharacter(word, charIndex, iLCAccents, iUCAccents);
                break;
            case 'ù': case 'û':
            case 'Ù': case 'Û':
                replaceCharacter(word, charIndex, uLCAccents, uUCAccents);
                break;
        }
    }
    /* Public fonctions */
    /**
     * @param text Text
     * @param occurrence float
     */

    public static void replaceLetters(Text text, float occurrence) {
        if (occurrence != 1) {
            for (Sentence sentence : text.getContent()) {
                for (List<Character> word : sentence.getContent()) {
                    for (int charIndex = 0; charIndex < word.size(); ++charIndex) {
                        /* On créer un nombre aléatoire entre 0 et 1 */
                        if (randomGenerator.nextFloat() < occurrence) {
                            replaceCharacter(word, charIndex, uCLettersAndAccents, lCLettersAndAccents);
                        }
                    }
                }
            }
        } else {
            for (Sentence sentence : text.getContent()) {
                for (List<Character> word : sentence.getContent()) {
                    for (int charIndex = 0; charIndex < word.size(); ++charIndex) {
                        replaceCharacter(word, charIndex, uCLettersAndAccents, lCLettersAndAccents);
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
                for (List<Character> word : sentence.getContent()) {
                    for (int charIndex = 0; charIndex < word.size(); ++charIndex) {
                        /* On créer un nombre aléatoire entre 0 et 1 */
                            if (allAccents.indexOf(word.get(charIndex)) != 1)
                            {
                                if (randomGenerator.nextFloat() < occurrence) {
                                    determineAccentLetter(word, charIndex);
                                }
                        }
                    }
                }
            }
        } else {
            for (Sentence sentence : text.getContent()) {
                for (List<Character> word : sentence.getContent()) {
                    for (int charIndex = 0; charIndex < word.size(); ++charIndex) {
                        if (allAccents.indexOf(word.get(charIndex)) != 1)
                        {
                            determineAccentLetter(word, charIndex);
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
    public static void replacePunctuations(Text text, float occurrence) {
        int tempRandom;
        if (occurrence != 1) {
            for (Sentence sentence : text.getContent()) {
                /* On créer un nombre aléatoire entre 0 et 1 */
                if (randomGenerator.nextFloat() < occurrence) {
                    do {
                        tempRandom = randomGenerator.nextInt(punctuations.length());
                    } while (tempRandom == punctuations.indexOf(sentence.getPunctuation()));
                    sentence.setPunctuation(punctuations.charAt(tempRandom));
                }
            }
        } else {
            for (Sentence sentence : text.getContent()) {
                do {
                    tempRandom = randomGenerator.nextInt(punctuations.length());
                } while (tempRandom == punctuations.indexOf(sentence.getPunctuation()));
                sentence.setPunctuation(punctuations.charAt(tempRandom));
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