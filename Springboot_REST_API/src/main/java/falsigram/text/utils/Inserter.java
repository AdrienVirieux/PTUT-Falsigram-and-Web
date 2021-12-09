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
    /* Private var : Listes des nears keys */
    private static final List<Character> keysNearA = Arrays.asList('q', 'z');
    private static final List<Character> keysNearZ = Arrays.asList('a', 's', 'e');
    private static final List<Character> keysNearE = Arrays.asList('z', 'd', 'r');
    private static final List<Character> keysNearR = Arrays.asList('e', 'f', 't');
    private static final List<Character> keysNearT = Arrays.asList('r', 'g', 'y');
    private static final List<Character> keysNearY = Arrays.asList('t', 'h', 'u');
    private static final List<Character> keysNearU = Arrays.asList('y', 'j', 'i');
    private static final List<Character> keysNearI = Arrays.asList('u', 'k', 'o');
    private static final List<Character> keysNearO = Arrays.asList('i', 'l', 'p');
    private static final List<Character> keysNearP = Arrays.asList('o', 'm');
    private static final List<Character> keysNearQ = Arrays.asList('a', 's', 'w');
    private static final List<Character> keysNearS = Arrays.asList('q', 'z', 'd', 'x');
    private static final List<Character> keysNearD = Arrays.asList('s', 'e', 'f', 'c');
    private static final List<Character> keysNearF = Arrays.asList('d', 'r', 'g', 'v');
    private static final List<Character> keysNearG = Arrays.asList('f', 't', 'h', 'b');
    private static final List<Character> keysNearH = Arrays.asList('g', 'y', 'j', 'n');
    private static final List<Character> keysNearJ = Arrays.asList('h', 'u', 'k');
    private static final List<Character> keysNearK = Arrays.asList('j', 'i', 'l');
    private static final List<Character> keysNearL = Arrays.asList('k', 'o', 'm');
    private static final List<Character> keysNearM = Arrays.asList('l', 'p');
    private static final List<Character> keysNearW = Arrays.asList('q', 'x');
    private static final List<Character> keysNearX = Arrays.asList('w', 's', 'c');
    private static final List<Character> keysNearC = Arrays.asList('x', 'd', 'v');
    private static final List<Character> keysNearV = Arrays.asList('c', 'f', 'b');
    private static final List<Character> keysNearB = Arrays.asList('v', 'g', 'n');
    private static final List<Character> keysNearN = Arrays.asList('b', 'h');

    /*    Fonctions    */
    /**
     * Default constructor
     */
    public Inserter() {
    }

    /* Private function */
    /**
     * @param word List<Character>
     * @param charIndex int
     * @return Character
     */
    private static Character chooseNearKey(List<Character> word, int charIndex) {
        switch (Character.toLowerCase(word.get(charIndex))) {
            case 'a':
            case 'à':
                return keysNearA.get(new Random().nextInt(keysNearA.size()));
            case 'z':
                return keysNearZ.get(new Random().nextInt(keysNearZ.size()));
            case 'e':
            case 'é':
            case 'è':
            case 'ê':
            case 'ë':
                return keysNearE.get(new Random().nextInt(keysNearE.size()));
            case 'r':
                return keysNearR.get(new Random().nextInt(keysNearR.size()));
            case 't':
                return keysNearT.get(new Random().nextInt(keysNearT.size()));
            case 'y':
                return keysNearY.get(new Random().nextInt(keysNearY.size()));
            case 'u':
            case 'ù':
                return keysNearU.get(new Random().nextInt(keysNearU.size()));
            case 'i':
            case 'î':
            case 'ï':
                return keysNearI.get(new Random().nextInt(keysNearI.size()));
            case 'o':
                return keysNearO.get(new Random().nextInt(keysNearO.size()));
            case 'p':
                return keysNearP.get(new Random().nextInt(keysNearP.size()));
            case 'q':
                return keysNearQ.get(new Random().nextInt(keysNearQ.size()));
            case 's':
                return keysNearS.get(new Random().nextInt(keysNearS.size()));
            case 'd':
                return keysNearD.get(new Random().nextInt(keysNearD.size()));
            case 'f':
                return keysNearF.get(new Random().nextInt(keysNearF.size()));
            case 'g':
                return keysNearG.get(new Random().nextInt(keysNearG.size()));
            case 'h':
                return keysNearH.get(new Random().nextInt(keysNearH.size()));
            case 'j':
                return keysNearJ.get(new Random().nextInt(keysNearJ.size()));
            case 'k':
                return keysNearK.get(new Random().nextInt(keysNearK.size()));
            case 'l':
                return keysNearL.get(new Random().nextInt(keysNearL.size()));
            case 'm':
                return keysNearM.get(new Random().nextInt(keysNearM.size()));
            case 'w':
                return keysNearW.get(new Random().nextInt(keysNearW.size()));
            case 'x':
                return keysNearX.get(new Random().nextInt(keysNearX.size()));
            case 'c':
                return keysNearC.get(new Random().nextInt(keysNearC.size()));
            case 'v':
                return keysNearV.get(new Random().nextInt(keysNearV.size()));
            case 'b':
                return keysNearB.get(new Random().nextInt(keysNearB.size()));
            case 'n':
                return keysNearN.get(new Random().nextInt(keysNearN.size()));
            default:
                return word.get(charIndex);
        }
    }

    /* Public fonctions */
    /**
     * @param text Text
     * @param occurrence float
     */
    public static void insertLetters(List<Sentence> text, float occurrence) {
        if (occurrence != 1) {
            Random rand = new Random();  // Initialisation d'un nombre Random
            for (Sentence sentence : text) {
                for (List<Character> word : sentence.getContent()) {
                    for (int charIndex = 0; charIndex < word.size(); ++charIndex) {
                        /* On créer un nombre aléatoire entre 0 et 1 */
                        if (rand.nextFloat() < occurrence) {
                            /* Choix aléatoire d'un caractère */
                            int randCarac = new Random().nextInt(26);
                            char newCarac = (char) (randCarac + 'a');

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
                        int randCarac = new Random().nextInt(26);
                        char newCarac = (char) (randCarac + 'a');

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
            Random rand = new Random();  // Initialisation d'un nombre Random
            for (Sentence sentence : text) {
                for (int wordIndex = 0; wordIndex < sentence.getContent().size(); ++wordIndex) {
                    for (int charIndex = 0; charIndex < sentence.getContent().get(wordIndex).size() - 1; ++charIndex) {
                        /* On créer un nombre aléatoire entre 0 et 1 */
                        if (rand.nextFloat() < occurrence) {
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
     * @param text Text
     * @param occurrence float
     */
    public static void insertNearKeyboardKeyLetters(List<Sentence> text, float occurrence) {
        if (occurrence != 1) {
            Random rand = new Random();  // Initialisation d'un nombre Random
            for (Sentence sentence : text) {
                for (List<Character> word : sentence.getContent()) {
                    for (int charIndex = 0; charIndex < word.size(); ++charIndex) {
                        /* On créer un nombre aléatoire entre 0 et 1 */
                        if (rand.nextFloat() < occurrence) {
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