/*
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

*/




window.onload = function ReadFile(){
  document.querySelector("#ReadText").addEventListener('click', function(){
    if(document.querySelector("#textUpload").files.length == 0){
      alert('PAS BON');
      return;
    }
    let file = document.querySelector("#textUpload").files[0];
    let reader = new FileReader();
    reader.addEventListener('load', function(e){
      let text = e.target.result;
      console.log("Texte chargé avec succes");
      document.querySelector("#ContenueText").textContent = text;
      document.querySelector("#ContenueText").style.display = "none";
      UseLoadedText();
    });

    reader.readAsText(file);
  })
  document.querySelector("#ReadwordListInsert").addEventListener('click', function(){
    if(document.querySelector("#wordListUploadInsert").files.length == 0){
      alert('PAS BON');
      return;
    }
    let file = document.querySelector("#wordListUploadInsert").files[0];
    let reader = new FileReader();
    reader.addEventListener('load', function(e){
      let text = e.target.result;
      console.log("Liste chargée avec succes");
      document.querySelector("#ContenueWordListInsert").value = text;
      //document.querySelector("#ContenueWordListInsert").style.display = "none";
    });

    reader.readAsText(file);
  })
  document.querySelector("#ReadwordListReplace").addEventListener('click', function(){
    if(document.querySelector("#wordListUploadReplace").files.length == 0){
      alert('PAS BON');
      return;
    }
    let file = document.querySelector("#wordListUploadReplace").files[0];
    let reader = new FileReader();
    reader.addEventListener('load', function(e){
      let text = e.target.result;
      console.log("Liste chargée avec succes");
      document.querySelector("#ContenueWordListReplace").value = text;
      //document.querySelector("#ContenueWordListReplace").style.display = "none";
    });

    reader.readAsText(file);
  })
}

function UseLoadedText(){
  var text = document.querySelector("#ContenueText").innerHTML;
  //document.getElementById("ContenueText").style.display = "none";
  //console.log(text);
  document.getElementById("textinput").value = text;
}

function SendRequest(){
        let url = "http://localhost:8080/RequestJSONProcess";
        let xhr = new XMLHttpRequest();
        xhr.open("POST", url);
        xhr.setRequestHeader("Accept", "application/json")
        xhr.setRequestHeader("Content-Type", "application/json");

        xhr.onreadystatechange = function () {
          if (xhr.readyState === 4) {
            console.log("La réponse du serveur est : " + xhr.responseText);
            document.querySelector("#paragraphe2").innerHTML = xhr.responseText;
          }};

        let Occurence = new Array();
        let out = document.querySelector("#textinput").value;
        var nombreInput = document.querySelectorAll(".input").length;
        //console.log(nombreInput);
        for(i = 1; i < nombreInput + 1; i++){
          let Input = "#Input"+ i;
          console.log(Input);
          Occurence[i] = document.querySelector(Input).value;
        }

        let wordListInsert = document.querySelector("#ContenueWordListInsert").innerHTML;
        let wordListReplace = document.querySelector("#ContenueWordListReplace").innerHTML;

        console.log(wordListInsert);
        console.log(wordListReplace);

        let requete = "{ \"text\" :" + JSON.stringify(out) + ", \"instructions\" : [" +
        "{\"name\" : \"deleteLetters\", \"occurrence\" : " + Occurence[1] + "}," +
        "{\"name\" : \"deleteSpaces\", \"occurrence\" : " + Occurence[2] + "}," +
        "{\"name\" : \"deleteAccents\", \"occurrence\" : " + Occurence[3] + "}," +
        "{\"name\" : \"deletePunctuations\", \"occurrence\" : " + Occurence[4] + "}," +
        "{\"name\" : \"insertLetters\", \"occurrence\" : " + Occurence[5] + "}," +
        "{\"name\" : \"insertSpaces\", \"occurrence\" : " + Occurence[6] + "}," +
        "{\"name\" : \"insertAccents\", \"occurrence\" : " + Occurence[7] + "}," +
        //"{\"name\" : \"insertNearKeyboardKeyLetters\", \"occurrence\" : " + Occurence[7] + "}," +
        "{\"name\" : \"replaceLetters\", \"occurrence\" : " + Occurence[8] + "}," +
        "{\"name\" : \"replaceAccents\", \"occurrence\" : " + Occurence[9] + "}," +
        "{\"name\" : \"replacePunctuations\", \"occurrence\" : " + Occurence[10] + "}," +
        "{\"name\" : \"replaceAHomophones\", \"occurrence\" : " + Occurence[11] + "}," +
        "{\"name\" : \"replaceEtHomophones\", \"occurrence\" : " + Occurence[12] + "}," +
        "{\"name\" : \"replaceSaHomophones\", \"occurrence\" : " + Occurence[13] + "}," +
        "{\"name\" : \"replaceSeHomophones\", \"occurrence\" : " + Occurence[14] + "}," +
        "{\"name\" : \"replaceSaitHomophones\", \"occurrence\" : " + Occurence[15] + "}," +
        "{\"name\" : \"replaceDansHomophones\", \"occurrence\" : " + Occurence[16] + "}," +
        "{\"name\" : \"replaceLaHomophones\", \"occurrence\" : " + Occurence[17] + "}," +
        "{\"name\" : \"replaceMaisHomophones\", \"occurrence\" : " + Occurence[18] + "}," +
        "{\"name\" : \"replaceOnHomophones\", \"occurrence\" : " + Occurence[19] + "}," +
        "{\"name\" : \"replaceOuHomophones\", \"occurrence\" : " + Occurence[20] + "}," +
        "{\"name\" : \"replacePeuHomophones\", \"occurrence\" : " + Occurence[21] + "}," +
        "{\"name\" : \"swapLettersInWord\", \"occurrence\" : " + Occurence[22] + "}," +
        "{\"name\" : \"swapContiguousLettersInWord\", \"occurrence\" : " + Occurence[23] + "}," +
        "{\"name\" : \"swapWordsInSentence\", \"occurrence\" : " + Occurence[24] + "}," +
        "{\"name\" : \"swapContiguousWordsInSentence\", \"occurrence\" : " + Occurence[25] + "}," +
        "{\"name\" : \"insertWordFromSentence\", \"occurrence\" : " + Occurence[26] + "}," +
        "{\"name\" : \"replaceWordFromSentence\", \"occurrence\" : " + Occurence[27] + "}," +
        "{\"name\" : \"insertWordsFromList\", \"occurrence\" : " + Occurence[28] + ", \"wordList\" : " +  JSON.stringify(wordListInsert) + "}," +
        "{\"name\" : \"replaceWordsFromList\", \"occurrence\" : " + Occurence[29] + ", \"wordList\" : " +  JSON.stringify(wordListReplace) + "} ] }";

        console.log("La requete envoyé est : " + requete);
        xhr.send(requete);
        document.querySelector("#paragraphe1").innerHTML = requete;

        for(i = 1; i < nombreInput + 1; i++){
          let inputlabel = "#inputlabel" + i;
          let label = document.querySelector(inputlabel)
          let occurence = Occurence[i];
          //console.log(inputlabel + " " + occurence);
          //console.log(label),
          label.innerHTML = " Valeure choisie : " + occurence;
          //document.getElementById("inputlabel1").innerHTML = "test";
        }
}

function updateTextInput(val, id) {
  Input = "#text" + id;
  console.log(Input);
  document.querySelector(Input).innerHTML = val;
}

function updateRangeInput(val, id) {
  Input = "#" + id.substring(4);
  console.log(Input);
  document.querySelector(Input).innerHTML = val;
}
