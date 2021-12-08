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
                                Inserter.insertLetters(this.text.getContent(), occurrence);
                                break;
                            case "insertSpaces" :
                                Inserter.insertSpaces(this.text.getContent(), occurrence);
                                break;
                            case "insertAccents" :
                                Inserter.insertAccents(this.text.getContent(), occurrence);
                                break;
                            case "insertNearKeyboardKeyLetters" :
                                Inserter.insertNearKeyboardKeyLetters(this.text.getContent(), occurrence);
                                break;
                            default :
                                break;
                        }
                        break;
                    case 'r' :
                        switch (instruction.getString("name")){
                            case "replaceLetters" :
                                Replacer.replaceLetters(this.text.getContent(), occurrence);
                                break;
                            case "replaceAccents" :
                                Replacer.replaceAccents(this.text.getContent(), occurrence);
                                break;
                            case "replacePunctuations" :
                                Replacer.replacePunctuations(this.text.getContent(), occurrence);
                                break;
                            case "replaceAHomophones" :
                                Replacer.replaceAHomophones(this.text.getContent(), occurrence);
                                break;
                            case "replaceEtHomophones" :
                                Replacer.replaceEtHomophones(this.text.getContent(), occurrence);
                                break;
                            case "replaceSaHomophones" :
                                Replacer.replaceSaHomophones(this.text.getContent(), occurrence);
                                break;
                            case "replaceSeHomophones" :
                                Replacer.replaceSeHomophones(this.text.getContent(), occurrence);
                                break;
                            case "replaceSaitHomophones" :
                                Replacer.replaceSaitHomophones(this.text.getContent(), occurrence);
                                break;
                            case "replaceDansHomophones" :
                                Replacer.replaceDansHomophones(this.text.getContent(), occurrence);
                                break;
                            case "replaceLaHomophones" :
                                Replacer.replaceLaHomophones(this.text.getContent(), occurrence);
                                break;
                            case "replaceMaisHomophones" :
                                Replacer.replaceMaisHomophones(this.text.getContent(), occurrence);
                                break;
                            case "replaceOnHomophones" :
                                Replacer.replaceOnHomophones(this.text.getContent(), occurrence);
                                break;
                            case "replaceOuHomophones" :
                                Replacer.replaceOuHomophones(this.text.getContent(), occurrence);
                                break;
                            case "replacePeuHomophones" :
                                Replacer.replacePeuHomophones(this.text.getContent(), occurrence);
                                break;
                            default :
                                break;
                        }
                        break;
                    case 'd' :
                        switch (instruction.getString("name")) {
                            case "deleteLetters" :
                                Deleter.deleteLetters(this.text.getContent(), occurrence);
                                break;
                            case "deleteSpaces" :
                                Deleter.deleteSpaces(this.text.getContent(), occurrence);
                                break;
                            case "deleteAccents" :
                                Deleter.deleteAccents(this.text.getContent(), occurrence);
                                break;
                            case "deletePunctuations" :
                                Deleter.deletePunctuations(this.text.getContent(), occurrence);
                            default :
                                break;
                        }
                        break;
                    /*case 's' :
                        switch (instruction.getString("name")) {
                            case "swapCharsInWord" :
                                Swapper.swapCharsInWord(this.text.getContent(), occurrence);
                                break;
                            case "swapContiguousCharsInWord" :
                                Swapper.swapContiguousInWord(this.text.getContent(), occurrence);
                                break;
                            case "swapWordsInSentence" :
                                Swapper.swapWordsInSentence(this.text.getContent(), occurrence);
                                break;
                            case "swapContiguousWordsInSentence" :
                                Swapper.swapContiguousWordsInSentence(this.text.getContent(), occurrence);
                            default :
                                break;
                        }
                        break;*/
                }
            }
        }
        String ret = this.text.toString();
        return ret;
    }
}
