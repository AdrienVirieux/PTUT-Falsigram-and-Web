
      function testfalsi(){

        let Tableauoccurrence = new Array();
        for(i = 1; i <= 26; i++){
          Tableauoccurrence[i] = Math.random();
          //console.log(Tableauoccurrence[i]);
        }

        //console.log("longeur : " + Tableauoccurrence.length);
        //console.log(JSON.stringify(Tableauoccurrence[1]));
        var stringtest = "ouais cest le texte a modifié";
        var out = JSON.stringify(stringtest);
        var requete = "{ \"text\" :" + out + ", \"instructions\" : [" +
        "{\"name\" : \"deleteLetters\", \"occurrence\" : " + JSON.stringify(Tableauoccurrence[1]) + "}," +
        "{\"name\" : \"deleteSpaces\", \"occurrence\" : " + JSON.stringify(Tableauoccurrence[2]) + "}," +
        "{\"name\" : \"deleteAccents\", \"occurrence\" : " + JSON.stringify(Tableauoccurrence[3]) + "}," +
        "{\"name\" : \"deletePunctuations\", \"occurrence\" : " + JSON.stringify(Tableauoccurrence[4]) + "}," +
        "{\"name\" : \"insertLetters\", \"occurrence\" : " + JSON.stringify(Tableauoccurrence[5]) + "}," +
        "{\"name\" : \"insertSpaces\", \"occurrence\" : " + JSON.stringify(Tableauoccurrence[6]) + "}," +
        "{\"name\" : \"insertAccents\", \"occurrence\" : " + JSON.stringify(Tableauoccurrence[7]) + "}," +
        "{\"name\" : \"insertNearKeyboardKeyLetters\", \"occurrence\" : " + JSON.stringify(Tableauoccurrence[8]) + "}," +
        "{\"name\" : \"replaceLetters\", \"occurrence\" : " + JSON.stringify(Tableauoccurrence[9]) + "}," +
        "{\"name\" : \"replaceAccents\", \"occurrence\" : " + JSON.stringify(Tableauoccurrence[10]) + "}," +
        "{\"name\" : \"replacePunctuations\", \"occurrence\" : " + JSON.stringify(Tableauoccurrence[11]) + "}," +
        "{\"name\" : \"replaceAHomophones\", \"occurrence\" : " + JSON.stringify(Tableauoccurrence[12]) + "}," +
        "{\"name\" : \"replaceEtHomophones\", \"occurrence\" : " + JSON.stringify(Tableauoccurrence[13]) + "}," +
        "{\"name\" : \"replaceSaHomophones\", \"occurrence\" : " + JSON.stringify(Tableauoccurrence[14]) + "}," +
        "{\"name\" : \"replaceSeHomophones\", \"occurrence\" : " + JSON.stringify(Tableauoccurrence[15]) + "}," +
        "{\"name\" : \"replaceSaitHomophones\", \"occurrence\" : " + JSON.stringify(Tableauoccurrence[16]) + "}," +
        "{\"name\" : \"replaceDansHomophones\", \"occurrence\" : " + JSON.stringify(Tableauoccurrence[17]) + "}," +
        "{\"name\" : \"replaceLaHomophones\", \"occurrence\" : " + JSON.stringify(Tableauoccurrence[18]) + "}," +
        "{\"name\" : \"replaceMaisHomophones\", \"occurrence\" : " + JSON.stringify(Tableauoccurrence[19]) + "}," +
        "{\"name\" : \"replaceOnHomophones\", \"occurrence\" : " + JSON.stringify(Tableauoccurrence[20]) + "}," +
        "{\"name\" : \"replaceOuHomophones\", \"occurrence\" : " + JSON.stringify(Tableauoccurrence[21]) + "}," +
        "{\"name\" : \"replacePeuHomophones\", \"occurrence\" : " + JSON.stringify(Tableauoccurrence[22]) + "}," +
        "{\"name\" : \"swapLettersInWord\", \"occurrence\" : " + JSON.stringify(Tableauoccurrence[23]) + "}," +
        "{\"name\" : \"swapContiguousLettersInWord\", \"occurrence\" : " + JSON.stringify(Tableauoccurrence[24]) + "}," +
        "{\"name\" : \"swapWordsInSentence\", \"occurrence\" : " + JSON.stringify(Tableauoccurrence[25]) + "}," +
        "{\"name\" : \"swapContiguousWordsInSentence\", \"occurrence\" : " + JSON.stringify(Tableauoccurrence[26]) +
        "} ] }";
        document.getElementById("paragraphe1").innerHTML = requete;
        return(requete);
      }

      function SendRequest(){
        let url = "http://localhost:8080/RequestJSONProcess";
        let xhr = new XMLHttpRequest();
        xhr.open("POST", url);
        xhr.setRequestHeader("Accept", "application/json")
        xhr.setRequestHeader("Content-Type", "application/json");

        xhr.onreadystatechange = function () {
          if (xhr.readyState === 4) {
            console.log(xhr.responseText);
            document.getElementById("paragraphe2").innerHTML = xhr.responseText;
          }};

        //let requete = testfalsi();
        let out = "ouai salut je suis le texte de test nul";
        let occurence = document.getElementById("input1").value
        let requete = "{ \"text\" :" + out + ", \"instructions\" : [" +
        "{\"name\" : \"deleteLetters\", \"occurrence\" : " + occurence +
        "} ] }";
        console.log(requete);
        xhr.send(requete);
        document.getElementById("paragraphe1").innerHTML = requete;
        document.getElementById("input1label").innerHTML = "deleteLetters. Valeure choisie : " + occurence;

      }
