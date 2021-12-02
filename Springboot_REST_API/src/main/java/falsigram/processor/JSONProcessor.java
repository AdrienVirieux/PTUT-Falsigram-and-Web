package falsigram.processor;

import org.json.JSONObject;

public class JSONProcessor {

    private JSONObject request;
    //private Text text;
    public JSONProcessor(String stringRequest){
        this.request = new JSONObject(stringRequest);
        //text = new Text(request.get("text").toString());
    }

    public String processJSONRequest() {
        return this.request.get("text").toString();
    }
}
