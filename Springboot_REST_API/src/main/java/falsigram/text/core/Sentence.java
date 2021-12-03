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
    public Sentence(String sentence) {
        this.content = new ArrayList<List<Character>>();
        List<Character> tmp = new ArrayList<Character>();
        for (int i = 0; i < sentence.length()-1; ++i){
            if (sentence.charAt(i) != ' '){
                tmp.add(sentence.charAt(i));
            }
            else {
                this.content.add(tmp);
                tmp = new ArrayList<Character>();
            }
        }
        this.content.add(tmp);
        System.out.println(this.content.get(this.content.size()-1));
        this.punctuation = sentence.charAt(sentence.length()-1);
    }

    public char getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(char punctuation) {
        this.punctuation = punctuation;
    }

    public List<List<Character>> getContent() {
        return content;
    }

    public void setContent(List<List<Character>> content) {
        this.content = content;
    }

    @Override
    public String toString() {

        StringBuilder sb  = new StringBuilder();
        for (int i = 0; i < this.content.size(); ++i){
            for (int j = 0; j < this.content.get(i).size(); ++j){
                sb.append(this.content.get(i).get(j));
            }
            if (i != this.content.size()-1){
                sb.append(' ');
            }
        }
        sb.append(punctuation);
        return sb.toString();
    }
}