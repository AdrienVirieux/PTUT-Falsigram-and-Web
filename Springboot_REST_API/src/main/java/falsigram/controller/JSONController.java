package falsigram.controller;
import falsigram.processor.JSONProcessor;
import org.springframework.web.bind.annotation.*;

@RestController
public class JSONController {

    @PostMapping(value = "RequestJSONProcess")
    public String JSONRequestExecuter(
            @RequestBody String request
    ) {
        JSONProcessor jP = new JSONProcessor(request);

        return jP.processJSONRequest();
    }

}
