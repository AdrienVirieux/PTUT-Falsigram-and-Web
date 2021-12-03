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


}