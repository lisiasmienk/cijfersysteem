function maakDropDowns(){
    maakDocentenDropdown();
    maakVakkenDropdown();
}

function toonVakken(docentid){
    if (docentid == "-----"){
        document.getElementById("tabel").innerHTML = "<tr><td> Selecteer een vak </td></tr>";
    } else{
        var docentid = document.getElementById("kiesdocent").value;
        docentid = docentid.split(".")[0];
        document.getElementById("tabel").innerHTML = "";
        let xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 3) {
                if (this.responseText.length > 0){
                    var info = JSON.parse(this.responseText);
                    for (var x = 0; x < info.length; x++) {
                        document.getElementById("tabel").innerHTML += 
                        "<tr><td>" + info[x].naam + "</td>";
                    }
                } else{
                    document.getElementById("tabel").innerHTML += "<tr><td> Deze docent geeft nog geen vakken </td></tr>";
                }
            }
        }
        xhr.open("GET", "http://localhost:8082/vakkenVanDocent/"+docentid, true);
        xhr.send();
    }
}

function maakDocentVakAan() {
    var docentid = document.getElementById("kiesdocent").value.split(".")[0];
    var vakid = document.getElementById("kiesvak").value.split(".")[0];
    var docentvak = '{"docentid":"'+docentid+'","vakid":"'+vakid+'"}';
    postData(docentvak);
}

function postData(docentvak){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {    
        if (xhttp.readyState == 4) {
            toonVakken();
        }
    };
    xhttp.open("POST", "http://localhost:8082/maakDocentVak", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send(docentvak);
}