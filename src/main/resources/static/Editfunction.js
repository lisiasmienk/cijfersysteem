
/////DOCENTEN://///

function editDocent(x){ 
    openModal(document.getElementById("editModal"));

   console.log("tijd om te editten in rij : " + x);

    var y = document.getElementById("tabel").rows[x+1].innerHTML; // plus 1, zodat hij de tabeltitels skipt
    console.log("DOCENT SELECTED:   " + y);


   var w = document.getElementById("idPass"+x).innerHTML;
   var w2 = document.getElementById("voornaamPass"+x).innerHTML;
   var w3 = document.getElementById("achternaamPass"+x).innerHTML;

    console.log("SELECTEREN VAN DOCENT BIJ ID:  " + w);
    console.log("SELECTEREN DOCENT BIJ VOORNAAM: " + w2);
    console.log("SELECTEREN VAN DOCENT BIJ ACHTERNAAM:  " + w3);

   // var x = document.getElementById("voornaamPass"+ x).innerHTML = "APPEL"; // om met de hand editten te checken!

    document.getElementById("idEdit").value = w;
    document.getElementById("voornaamEdit").value = w2;
    document.getElementById("achternaamEdit").value = w3;
}

function postEditDocentData() {
   
    var idEdit =  document.getElementById("idEdit").value;
    var voornaamEdit =  document.getElementById("voornaamEdit").value;
    var achternaamEdit =  document.getElementById("achternaamEdit").value;

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:8082/api/editDocent/"+  idEdit, true);
    xhttp.setRequestHeader("Content-type", "application/json");

    var docentEdit = '{"voornaam":"' + voornaamEdit + '","achternaam":"' + achternaamEdit +'","id":"' + idEdit +'"}';
    xhttp.send(docentEdit);

    editModal.classList.remove('active');
    overlay.classList.remove('active');  

}


/////LEERLINGEN://///


function editLeerling(x){ 
    openModal(document.getElementById("editModal"));

   console.log("tijd om te editten in rij : " + x);

    var y = document.getElementById("tabel").rows[x+1].innerHTML; // plus 1, zodat hij de tabeltitels skipt
    console.log("LEERLING SELECTED:   " + y);

   var w = document.getElementById("idPass"+x).innerHTML;
   var w2 = document.getElementById("voornaamPass"+x).innerHTML;
   var w3 = document.getElementById("achternaamPass"+x).innerHTML;
   var w4 = document.getElementById("geboortedatumPass"+x).innerHTML;
   var w5 = document.getElementById("leerlingnummerPass"+x).innerHTML;

    console.log("SELECTEREN VAN LEERLING BIJ ID:  " + w);
    console.log("SELECTEREN LEERLING BIJ VOORNAAM: " + w2);
    console.log("SELECTEREN VAN LEERING BIJ ACHTERNAAM:  " + w3);
    console.log("SELECTEREN VAN LEERING BIJ GEBDATUM:  " + w4);
    console.log("SELECTEREN VAN LEERING BIJ LEERLINGNR:  " + w5);

   // var x = document.getElementById("voornaamPass"+ x).innerHTML = "APPEL"; // om met de hand editten te checken!

    document.getElementById("idEdit").value = w;
    document.getElementById("voornaamEdit").value = w2;
    document.getElementById("achternaamEdit").value = w3;
    document.getElementById("geboortedatumEdit").value = w4;
    document.getElementById("leerlingnummerEdit").value = w5;
}

function postEditLeerlingData() {
   
    var idEdit =  document.getElementById("idEdit").value;
    var voornaamEdit =  document.getElementById("voornaamEdit").value;
    var achternaamEdit =  document.getElementById("achternaamEdit").value;
    var geboortedatumEdit =  document.getElementById("geboortedatumEdit").value;
    var leerlingnummerEdit =  document.getElementById("leerlingnummerEdit").value;

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:8082/api/editLeerling/"+  idEdit, true);
    xhttp.setRequestHeader("Content-type", "application/json");

    var leerlingEdit = '{"voornaam":"' + voornaamEdit + '","achternaam":"' + achternaamEdit +'","id":"' + idEdit +
    '","geboortedatum":"' + geboortedatumEdit +'","leerlingnummer":"' + leerlingnummerEdit +'"}';
    xhttp.send(leerlingEdit);

    editModal.classList.remove('active');
    overlay.classList.remove('active');  

}

////// KLASSEN: ////

function editKlas(x, klasid){ 
    openModal(document.getElementById("editModal"));

   console.log("tijd om te editten in rij : " + x);

    var y = document.getElementById("tabel").rows[x+1].innerHTML; // plus 1, zodat hij de tabeltitels skipt
    console.log("KLAS SELECTED:   " + y);

   var w = document.getElementById("naamPass"+x).innerHTML;
   var w2 = document.getElementById("niveauPass"+x).innerHTML;
   var w3 = document.getElementById("idPass"+x).innerHTML;

    console.log("SELECTEREN VAN KLAS BIJ NAAM:  " + w);
    console.log("SELECTEREN VAN KLAS BIJ NIVEAU: " + w2);
   console.log("SELECTEREN VAN KLAS BIJ ID: " + w3);

    document.getElementById("naamEdit").value = w;
    document.getElementById("niveauEdit").value = w2;
    document.getElementById("idEdit").value = w3;
}

function postEditKlasData() {

    var naamEdit =  document.getElementById("naamEdit").value;
    var niveauEdit =  document.getElementById("niveauEdit").value;
    var klasid = document.getElementById("idEdit").value;

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:8082/api/editklas/"+  idEdit, true);
    xhttp.setRequestHeader("Content-type", "application/json");

    var klasEdit = '{"naam":"' + naamEdit + '","niveau":"' + niveauEdit +'","id":"' + klasid +'"}';
    xhttp.send(klasEdit);

    editModal.classList.remove('active');
    overlay.classList.remove('active');  

}





