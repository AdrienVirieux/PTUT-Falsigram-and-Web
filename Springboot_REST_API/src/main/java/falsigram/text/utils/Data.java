package falsigram.text.utils;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Data {

    /* Liste des homophones */
    static final List<String> homophoneA = Arrays.asList("a", "à", "ah", "as", "ha");
    static final List<String> homophoneEt = Arrays.asList("est", "ai", "es", "et");
    static final List<String> homophoneSa = Arrays.asList("sa", "ça", "çà");
    static final List<String> homophoneSe = Arrays.asList("se", "ce", "ceux");
    static final List<String> homophoneSait = Arrays.asList("sait", "ses", "ces", "c'est", "s'est", "sais");
    static final List<String> homophoneDans = Arrays.asList("dans", "d'en");
    static final List<String> homophoneLa = Arrays.asList("la", "là", "l'a", "l'as");
    static final List<String> homophoneMais = Arrays.asList("mais", "mets", "met", "mes", "m'est");
    static final List<String> homophoneOn = Arrays.asList("on", "ont");
    static final List<String> homophoneOu = Arrays.asList("ou", "où");
    static final List<String> homophonePeu = Arrays.asList("peu", "peut", "peux");

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

    static List<String> dict = null;

    static {
        try {
            dict = Files.readAllLines(Path.of("src/main/resources/dict.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
