window.onload = function ReadFile(){
  document.querySelector("#ReadText").addEventListener('click', function(){
    if(document.querySelector("#textUpload").files.length == 0){
      alert('Erreur dans le texte personnalisé');
      return;
    }
    let file = document.querySelector("#textUpload").files[0];
    let reader = new FileReader();
    reader.addEventListener('load', function(e){
      let text = e.target.result;
      console.log("Texte chargé avec succes");
      console.log(e.target.result.replace(/(?:\r\n|\r|\n)/g, ''));
      document.querySelector("#textinput").textContent = text;
    });

    reader.readAsText(file);
  })
  document.querySelector("#ReadwordListInsert").addEventListener('click', function(){
    if(document.querySelector("#wordListUploadInsert").files.length == 0){
      alert('Erreur dans la liste de Insert');
      return;
    }
    let file = document.querySelector("#wordListUploadInsert").files[0];
    let reader = new FileReader();
    reader.addEventListener('load', function(e){
      let text = e.target.result;
      console.log("Liste chargée avec succes");
      console.log(e.target.result.replace(/(?:\r\n|\r|\n)/g, ''));
      document.querySelector("#ContenueWordListInsert").value = text;
    });

    reader.readAsText(file);
  })
  document.querySelector("#ReadwordListReplace").addEventListener('click', function(){
    if(document.querySelector("#wordListUploadReplace").files.length == 0){
      alert('Erreur dans la liste de Replace');
      return;
    }
    let file = document.querySelector("#wordListUploadReplace").files[0];
    let reader = new FileReader();
    reader.addEventListener('load', function(e){
      let text = e.target.result;
      console.log("Liste chargée avec succes");
      console.log(e.target.result.replace(/(?:\r\n|\r|\n)/g, ''));
      document.querySelector("#ContenueWordListReplace").value = text;
    });

    reader.readAsText(file);
  })
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
  for(i = 1; i < nombreInput + 1; i++){
    let Input = "#Input"+ i;
    Occurence[i] = document.querySelector(Input).value;
  }

  let wordListInsert = document.querySelector("#ContenueWordListInsert").value;
  let wordListReplace = document.querySelector("#ContenueWordListReplace").value;

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
    label.innerHTML = " Valeure choisie : " + occurence;
  }
}

function updateTextInput(val, id) {
  Input = "#text" + id;
  document.querySelector(Input).value = val;
}

function updateRangeInput(val, id) {
  Input = "#" + id.substring(4);
  document.querySelector(Input).value = val;
}
