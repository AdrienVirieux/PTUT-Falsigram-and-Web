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



public class Deleter {


    /* Private methods */

    /**
     * Removes the accented character at position index in the array word
     */
    private static char deleteAccent(char c) {
        switch (c) {
            case 'é': case 'è': case 'ê': case 'ë':
                return 'e';
            case 'à': case 'â':
                return 'a';
            case 'î': case 'ï':
                return 'i';
            case 'ù': case 'û':
                return 'u';
            case 'ô':
                return 'o';
            case 'ç':
                return 'c';
            case 'É': case 'È': case 'Ê': case 'Ë':
                return 'E';
            case 'À': case 'Â':
                return 'A';
            case 'Î': case 'Ï':
                return 'I';
            case 'Ù': case 'Ü':
                return 'U';
            case 'Ô':
                return 'O';
            case 'Ç':
                return 'C';
        }
        return ' ';
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
                if (randomGenerator.nextFloat() < occurrence) {
                    text.getContent().get(0).removeCharacter(i, -1);
                }
            }
            for (int i = 1; i < text.getContent().size(); ++i) {
                for (int j = 1; j < text.getContent().get(i).GetWordsNumber(); ++j) {
                    if (randomGenerator.nextFloat() < occurrence) {
                        text.getContent().get(i).removeCharacter(j, -1);
                    }
                }
            }
        } else {
            int lastSpace;
            for (Sentence sentence : text.getContent()) {
                lastSpace = 0;
                lastSpace = sentence.getContent().indexOf(" ");
                while (lastSpace != -1) {
                    sentence.getContent().deleteCharAt(lastSpace);
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
                for (int i = 0; i < sentence.GetWordsNumber();++i) {
                    for (int j=0; j < sentence.getWordSize(i); ++j) {
                        if (allAccents.indexOf(sentence.getContent().charAt(sentence.getWordsIndexes().get(i)+j)) != -1) {
                            if(randomGenerator.nextFloat() < occurrence) {
                                sentence.getContent().setCharAt(sentence.getWordsIndexes().get(i)+j, deleteAccent(sentence.getContent().charAt(sentence.getWordsIndexes().get(i)+j)) );
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
                            sentence.getContent().setCharAt(sentence.getWordsIndexes().get(i)+j, deleteAccent(sentence.getContent().charAt(sentence.getWordsIndexes().get(i)+j)) );
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
    public static void deletePunctuations(Text text, float occurrence) {
        if (occurrence != 1) {
            for (Sentence sentence : text.getContent()) {
                /* On créer un nombre aléatoire entre 0 et 1 */
                if (randomGenerator.nextFloat() < occurrence) {
                    sentence.getContent().deleteCharAt(sentence.getContent().length()-1);
                }
            }
        } else {
            for (Sentence sentence : text.getContent()) {
                sentence.getContent().deleteCharAt(sentence.getContent().length()-1);
            }
        }
    }
}