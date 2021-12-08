/**
 *
 *
 *
 * @author Adrien Virieux
 *
 */

package falsigram.text.utils;

import falsigram.text.core.Sentence;

import java.util.*;


public class Inserter {

    /**
     * Default constructor
     */
    public Inserter() {
    }

/*
    private static List<Character> insertChar(List<Character> l, int index, char ch) {
        l.add(index, ch);
        return l;
    }
*/

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void insertLetters(List<Sentence> text, float occurrence) {
        if (occurrence != 1) {
            for (Sentence sentence : text) {
                for (List<Character> word : sentence.getContent()) {
                    for (int charIndex = 0; charIndex < word.size(); ++charIndex) {
                        /* On créer un nombre aléatoire entre 0 et 1 */
                        float randNbr = new Random().nextFloat();
                        if (randNbr < occurrence) {
                            /* Choix aléatoire d'un caractère */
                            int rand = new Random().nextInt(26);
                            char newCarac = (char) (rand + 'a');

                            word.add(charIndex + 1, newCarac);
                            ++charIndex;
                        }
                    }
                }
            }
        } else {
            for (Sentence sentence : text) {
                for (List<Character> word : sentence.getContent()) {
                    for (int charIndex = 0; charIndex < word.size(); charIndex += 2) {
                        /* Choix aléatoire d'un caractère */
                        int rand = new Random().nextInt(26);
                        char newCarac = (char) (rand + 'a');

                        word.add(charIndex + 1, newCarac);
                    }
                }
            }
        }
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void insertSpaces(List<Sentence> text, float occurrence) {
        List<Character> tmp;

        if (occurrence != 1) {
            for (Sentence sentence : text) {
                for (int wordIndex = 0; wordIndex < sentence.getContent().size(); ++wordIndex) {
                    for (int charIndex = 0; charIndex < sentence.getContent().get(wordIndex).size() - 1; ++charIndex) {
                        /* On créer un nombre aléatoire entre 0 et 1 */
                        float randNbr = new Random().nextFloat();
                        if (randNbr < occurrence) {
                            tmp = new ArrayList<>();
                            for (int nextCharIndex = charIndex + 1; nextCharIndex < sentence.getContent().get(wordIndex).size();) {
                                tmp.add(sentence.getContent().get(wordIndex).get(nextCharIndex));
                                sentence.getContent().get(wordIndex).remove(nextCharIndex);
                            }
                            sentence.getContent().add(wordIndex + 1, tmp);
                            ++wordIndex;
                        }
                    }
                }
            }
        } else {
            for (Sentence sentence : text) {
                for (int wordIndex = 0; wordIndex < sentence.getContent().size();) {
                    for (int charIndex = 0; charIndex < sentence.getContent().get(wordIndex).size();) {
                        tmp = new ArrayList<>();
                        tmp.add(sentence.getContent().get(wordIndex).get(charIndex));
                        sentence.getContent().get(wordIndex).remove(charIndex);
                        sentence.getContent().add(wordIndex, tmp);
                        ++wordIndex;
                    }
                    sentence.getContent().remove(wordIndex);
                }
            }
        }
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void insertAccents(List<Sentence> text, float occurrence) {
        // TODO implement here
    }


    /**
     * @param word List<Character>
     * @param charIndex int
     * @return Character
     */
    private static Character chooseNearKey(List<Character> word, int charIndex) {
        switch (Character.toLowerCase(word.get(charIndex))) {
            case 'a':
            case 'à':
                List<Character> keysNearA = Arrays.asList('q', 'z');
                return keysNearA.get(new Random().nextInt(keysNearA.size()));
            case 'z':
                List<Character> keysNearZ = Arrays.asList('a', 's', 'e');
                return keysNearZ.get(new Random().nextInt(keysNearZ.size()));
            case 'e':
            case 'é':
            case 'è':
            case 'ê':
                List<Character> keysNearE = Arrays.asList('z', 'd', 'r');
                return keysNearE.get(new Random().nextInt(keysNearE.size()));
            case 'r':
                List<Character> keysNearR = Arrays.asList('e', 'f', 't');
                return keysNearR.get(new Random().nextInt(keysNearR.size()));
            case 't':
                List<Character> keysNearT = Arrays.asList('r', 'g', 'y');
                return keysNearT.get(new Random().nextInt(keysNearT.size()));
            case 'y':
                List<Character> keysNearY = Arrays.asList('t', 'h', 'u');
                return keysNearY.get(new Random().nextInt(keysNearY.size()));
            case 'u':
                List<Character> keysNearU = Arrays.asList('y', 'j', 'i');
                return keysNearU.get(new Random().nextInt(keysNearU.size()));
            case 'i':
                List<Character> keysNearI = Arrays.asList('u', 'k', 'o');
                return keysNearI.get(new Random().nextInt(keysNearI.size()));
            case 'o':
                List<Character> keysNearO = Arrays.asList('i', 'l', 'p');
                return keysNearO.get(new Random().nextInt(keysNearO.size()));
            case 'p':
                List<Character> keysNearP = Arrays.asList('o', 'm');
                return keysNearP.get(new Random().nextInt(keysNearP.size()));
            case 'q':
                List<Character> keysNearQ = Arrays.asList('a', 's', 'w');
                return keysNearQ.get(new Random().nextInt(keysNearQ.size()));
            case 's':
                List<Character> keysNearS = Arrays.asList('q', 'z', 'd', 'x');
                return keysNearS.get(new Random().nextInt(keysNearS.size()));
            case 'd':
                List<Character> keysNearD = Arrays.asList('s', 'e', 'f', 'c');
                return keysNearD.get(new Random().nextInt(keysNearD.size()));
            case 'f':
                List<Character> keysNearF = Arrays.asList('d', 'r', 'g', 'v');
                return keysNearF.get(new Random().nextInt(keysNearF.size()));
            case 'g':
                List<Character> keysNearG = Arrays.asList('f', 't', 'h', 'b');
                return keysNearG.get(new Random().nextInt(keysNearG.size()));
            case 'h':
                List<Character> keysNearH = Arrays.asList('g', 'y', 'j', 'n');
                return keysNearH.get(new Random().nextInt(keysNearH.size()));
            case 'j':
                List<Character> keysNearJ = Arrays.asList('h', 'u', 'k');
                return keysNearJ.get(new Random().nextInt(keysNearJ.size()));
            case 'k':
                List<Character> keysNearK = Arrays.asList('j', 'i', 'l');
                return keysNearK.get(new Random().nextInt(keysNearK.size()));
            case 'l':
                List<Character> keysNearL = Arrays.asList('k', 'o', 'm');
                return keysNearL.get(new Random().nextInt(keysNearL.size()));
            case 'm':
                List<Character> keysNearM = Arrays.asList('l', 'p');
                return keysNearM.get(new Random().nextInt(keysNearM.size()));
            case 'w':
                List<Character> keysNearW = Arrays.asList('q', 'x');
                return keysNearW.get(new Random().nextInt(keysNearW.size()));
            case 'x':
                List<Character> keysNearX = Arrays.asList('w', 's', 'c');
                return keysNearX.get(new Random().nextInt(keysNearX.size()));
            case 'c':
                List<Character> keysNearC = Arrays.asList('x', 'd', 'v');
                return keysNearC.get(new Random().nextInt(keysNearC.size()));
            case 'v':
                List<Character> keysNearV = Arrays.asList('c', 'f', 'b');
                return keysNearV.get(new Random().nextInt(keysNearV.size()));
            case 'b':
                List<Character> keysNearB = Arrays.asList('v', 'g', 'n');
                return keysNearB.get(new Random().nextInt(keysNearB.size()));
            case 'n':
                List<Character> keysNearN = Arrays.asList('b', 'h');
                return keysNearN.get(new Random().nextInt(keysNearN.size()));
        }
        return word.get(charIndex);
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void insertNearKeyboardKeyLetters(List<Sentence> text, float occurrence) {
        if (occurrence != 1) {
            for (Sentence sentence : text) {
                for (List<Character> word : sentence.getContent()) {
                    for (int charIndex = 0; charIndex < word.size(); ++charIndex) {
                        /* On créer un nombre aléatoire entre 0 et 1 */
                        float randNbr = new Random().nextFloat();
                        if (randNbr < occurrence) {
                            // TODO a voir si on decide d'implementer les UpperCases
                            if (Character.isUpperCase(word.get(charIndex)))
                                word.add(charIndex + 1, Character.toUpperCase(chooseNearKey(word, charIndex)));
                            else
                                word.add(charIndex + 1, chooseNearKey(word, charIndex));
                            ++charIndex;
                        }
                    }
                }
            }
        } else {
            for (Sentence sentence : text) {
                for (List<Character> word : sentence.getContent()) {
                    for (int charIndex = 0; charIndex < word.size(); charIndex += 2) {
                        // TODO a voir si on decide d'implementer les UpperCases
                        if (Character.isUpperCase(word.get(charIndex)))
                            word.add(charIndex + 1, Character.toUpperCase(chooseNearKey(word, charIndex)));
                        else
                            word.add(charIndex + 1, chooseNearKey(word, charIndex));
                    }
                }
            }
        }
    }

}