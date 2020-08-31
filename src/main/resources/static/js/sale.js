$(document).ready(function(){
    var pe=$("#sveTerminskeListeUsali");
    pe.hide();
    $.ajax({
        type:"GET",
        url: "http://localhost:8080/api/sale",
        dataType:"json",
        success: function(data){
            console.log("SUCCESS: ", data);
            for(i=0;i<data.length;i++){
                var row="<tr>";
                row +="<td>" + data[i]['id'] + "</td>";
                row +="<td>" + data[i]['oznakaSale'] + "</td>";
                row +="<td>" + data[i]['kapacitet'] + "</td>";

                var termini="<a class='termini' id="+ data[i]['id']+">termisnka lista</a>"
                row += "<td>"+termini+"</td>";
                var izmeni="<a class='izmeniSalu' id="+ data[i]['id']+">izmeni</a>"
                row += "<td>"+izmeni+"</td>";
                var obrisi="<a class='obrisiSalu' id="+ data[i]['id']+">obrisi</a>"
                row += "<td>"+obrisi+"</td>";
                $('#salee').append(row);
            }
        },
        error: function (data){
            console.log("ERROR: ", data);
        }
    });
});