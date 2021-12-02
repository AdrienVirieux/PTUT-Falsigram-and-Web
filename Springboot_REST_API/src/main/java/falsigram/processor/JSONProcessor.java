package falsigram.processor;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONProcessor {

    private JSONObject request;
    private Text text;

    public JSONProcessor(String stringRequest){
        this.request = new JSONObject(stringRequest);
        text = new Text(request.getString("text"));
    }

    public String processJSONRequest() {
        JSONObject instruction;
        for (int i = 0; i < request.getJSONArray("instructions").length(); ++i) {
            instruction = request.getJSONArray("instructions").getJSONObject(i);


        }
        return this.text.toString();
    }

}
