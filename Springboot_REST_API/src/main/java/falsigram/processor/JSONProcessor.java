/**
*
* This class allows to process the JSON request
*
* @author Pascal Flores
 *
 */

package falsigram.processor;

import org.json.JSONObject;
import falsigram.text.core.Text;
import falsigram.text.utils.*;
import java.time.Duration;
import java.util.Arrays;

public class JSONProcessor {

    private JSONObject request;
    private Text text;

    /**
     * @param stringRequest
     */
    public JSONProcessor(String stringRequest){
        this.request = new JSONObject(stringRequest);
        text = new Text(request.getString("text"));
    }

    /**
     *
     * Analyses the JSON request given in the object constructor
     * and calls the appropriate methods
     *
     * @return String
     */
    public String processJSONRequest() {
        JSONObject instruction;
        float occurrence;
        for (int i = 0; i < request.getJSONArray("instructions").length(); ++i) {
            instruction = request.getJSONArray("instructions").getJSONObject(i);
            occurrence = instruction.getFloat("occurrence");
            if (occurrence != 0){
                switch (instruction.getString("name").charAt(0)){
                    case 'i' :
                        switch (instruction.getString("name")){
                            case "insertLetters" :
                                Inserter.insertLetters(this.text, occurrence);
                                break;
                            case "insertSpaces" :
                                Inserter.insertSpaces(this.text, occurrence);
                                break;
                            case "insertAccents" :
                                Inserter.insertAccents(this.text, occurrence);
                                break;
                            case "insertWords" :
                                Inserter.insertWords(this.text, occurrence);
                                break;
                            case "insertWordsFromSentence":
                                Inserter.insertWordsFromSentence(this.text, occurrence);
                                break;
                            case "insertWordsFromList" :
                                Inserter.insertWordsFromList(this.text, occurrence, Arrays.asList(instruction.get("wordList").toString().split(";")));
                                break;
                            default :
                                break;
                        }
                        break;
                    case 'r' :
                        switch (instruction.getString("name")){
                            case "replaceLetters" :
                                Replacer.replaceLetters(this.text, occurrence);
                                break;
                            case "replaceAccents" :
                                Replacer.replaceAccents(this.text, occurrence);
                                break;
                            case "replacePunctuations" :
                                Replacer.replacePunctuations(this.text, occurrence);
                                break;
                            case "replaceWords" :
                                Replacer.replaceWords(this.text, occurrence);
                                break;
                            case "replaceWordsFromSentence" :
                                Replacer.replaceWordsFromSentence(this.text, occurrence);
                                break;
                            case "replaceWordsFromList" :
                                Replacer.replaceWordsFromList(this.text, occurrence, Arrays.asList(instruction.get("wordList").toString().split(";")));
                                break;
                            case "replaceAHomophones" :
                                Replacer.replaceAHomophones(this.text, occurrence);
                                break;
                            case "replaceEtHomophones" :
                                Replacer.replaceEtHomophones(this.text, occurrence);
                                break;
                            case "replaceSaHomophones" :
                                Replacer.replaceSaHomophones(this.text, occurrence);
                                break;
                            case "replaceSeHomophones" :
                                Replacer.replaceSeHomophones(this.text, occurrence);
                                break;
                            case "replaceSaitHomophones" :
                                Replacer.replaceSaitHomophones(this.text, occurrence);
                                break;
                            case "replaceDansHomophones" :
                                Replacer.replaceDansHomophones(this.text, occurrence);
                                break;
                            case "replaceLaHomophones" :
                                Replacer.replaceLaHomophones(this.text, occurrence);
                                break;
                            case "replaceMaisHomophones" :
                                Replacer.replaceMaisHomophones(this.text, occurrence);
                                break;
                            case "replaceOnHomophones" :
                                Replacer.replaceOnHomophones(this.text, occurrence);
                                break;
                            case "replaceOuHomophones" :
                                Replacer.replaceOuHomophones(this.text, occurrence);
                                break;
                            case "replacePeuHomophones" :
                                Replacer.replacePeuHomophones(this.text, occurrence);
                                break;
                            default :
                                break;
                        }
                        break;
                    case 'd' :
                        switch (instruction.getString("name")) {
                            case "deleteLetters" :
                                Deleter.deleteLetters(this.text, occurrence);
                                break;
                            case "deleteSpaces" :
                                Deleter.deleteSpaces(this.text, occurrence);
                                break;
                            case "deleteAccents" :
                                Deleter.deleteAccents(this.text, occurrence);
                                break;
                            case "deletePunctuations" :
                                Deleter.deletePunctuations(this.text, occurrence);
                            default :
                                break;
                        }
                        break;
                    case 's' :
                        switch (instruction.getString("name")) {
                            case "swapLettersInWord" :
                                Swapper.swapLettersInWord(this.text, occurrence);
                                break;
                            case "swapContiguousLettersInWord" :
                                Swapper.swapContiguousLettersInWord(this.text, occurrence);
                                break;
                            case "swapWordsInSentence" :
                                Swapper.swapWordsInSentence(this.text, occurrence);
                                break;
                            case "swapContiguousWordsInSentence" :
                                Swapper.swapContiguousWordsInSentence(this.text, occurrence);
                            default :
                                break;
                        }
                        break;
                }
            }
        }
        return this.text.toString();
    }
}
