function maakDropDowns(){
    maakLeerlingenDropdown();
}

function toonLeerlingen(leerlingid){
    leerlingidnu = leerlingid.split(".")[0];
    leerlingnaamnu = leerlingid.split(".")[1];
    document.getElementById("tabelA").innerHTML = "";
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 3) {
            var info = JSON.parse(this.responseText);

                document.getElementById("tabelA").innerHTML += 
                "<tr><td> WELKOM "+ leerlingnaamnu+" ,  voor cijfers druk TOON CIJFERS </td>" 

        
        }
    }
 
   xhr.open("GET", "http://localhost:8082/leerlingOverzicht/", true);
 
    xhr.send();

}


function laatVakCijferTabelZien(leerlingid) {

    document.getElementById("tabel").innerHTML = "";

    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 3) {
            var alleinfo = JSON.parse(this.responseText);

            document.getElementById("tabel").innerHTML += "<tr><td><b> VAKid </b></td><td><b>VAK</b></td><td><b>Toets1</b></td><td><b>Toets2</b></td></tr>"

            for (var x = 0; x < alleinfo.length; x++) {
                document.getElementById("tabel").innerHTML += "<tr>" +
                "<td id=vakPass"+[x]+">" + alleinfo[x].id + "</td>" +
                    "<td id=vakPass"+[x]+">" + alleinfo[x].naam + "</td>" +
                     "<td> <table id=innerTable border=1>"+ alleinfo[x].id+ "</table> </td>" +
                     //"<td> <table id=cijfers"+[x]+">" + alleinfo[x].cijfer+ "</table> </td>" +
                    //  "<td id=cijferVanVakInDezeRow2> </td>" +
                    //  "<td id=idPass"+x+">"+alleinfo[x].id+"</td>"+ 
                   

                   // <table id="innerTable" border = 5></table>
                    "</tr>";
                   var vakid = alleinfo[x].id;
                   toonToetsen(vakid);
                   
            }
            
        }
  
    }

    xhr.open("GET", "http://localhost:8082/vakkenOverzicht", true);
    xhr.send();

}


function toonToetsen(vakid){
    console.log("dit is id van vak " + vakid);
    document.getElementById("innerTable").innerHTML = "";
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 3) {
            var info = JSON.parse(this.responseText);
            for (var x = 0; x < info.length; x++) {
                document.getElementById("innerTable").innerHTML += "<tr>" +
                "<tr>" + vakid + "</tr>" +
                "<tr> ----- </tr>" +
                    "<tr>" + info[x].datum + "</tr>" +
                    "<tr id=cijferLezen> cijfer </tr>" 
                    "</tr>";
            }
        }
    }
    xhr.open("GET", "http://localhost:8082/toetsenVanVak/"+vakid, true);
    //xhr.open("GET", "http://localhost:8082/toetsenVanVakmetNaamEnCijfer/"+vakid, true);
    xhr.send();

}
