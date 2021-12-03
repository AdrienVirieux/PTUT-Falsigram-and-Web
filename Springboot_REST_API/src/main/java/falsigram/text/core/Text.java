/**
 *
 *
 *
 * @author Adrien Virieux
 *
 */

package falsigram.text.core;


import falsigram.text.utils.Replacer;

import java.util.List;

public class Text {

    private List<Sentence> content;

    /**
     * Default constructor
     */
    public Text(String content) {
        for (String s : content.split("[.!?:]")){
            this.content.add(new Sentence(s));
        }
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
}