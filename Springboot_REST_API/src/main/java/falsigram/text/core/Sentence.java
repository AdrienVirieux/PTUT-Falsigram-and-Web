package falsigram.text.core;


import java.util.ArrayList;

public class Sentence {

    //private members
    private StringBuilder content;
    private ArrayList<Integer> wordsIndexes = new ArrayList<Integer>();

    //constructor
    public Sentence(String s) {
        this.content = new StringBuilder(s);
        calculateIndexes();
    }

    /*
        Getters / Setters
    */
    public String getWord(int index) {
        if (index == this.wordsIndexes.size()-1){
            return this.content.substring(this.wordsIndexes.get(index), this.content.length());
        }
        else {
            return this.content.substring(this.wordsIndexes.get(index), this.wordsIndexes.get(index+1)-1);
        }

    }

    public int getWordSize(int index) {
        if (index == this.wordsIndexes.size()-1){
            return this.content.length()-1-this.wordsIndexes.get(index);
        }
        else {
            return this.wordsIndexes.get(index+1)-this.wordsIndexes.get(index)-1;
        }
    }

    public int GetWordsNumber() {
        return this.wordsIndexes.size();
    }

    public StringBuilder getContent() {
        return this.content;
    }

    /*
        Utility Methods
     */

    private void calculateIndexes() {
        this.wordsIndexes.clear();
        int lastSpaceIndex = 0;
        if (this.content.charAt(0) != ' ') {
            this.wordsIndexes.add(0);
        }
        else this.wordsIndexes.add(1);
        do {
            this.wordsIndexes.add(lastSpaceIndex = this.content.indexOf(" ", lastSpaceIndex+1)+1);
        }
        while (lastSpaceIndex != 0);
        this.wordsIndexes.remove(this.wordsIndexes.size()-1);
    }


    /**
     * <h1>InsertWord</h1>
     * <p>Inserts the word in the sentence at the specified index</p>
     * <strong>/!\</strong> all indexes start at zero
     * @param wordIndex
     * @param word
     * @return void
     * @author Pascal Flores
     */
    public void insertWord(int wordIndex, String word) {

        /*
         * We check if the word to insert must be inserted at the end of the Sentence, to avoid out of bond errors
         */
        if(wordIndex == this.wordsIndexes.size()-1) {
            //Insertion of the word at the index of the last character of the word
            this.content.append(" ").append(word);
            this.content.append(this.content.charAt(this.content.length()-1-word.length()));
            this.content.deleteCharAt(this.content.charAt(this.content.length()-1-word.length()));
        }
        else {
            //Insertion of the word at the index of the last character of the word
            this.content.insert(this.wordsIndexes.get(wordIndex+1)-1, " "+word);
        }

        calculateIndexes();
    }

    /**
     * <h1>InsertCharacter</h1>
     * <p>Inserts the character in the specified word at the specified index</p>
     * <strong>/!\</strong> all indexes start at zero
     * @param wordIndex
     * @param characterIndex
     * @param character
     * @return void
     * @author Pascal Flores
     */
    public void insertCharacter(int wordIndex, int characterIndex, char character) {
        /*
         * Insertion of the new character at the index :
         * index of the first character of the word (this.wordIndex.get(wordIndex))
         * +
         * the index of the character in the word (characterIndex)
         */

        this.content.insert(this.wordsIndexes.get(wordIndex)+characterIndex, character);

        /*
         * We calculate the new indexes of the words using LengthDifference by adding :
         * 1
         * to
         * the index of the word
         * So now word indexes matches again with the Sentence
         */
        for(int i=wordIndex; i < this.wordsIndexes.size(); ++i) {
            wordsIndexes.set(i, wordsIndexes.get(i) + 1);
        }

    }

    /**
     * <h1>removeWord</h1>
     * <p>Deletes the word in the sentence at the specified index</p>
     * <strong>/!\</strong> all indexes start at zero
     * @param wordIndex
     * @return void
     * @author Pascal Flores
     */
    public void removeWord(int wordIndex) {

        /*
         * We check if the word to delete is the last or not, to avoid out of bond errors
         */
        if(wordIndex == this.wordsIndexes.size()-1) {
            // Deletion of the word
            this.content.delete(this.wordsIndexes.get(wordIndex)-1, this.content.length());
        }
        else {
            // Deletion of the word
            this.content.delete(this.wordsIndexes.get(wordIndex)-1, this.wordsIndexes.get(wordIndex+1));
        }

        calculateIndexes();
    }

    /**
     * <h1>removeCharacter</h1>
     * <p>Deletes the character in the specified word at the specified index</p>
     * <strong>/!\</strong> all indexes start at zero
     * @param wordIndex
     * @param characterIndex
     * @return void
     * @author Pascal Flores
     */
    public void removeCharacter(int wordIndex, int characterIndex) {
        /*
         * Deletion of the Character at the index :
         * index of the first character of the specified word (wordIndex)
         * +
         * index of the Character in the word (characterIndex)
         */
        if(this.wordsIndexes.get(wordIndex)+ characterIndex != this.content.length()-1) {
            this.content.deleteCharAt(this.wordsIndexes.get(wordIndex)+characterIndex);
            calculateIndexes();
        }

    }

