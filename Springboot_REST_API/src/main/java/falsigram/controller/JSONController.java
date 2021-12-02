package falsigram.controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class JSONController {

    @PostMapping(value = "RequestJSONProcess")
    public String JSONRequestExecuter(
            @RequestBody String JSONRequest
    ) {

        return "oui";
    }

}
