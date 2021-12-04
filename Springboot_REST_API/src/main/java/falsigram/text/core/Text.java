/**
 *
 *
 *
 * @author Adrien Virieux
 *
 */

package falsigram.text.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Text implements Iterable<Sentence>, Iterator<Sentence> {

    private List<Sentence> content;

    /**
     * Default constructor
     */
    public Text(String content) {
        this.content = new ArrayList<Sentence>();

        for (String s : content.split("([.!?:]=;)")){
            this.content.add(new Sentence(s));
        }
    }

    public List<Sentence> getContent() {
        return content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < this.content.size(); ++i)
        {
            sb.append(this.content.get(i).toString());
            sb.append(' ');
        }
        return sb.toString();
    }


    /*
        Fonctions pour faire fonctionner un Iterator avec Text
    */
    private int currentIndex = 0;

    @Override
    public Iterator<Sentence> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < content.size();
    }

    @Override
    public Sentence next() {
        currentIndex++;
        return content.get(currentIndex - 1);
    }
}