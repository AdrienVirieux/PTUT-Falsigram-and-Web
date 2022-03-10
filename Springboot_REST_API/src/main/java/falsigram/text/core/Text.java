package falsigram.text.core;


import java.util.ArrayList;
import java.util.List;

public class Text {

    private List<Sentence> content = new ArrayList<Sentence>();
    /**
     * Default constructor
     */
    public Text(String s) {
        String[] sentences = Split(s, new char[]{'.', '!', '?', ':'});
        for (String sentence: sentences) {
            this.content.add(new Sentence(sentence));
        }
    }

    public static String[] Split(final String line, final char[] delimiters)
    {
        CharSequence[] temp = new CharSequence[(line.length() / 2) + 1];
        int wordCount = 0;
        int i = 0;
        int j = findMin(new int[]{line.indexOf(delimiters[0], 0), line.indexOf(delimiters[1], 0), line.indexOf(delimiters[2], 0), line.indexOf(delimiters[3], 0)}); // first substring

        while (j >= 0)
        {
            temp[wordCount++] = line.substring(i, j+1);
            i = j + 1;
            j = findMin(new int[]{line.indexOf(delimiters[0], i), line.indexOf(delimiters[1], i), line.indexOf(delimiters[2], i), line.indexOf(delimiters[3], i)}); // rest of substrings
        }

        //temp[wordCount++] = line.substring(i); // last substring

        String[] result = new String[wordCount];
        System.arraycopy(temp, 0, result, 0, wordCount);

        return result;
    }

    public List<Sentence> getContent() {
        return this.content;
    }

  private static int findMin(int[] integers) {
        int min = integers[0];
        for(int i = 1; i < integers.length; ++i) {
            if (min > integers[i] && integers[i] > 0) min = integers[i];
        }
        return min;
    }
  
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < this.content.size(); ++i)
        {
            sb.append(this.content.get(i).getContent());
        }
        return sb.toString();
    }
}
