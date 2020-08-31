$(document).ready(function(){
    var obj = JSON.stringify({
        "korisnickoIme" : localStorage.getItem('KorisnickoIme'),
        "lozinka" : "---"
    });

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/ocena/ocenjeni",
        dataType: "json",
        contentType: "application/json",
        data: obj,
        success: function (data) {
            console.log("SUCCESS : ", data);
            for (i = 0; i < data.length; i++) {
                var row = "<tr>";
                row += "<td>" + data[i]['film'] + "</td>";
                row += "<td>" + data[i]['ocena'] + "</td>";
                row += "</tr>";
                $('#ocene').append(row);
            }
        },
        error: function (data) {
            alert("Greška");
            console.log("ERROR : ", data);
        }
    });
});