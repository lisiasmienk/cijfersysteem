function maakDropdowns(){
    maakDocentenDropdown();
}

function maakCijferOverzicht(){
    var docentid = document.getElementById("kiesdocent").value.split(".")[0];
    var vakid = document.getElementById("kiesvak").value.split(".")[0];
    var klasid = document.getElementById("kiesklas").value.split(".")[0];
    document.getElementById("tabel").innerHTML = "";
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        console.log(xhr.readyState);
        if (xhr.readyState == 3) {
            var info = JSON.parse(this.responseText);
            document.getElementById("tabel").innerHTML += "<tr><td>Naam leerling</td></tr>";
            var htmlstring = "";
            for (var x = 0; x < info.length; x++) {
                htmlstring += "<tr><td>" + info[x].leerlingnaam + "</td>";
                for(i=0; i<info[x].cijfers.length; i++){
                   htmlstring += "<td>" + info[x].cijfers[i] + "</td>";
                }
                htmlstring += "</tr>";
            }
            document.getElementById("tabel").innerHTML += htmlstring;
        }
    }
    xhr.open("GET", "http://localhost:8082/toonCijfersVan/" + docentid + "/" + vakid + "/" + klasid, true);
    xhr.send();
}