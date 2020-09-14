function toonCijfers(leerlingid){
    if (leerlingid == "-----"){
        document.getElementById("tabel").innerHTML = "<tr><td> Selecteer een vak </td></tr>";
    } else{
        leerlingid = leerlingid.split(".")[0];
        document.getElementById("tabel").innerHTML = "";
        let xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 3) {
                if (this.responseText.length > 0){
                    var info = JSON.parse(this.responseText);
                //TODO: cijfer_id vervangen door Toets gegevens
                    for (var x = 0; x < info.length; x++) {
                        document.getElementById("tabel").innerHTML += 
                        "<tr><td>cijfer_id</td><td>Cijfer</td><tr>" +
                        "<tr><td>" + info[x].id + "</td>" +
                        "<td>" + info[x].cijfer + "</td>";
                    }
                } else {
                document.getElementById("tabel").innerHTML += "<tr><td> Deze leerling heeft nog geen cijfers behaald </td></tr>";
                }
            }
        }
    xhr.open("GET", "http://localhost:8082/cijfersVanLeerling/"+leerlingid, true);
    xhr.send();
    }
}