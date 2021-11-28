package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    /*
    POST : http://localhost:8080/testAvecTexte
    */
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping(value = "testAvecTexte")
    public String postAvecTexte(
            @RequestBody String texte
    ) {
        if (texte.length() < 10) {
            throw new MyOwnRuntimeException("Longueur doit être supérieure à 10");
        }
        return service.toUpperCase(texte);
    }


   /*
    * POST : http://localhost:8080/testAvecJson
    * exemple de json
        "name" : "Lionel",
        "age": 10
   */

    @PostMapping(value = "testAvecJson")
    public String postAvecJson(
            @RequestBody User user
    ) {
        return service.infoUser(user);
    }

    @GetMapping(value = "user")
    public String getAvecRien() {
        return "Salut c cool la vie";
    }

    @GetMapping(value = "user/{id}")
    public String getAvecRien(
            @PathVariable String id
    ) {
        return "Salut c " + id;
    }
}
