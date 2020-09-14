function laatKlassenZien() {
    document.getElementById("tabel").innerHTML = "";

    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 3) {
            try{
                var info = JSON.parse(this.responseText);
                document.getElementById("tabel").innerHTML += "<tr><td><b>Naam</b></td><td><b>Niveau</b></td></tr>"

                for (var x = 0; x < info.length; x++) {
                    document.getElementById("tabel").innerHTML += "<tr>" +
                        "<td id=idPass"+[x]+">" + info[x].id + "</td>" +
                        "<td id=naamPass"+[x]+">" + info[x].naam + "</td>" +
                        "<td id=niveauPass"+[x]+">" + info[x].niveau + "</td>" +
                        "<td><img src='EditButton.png' class='editB' id=editButton" + x + " style='height:20px;width20px;' Onclick= editKlas("+ x + ")></td>" +
                        "</tr>";
                }
            } catch(err){
                document.getElementById("tabel").innerHTML += "<tr><td> Er staan nog geen klassen in het klassenoverzicht </td></tr>";
            }    
        document.getElementById("tabel").innerHTML += "<button onclick = openModal(document.getElementById('modal'))>+ Klas</button>";
        }

    }
    xhr.open("GET", "http://localhost:8082/klassenOverzicht", true);
    xhr.send();
}

function maakKlasAan() {
    var naam = document.getElementById("naamInput").value;
    var niveau = document.getElementById("niveauInput").value;
    var klas = '{"naam":"' + naam + '","niveau":"' + niveau + '"}';
    postData(klas);
    modal.classList.remove('active')
    overlay.classList.remove('active')
}

function postData(klas) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {    
        if (xhttp.readyState == 4) {
            laatKlassenZien();
        }
    }
    xhttp.open("POST", "http://localhost:8082/api/maakKlas", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send(klas);
}