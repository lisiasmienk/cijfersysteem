function maakKlassenDropDown() {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 3) {
            var sel = document.getElementById('kiesklas');
            var opt = document.createElement('option');
            opt.appendChild( document.createTextNode('-----') );
            sel.appendChild(opt);

            var info = JSON.parse(this.responseText);
            for (var x = 0; x < info.length; x++) {
                document.getElementById("kiesklas").innerHTML += "<option>" + info[x].id + ". " + info[x].naam + "</option>";
            }
        }
    }
    xhr.open("GET", "http://localhost:8082/klassenOverzicht", true);
    xhr.send();
}

function maakLeerlingenDropdown() {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 3) {
            var sel = document.getElementById('kiesleerling');
            var opt = document.createElement('option');
            opt.appendChild(document.createTextNode('-----'));
            sel.appendChild(opt);

            var info = JSON.parse(this.responseText);
            for (var x = 0; x < info.length; x++) {
                document.getElementById("kiesleerling").innerHTML += "<option>" + info[x].id + ". " + info[x].voornaam + " " + info[x].achternaam + "</option>";
            }
        }
    }
    xhr.open("GET", "http://localhost:8082/leerlingOverzicht", true);
    xhr.send();
}

function maakVakkenDropdown() {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 3) {
            var sel = document.getElementById('kiesvak');
            var opt = document.createElement('option');
            opt.appendChild(document.createTextNode('-----'));
            sel.appendChild(opt);

            var info = JSON.parse(this.responseText);
            for (var x = 0; x < info.length; x++) {
                document.getElementById("kiesvak").innerHTML += "<option>" + info[x].id + ". " + info[x].naam + "</option>";
           
            }
        }
    }
    xhr.open("GET", "http://localhost:8082/vakkenOverzicht", true);
    xhr.send();
}

function maakDocentenDropdown() {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 3) {
            var sel = document.getElementById('kiesdocent');
            var opt = document.createElement('option');
            opt.appendChild(document.createTextNode('-----'));
            sel.appendChild(opt);

            var info = JSON.parse(this.responseText);
            for (var x = 0; x < info.length; x++) {
                document.getElementById("kiesdocent").innerHTML += "<option>" + info[x].id + ". " + info[x].achternaam + "</option>";
            }
        }
    }
    xhr.open("GET", "http://localhost:8082/docentOverzicht", true);
    xhr.send();
}

function maakVakkenDropdownVoorDocent() {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 3) {
            var select = document.getElementById("kiesvak");
            var opt = document.createElement('option');
            opt.appendChild(document.createTextNode('-----'));
            select.appendChild(opt);

            var length = select.options.length;
            for (i = length - 1; i > 0; i--) {
                select.options[i] = null;
            }
            try{
                var info = JSON.parse(this.responseText);
                for (var x = 0; x < info.length; x++) {
                    document.getElementById("kiesvak").innerHTML += "<option>" + info[x].id + ". " + info[x].naam + "</option>";
                }
            }catch(e){
                document.getElementById("kiesvak").innerHTML = "<option>-----</option>";
            }
        }
    }
    var docentId = document.getElementById("kiesdocent").value;
    docentId = docentId.split(".")[0];
    xhr.open("GET", "http://localhost:8082/vakkenVanDocent/" + docentId, true);
    xhr.send();
}

function maakDocentenDropdownVoorVak() {
    if (document.getElementById("kiesvak").value != '-----') {
        let xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 3) {
                var select = document.getElementById("kiesdocent");
                var opt = document.createElement('option');
                opt.appendChild(document.createTextNode('-----'));
                select.appendChild(opt);

                var length = select.options.length;
                for (i = length - 1; i > 0; i--) {
                    select.options[i] = null;
                }
                try {
                    var info = JSON.parse(this.responseText);
                    for (var x = 0; x < info.length; x++) {
                        document.getElementById("kiesdocent").innerHTML += "<option>" + info[x].id + ". " + info[x].achternaam + "</option>";
                    }
                } catch (err) { }
            }
        }
        var vakId = document.getElementById("kiesvak").value.split(".")[0];
        xhr.open("GET", "http://localhost:8082/docentenVanVak/" + vakId, true);
        xhr.send();
    } else {
        var select = document.getElementById("kiesdocent");
        var length = select.options.length;
        for (i = length - 1; i > 0; i--) {
            select.options[i] = null;
        }
    }
}

function maakKlassenDropDownVoorDocentVak(){
    if (document.getElementById("kiesvak").value != '-----') {
        let xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 3) {
                var select = document.getElementById("kiesklas");
                var opt = document.createElement('option');
                opt.appendChild(document.createTextNode('-----'));
                select.appendChild(opt);

                var length = select.options.length;
                for (i = length - 1; i > 0; i--) {
                    select.options[i] = null;
                }
                try {
                    var info = JSON.parse(this.responseText);
                    for (var x = 0; x < info.length; x++) {
                        document.getElementById("kiesklas").innerHTML += "<option>" + info[x].id + ". " + info[x].naam + "</option>";
                    }
                } catch (err) { }
            }
        }
        var docentid = document.getElementById("kiesdocent").value.split(".")[0];
        var vakid = document.getElementById("kiesvak").value.split(".")[0];
        console.log(vakid);
        xhr.open("GET", "http://localhost:8082/klassenVanDocentEnVak/" + docentid +"/"+ vakid, true);
        xhr.send();  
    } else {
        var select = document.getElementById("kiesdocent");
        var length = select.options.length;
        for (i = length - 1; i > 0; i--) {
            select.options[i] = null;
        }
    }
}
