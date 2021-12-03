/**
 *
 *
 *
 * @author Adrien Virieux
 *
 */

package falsigram.text.core;

import java.util.*;


public class Sentence {
    private char punctuation;
    private List<List<Character>> content;

    /**
     * Default constructor
     */
    public Sentence(String content) {
        List<Character> tmp = new ArrayList<Character>();
        for (int i = 0; i < content.length()-1; ++i){
            if (content.charAt(i) != ' '){
                tmp.add(content.charAt(i));
            }
            else {
                this.content.add(tmp);
                tmp.clear();
            }
        }
        this.punctuation = content.charAt(content.length()-1);
    }
}