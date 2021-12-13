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


public class Replacer {
    /* Private var : Listes des homophones */
    private static final List<String> homophoneA = Arrays.asList("a", "à", "ah", "as", "ha");
    private static final List<String> homophoneEt = Arrays.asList("est", "ai", "es", "et");
    private static final List<String> homophoneSa = Arrays.asList("sa", "ça", "çà");
    private static final List<String> homophoneSe = Arrays.asList("se", "ce", "ceux");
    private static final List<String> homophoneSait = Arrays.asList("sait", "ses", "ces", "c'est", "s'est", "sais");
    private static final List<String> homophoneDans = Arrays.asList("dans", "d'en");
    private static final List<String> homophoneLa = Arrays.asList("la", "là", "l'a", "l'as");
    private static final List<String> homophoneMais = Arrays.asList("mais", "mets", "met", "mes", "m'es", "m'est");
    private static final List<String> homophoneOn = Arrays.asList("on", "ont");
    private static final List<String> homophoneOu = Arrays.asList("ou", "où");
    private static final List<String> homophonePeu = Arrays.asList("peu", "peut", "peux");
    /* Liste de la ponctuation */
    private static final List<Character> listPunctuation = Arrays.asList('.', '!', '?', ':');


    /*    Fonctions    */
    /**
     * Default constructor
     */
    public Replacer() {
    }

    /* Private fonctions */
    /**
     * @param text Text
     * @param occurrence float
     * @param listeHomophone List<String>
     */
    private static void replaceHomophone(List<Sentence> text, float occurrence, List<String> listeHomophone) {
        Random rand = new Random();  // Initialisation d'un nombre Random

        if (occurrence != 1) {
            for (Sentence sentence : text) {
                for (List<Character> word : sentence.getContent()) {
                    /* Construction d'un String avec le contenu de word */
                    StringBuilder stringWord = new StringBuilder();
                    word.forEach(stringWord::append);

                    /* On check si la String est égale à une de nos valeurs */
                    for (int i = 0; i < listeHomophone.size(); ++i) {
                        if (stringWord.toString().toLowerCase().equals(listeHomophone.get(i))) {
                            /* On créer un nombre float aléatoire entre 0 et 1 */
                            if (rand.nextFloat() < occurrence) {
                                word.clear();
                                int randIndexExclu = (i + rand.nextInt(listeHomophone.size()-1) + 1) % listeHomophone.size();
                                for (Character c : listeHomophone.get(randIndexExclu).toCharArray())
                                    word.add(c);
                            }
                            break;
                        }
                    }
                }
            }
        } else {
            for (Sentence sentence : text) {
                for (List<Character> word : sentence.getContent()) {
                    /* Construction d'un String avec le contenu de word */
                    StringBuilder stringWord = new StringBuilder();
                    word.forEach(stringWord::append);

                    /* On check si la String est égale à une de nos valeurs */
                    for (int i = 0; i < listeHomophone.size(); ++i) {
                        if (stringWord.toString().toLowerCase().equals(listeHomophone.get(i))) {
                            word.clear();
                            int randIndexExclu = (i + rand.nextInt(listeHomophone.size()-1) + 1) % listeHomophone.size();
                            for (Character c : listeHomophone.get(randIndexExclu).toCharArray())
                                word.add(c);
                            break;
                        }
                    }
                }
            }
        }
    }

    /* Public fonctions */
    /**
     * @param text Text
     * @param occurrence float
     */
    public static void replaceLetters(List<Sentence> text, float occurrence) {
        Random rand = new Random();  // Initialisation d'un nombre Random

        if (occurrence != 1) {
            for (Sentence sentence : text) {
                for (List<Character> word : sentence.getContent()) {
                    for (int charIndex = 0; charIndex < word.size(); ++charIndex) {
                        /* On créer un nombre aléatoire entre 0 et 1 */
                        if (rand.nextFloat() < occurrence) {
                            /* Choix aléatoire d'un caractère */
                            int randCarac = rand.nextInt(26);
                            char newCarac = (char) (randCarac + 'a');

                            if (Character.isUpperCase(word.get(charIndex)))
                                word.add(charIndex + 1, Character.toUpperCase(newCarac));
                            else
                                word.add(charIndex + 1, newCarac);

                            word.remove(charIndex);
                        }
                    }
                }
            }
        } else {
            for (Sentence sentence : text) {
                for (List<Character> word : sentence.getContent()) {
                    for (int charIndex = 0; charIndex < word.size(); ++charIndex) {
                        /* Choix aléatoire d'un caractère */
                        int randCarac = rand.nextInt(26);
                        char newCarac = (char) (randCarac + 'a');

                        if (Character.isUpperCase(word.get(charIndex)))
                            word.add(charIndex + 1, Character.toUpperCase(newCarac));
                        else
                            word.add(charIndex + 1, newCarac);

                        word.remove(charIndex);
                    }
                }
            }
        }
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void replaceAccents(List<Sentence> text, float occurrence) {
        // TODO implement here
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void replacePunctuations(List<Sentence> text, float occurrence) {
        Random rand = new Random();  // Initialisation d'un nombre Random

        if (occurrence != 1) {
            for (Sentence sentence : text) {
                /* On créer un nombre aléatoire entre 0 et 1 */
                if (rand.nextFloat() < occurrence) {
                    for (int i = 0; i < listPunctuation.size(); ++i) {
                        if (sentence.getPunctuation() == listPunctuation.get(i)) {
                            int index = (i + rand.nextInt(listPunctuation.size()-1)) % listPunctuation.size();
                            sentence.setPunctuation(listPunctuation.get(index));
                        }
                    }
                }
            }
        } else {
            for (Sentence sentence : text) {
                for (int i = 0; i < listPunctuation.size(); ++i) {
                    if (sentence.getPunctuation() == listPunctuation.get(i)) {
                        int index = (i + rand.nextInt(listPunctuation.size()-1) + 1) % listPunctuation.size();
                        sentence.setPunctuation(listPunctuation.get(index));
                        break;
                    }
                }
            }
        }
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void replaceAHomophones(List<Sentence> text, float occurrence) {
        replaceHomophone(text, occurrence, homophoneA);
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void replaceEtHomophones(List<Sentence> text, float occurrence) {
        replaceHomophone(text, occurrence, homophoneEt);
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void replaceSaHomophones(List<Sentence> text, float occurrence) {
        replaceHomophone(text, occurrence, homophoneSa);
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void replaceSeHomophones(List<Sentence> text, float occurrence) {
        replaceHomophone(text, occurrence, homophoneSe);
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void replaceSaitHomophones(List<Sentence> text, float occurrence) {
        replaceHomophone(text, occurrence, homophoneSait);
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void replaceDansHomophones(List<Sentence> text, float occurrence) {
        replaceHomophone(text, occurrence, homophoneDans);
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void replaceLaHomophones(List<Sentence> text, float occurrence) {
        replaceHomophone(text, occurrence, homophoneLa);
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void replaceMaisHomophones(List<Sentence> text, float occurrence) {
        replaceHomophone(text, occurrence, homophoneMais);
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void replaceOnHomophones(List<Sentence> text, float occurrence) {
        replaceHomophone(text, occurrence, homophoneOn);
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void replaceOuHomophones(List<Sentence> text, float occurrence) {
        replaceHomophone(text, occurrence, homophoneOu);
    }

    /**
     * @param text Text
     * @param occurrence float
     */
    public static void replacePeuHomophones(List<Sentence> text, float occurrence) {
        replaceHomophone(text, occurrence, homophonePeu);
    }

}