    /**
     * <h1>SwapWords</h1>
     * <p>Swaps the positions of the words at the specified indexes</p>
     * <strong>/!\</strong> all indexes start at zero
     * <strong>/!\</strong> firstWordIndex <strong>must</strong> be smaller than secondWordIndex
     * @param firstWordIndex
     * @param secondWordIndex
     * @return void
     * @author Pascal Flores
     */
    public void swapWords(int firstWordIndex, int secondWordIndex) {

        /*
         * We are creating a temporary variable which equals to a String corresponding to :
         * the word at the second specified index (secondWordIndex)
         */


        /*
         * We check if the word to modify is the las or not, to avoid out of bond errors
         */
        if (secondWordIndex == this.wordsIndexes.size()-1) {
            char punctuation = this.content.charAt(this.content.length()-1);
            this.content.deleteCharAt(this.content.length()-1);
            String tempWord = getWord(secondWordIndex);
            // Replacement of the second word by the first one
            this.content.replace(this.wordsIndexes.get(secondWordIndex), this.content.length(), getWord(firstWordIndex));
            calculateIndexes();
            this.content.replace(this.wordsIndexes.get(firstWordIndex), this.wordsIndexes.get(firstWordIndex+1)-1, tempWord);
            this.content.append(punctuation);
        }
        else {
            // Replacement of the second word by the first one
            String tempWord = getWord(secondWordIndex);
            this.content.replace(this.wordsIndexes.get(secondWordIndex), this.wordsIndexes.get(secondWordIndex+1)-1, getWord(firstWordIndex));
            calculateIndexes();
            this.content.replace(this.wordsIndexes.get(firstWordIndex), this.wordsIndexes.get(firstWordIndex+1)-1, tempWord);
        }
        calculateIndexes();
    }

    /**
     * <h1>swapCharacters</h1>
     * <p>Swaps the positions of the characters in the specified word at the specified indexes</p>
     * <strong>/!\</strong> all indexes start at zero
     * @param wordIndex
     * @param firstCharaterIndex
     * @param secondCharacterIndex
     * @return void
     * @author Pascal Flores
     */
    public void swapCharacters(int wordIndex, int firstCharaterIndex, int secondCharacterIndex) {
        /*
         * We are creating a temporary variable which equals to the character at the index :
         * first character of the word (this.wordIndexes.get(wordIndex))
         * +
         * the index of the second character to swap (secondCharacterIndex)
         */
        char tempChar = this.content.charAt(this.wordsIndexes.get(wordIndex)+secondCharacterIndex);
        // Replacement of the second character by the first one
        replaceCharacter(wordIndex, secondCharacterIndex, this.content.charAt(this.wordsIndexes.get(wordIndex)+firstCharaterIndex));
        // Replacement of the first character by tempchar
        replaceCharacter(wordIndex, firstCharaterIndex, tempChar);
    }

    /**
     * <h1>replaceWord</h1>
     * <p>Replaces the word in the sentence at the specified index by the specified word</p>
     * <strong>/!\</strong> all indexes start at zero
     * @param wordIndex
     * @param word
     * @return void
     * @author Pascal Flores
     */
    public void replaceWord(int wordIndex, String word) {
        /*
         * LengthDifference is the difference between :
         * the index of the last character of the word
         * and
         * the index of the first character of the word.
         * It is used to know :
         * how much offset must be applied to the words indexes after a word / character modification
         */
        int LengthDifference;

        /*
         * We check if the word to modify is the last or not, to avoid out of bond errors
         */
        if(wordIndex == this.wordsIndexes.size()-1){
            // Calculation of LengthDifference
            LengthDifference = this.wordsIndexes.get(this.wordsIndexes.size()-1) - this.wordsIndexes.get(wordIndex);
            // Replacement of the word by the one given as parameter
            this.content.replace(this.wordsIndexes.get(wordIndex), this.content.length(), word);
        }
        else{
            // Calculation of LengthDifference
            LengthDifference = this.wordsIndexes.get(wordIndex+1)-1 - this.wordsIndexes.get(wordIndex);
            // Replacement of the word by the one given as parameter
            this.content.replace(this.wordsIndexes.get(wordIndex), this.wordsIndexes.get(wordIndex+1)-1, word);
        }

        calculateIndexes();
    }

    /**
     * <h1>replaceCharacter</h1>
     * <p>Replaces the character in the specified word at the specified index by the specified character</p>
     * <strong>/!\</strong> all indexes start at zero
     * @param wordIndex
     * @param characterIndex
     * @param character
     * @return void
     * @author Pascal Flores
     */
    public void replaceCharacter(int wordIndex, int characterIndex, char character) {

        /*
         * We replace the character at the index :
         * first character of the word (this.wordIndexes.get(wordIndex))
         * +
         * the index of the character in the word (characterIndex)
         */
        if(this.wordsIndexes.get(wordIndex)+ characterIndex != this.content.length()-1) {
            this.content.setCharAt(this.wordsIndexes.get(wordIndex)+characterIndex, character);
        }

    }


    @Override
    public String toString() {
        return this.content.toString();
    }
}
