function laatDocentenZien(vakid) {

    document.getElementById("tabel").innerHTML = "";

    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 3) {
            try{
                var alleinfo = JSON.parse(this.responseText);
            document.getElementById("tabel").innerHTML += "<tr><td><b>Id.<b></td><td><b>Voornaam</b></td><td><b>Achternaam</b></td></tr>"
            for (var x = 0; x < alleinfo.length; x++) {
                document.getElementById("tabel").innerHTML += "<tr>" +
                    "<td id=idPass"+[x]+">"+alleinfo[x].id+"</td>"+ 
                    "<td id=voornaamPass"+[x]+">" + alleinfo[x].voornaam + "</td>" +
                    "<td id=achternaamPass"+[x]+">" + alleinfo[x].achternaam + "</td>" +
                    "<td><img src='EditButton.png' class='editB' id=editButton"+ x + " style='height:20px;width20px;' Onclick= editDocent("+ x + ")></td>" +
                    "</tr>";                
                }
            } catch(err){
                document.getElementById("tabel").innerHTML += "<tr><td> Er staan nog geen docenten in het docentenoverzicht </td></tr>";
            }
            document.getElementById("tabel").innerHTML += "<button onclick = openModal(document.getElementById('modal'))>+ Docent</button>";
            document.getElementById("tabel").innerHTML += "<button onclick = laatDocentenTabelZien()> Refresh </button>";
        }
        
    }

   
    xhr.open("GET", "http://localhost:8082/docentOverzicht", true);
    xhr.send();

}



function maakDocentAan() {
    var voornaamInput = document.getElementById("voornaamInput").value;
    var achternaamInput = document.getElementById("achternaamInput").value;
    var docent = '{"voornaam":"' + voornaamInput + '","achternaam":"' + achternaamInput + '"}';
    postData(docent);
    modal.classList.remove('active');
    overlay.classList.remove('active');
}

function postData(docent) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {    
        if (xhttp.readyState == 4) {
            laatDocentenZien();
        }
    }
    xhttp.open("POST", "http://localhost:8082/api/maakDocent", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send(docent);
}

