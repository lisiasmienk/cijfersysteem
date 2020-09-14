function maakDropDowns(){
    maakKlassenDropDown();
    maakLeerlingenDropdown();
    //TODO: Toon leerlingenlijst van geselecteerde klas
}

function toonLeerlingen(klasid){
    if (klasid == "-----"){
        document.getElementById("tabel").innerHTML = "<tr><td> Selecteer een vak </td></tr>";
    } else{
        var klasid = document.getElementById("kiesklas").value;
        klasid = klasid.split(".")[0];
        document.getElementById("tabel").innerHTML = "";
        let xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 3) {
                if (this.responseText.length > 0){
                    var info = JSON.parse(this.responseText);
                    for (var x = 0; x < info.length; x++) {
                        document.getElementById("tabel").innerHTML += 
                        "<tr><td>" + info[x].voornaam + "</td>" +
                        "<td>" + info[x].achternaam + "</td>" +
                        "<td>" + info[x].geboorteDatum + "</td>";
                    }
                } else{
                    document.getElementById("tabel").innerHTML += "<tr><td> In deze klas zitten nog geen leerlingen </td></tr>";
                }
            }
        }
        xhr.open("GET", "http://localhost:8082/leerlingenInKlas/"+klasid, true);
        xhr.send();
    }
}

function voegLeerlingToe(){
    var tekst = document.getElementById("kiesleerling").value;
    var leerlingid = tekst.split(".")[0];
    var tekst2 = document.getElementById("kiesklas").value;
    var klasid = tekst2.split(".")[0];
    var leerlingklas = {"klasid":klasid, "leerlingid":leerlingid};
    var json = JSON.stringify(leerlingklas);
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:8082/api/voegLeerlingToe", true);
    xhttp.onreadystatechange = function () {    
        if (xhttp.readyState == 4) {
            toonLeerlingen();
        }
    };
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send(json);
    //TODO: Auto refresh van leerlingen lijst toevoegen
}