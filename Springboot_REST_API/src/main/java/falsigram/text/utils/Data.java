package falsigram.text.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Data {

    /* Liste des homophones */
    static final List<List<Character>> homophoneA = Arrays.asList(
            Arrays.asList('a'),
            Arrays.asList('à'),
            Arrays.asList('a', 'h'),
            Arrays.asList('a', 's'),
            Arrays.asList('h', 'a'));
    static final List<List<Character>> homophoneEt = Arrays.asList(
            Arrays.asList('e', 's', 't'),
            Arrays.asList('a', 'i'),
            Arrays.asList('e', 's'),
            Arrays.asList('e', 't'));
    static final List<List<Character>> homophoneSa = Arrays.asList(
            Arrays.asList('s', 'a'),
            Arrays.asList('ç', 'a'),
            Arrays.asList('ç', 'à'));
    static final List<List<Character>> homophoneSe = Arrays.asList(
            Arrays.asList('s', 'e'),
            Arrays.asList('c', 'e'),
            Arrays.asList('c', 'e', 'u', 'x'));
    static final List<List<Character>> homophoneSait = Arrays.asList(
            Arrays.asList('s', 'a', 'i', 't'),
            Arrays.asList('s', 'e', 's'),
            Arrays.asList('c', 'e', 's'),
            Arrays.asList('c', '\'', 'e', 's', 't'),
            Arrays.asList('s', '\'', 'e', 's', 't'),
            Arrays.asList('s', 'a', 'i', 's'));
    static final List<List<Character>> homophoneDans = Arrays.asList(
            Arrays.asList('d', 'a', 'n', 's'),
            Arrays.asList('d', '\'', 'e', 'n'));
    static final List<List<Character>> homophoneLa = Arrays.asList(
            Arrays.asList('l', 'a'),
            Arrays.asList('l', 'à'),
            Arrays.asList('l', '\'', 'a'),
            Arrays.asList('l', '\'', 'a', 's'));
    static final List<List<Character>> homophoneMais = Arrays.asList(
            Arrays.asList('m', 'a', 'i', 's'),
            Arrays.asList('m', 'e', 't', 's'),
            Arrays.asList('m', 'e', 't'),
            Arrays.asList('m', 'e', 's'),
            Arrays.asList('m', '\'', 'e', 's'),
            Arrays.asList('m', '\'', 'e', 's', 't'));
    static final List<List<Character>> homophoneOn = Arrays.asList(
            Arrays.asList('o', 'n'),
            Arrays.asList('o', 'n', 't'));
    static final List<List<Character>> homophoneOu = Arrays.asList(
            Arrays.asList('o', 'u'),
            Arrays.asList('o', 'ù'));
    static final List<List<Character>> homophonePeu = Arrays.asList(
            Arrays.asList('p', 'e', 'u'),
            Arrays.asList('p', 'e', 'u', 't'),
            Arrays.asList('p', 'e', 'u', 'x'));

    /* Liste de la ponctuation */
    static final String punctuations = ".!?:";

    /* générateur d'aléatoire commun */
    static final Random randomGenerator = new Random();

    /* Listes de caractères */
    static final List<Character> allAccents = Arrays.asList('é','è','à','ù','â','ê','î','ô','û','ë','ï','ç','É','È','À','Ù','Â','Ê','Î','Ô','Û','Ë','Ï','Ç');
    static final List<Character> lCAccents = Arrays.asList('é','è','à','ù','â','ê','î','ô','û','ë','ï','ç');
    static final List<Character> uCAccents = Arrays.asList('É','È','À','Ù','Â','Ê','Î','Ô','Û','Ë','Ï','Ç');
    static final List<Character> allLetters = Arrays.asList('a','z','e','r','t','y','u','i','o','p','q','s','d','f','g','h','j','k','l','m','w','x','c','v','b','n',
                                                    'A','Z','E','R','T','Y','U','I','O','P','Q','S','D','F','G','H','J','K','L','M','W','X','C','V','B','N');
    static final List<Character> lCLettersAndAccents = Arrays.asList('a','z','e','r','t','y','u','i','o','p','q','s','d','f','g','h','j','k','l','m','w','x','c','v','b','n','é','è','à','ù','â','ê','î','ô','û','ë','ï','ç');
    static final List<Character> uCLettersAndAccents = Arrays.asList('A','Z','E','R','T','Y','U','I','O','P','Q','S','D','F','G','H','J','K','L','M','W','X','C','V','B','N','É','È','À','Ù','Â','Ê','Î','Ô','Û','Ë','Ï','Ç');
    static final List<Character> nonAccentedLetters = Arrays.asList('a','e','i','o','u','c','A','E','I','O','U','C');
    static final List<Character> eLCAccents = Arrays.asList('é', 'è', 'ê', 'ë');
    static final List<Character> eUCAccents = Arrays.asList('É', 'È', 'Ê', 'Ë');
    static final List<Character> aLCAccents = Arrays.asList('à', 'â');
    static final List<Character> aUCAccents = Arrays.asList('À', 'Â');
    static final List<Character> iLCAccents = Arrays.asList('î', 'ï');
    static final List<Character> iUCAccents = Arrays.asList('Î', 'Ï');
    static final List<Character> uLCAccents = Arrays.asList('ù', 'û');
    static final List<Character> uUCAccents = Arrays.asList('Ù', 'Û');

}
