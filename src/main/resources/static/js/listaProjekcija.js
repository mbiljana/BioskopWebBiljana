$(document).ready(function(){
    $("#rezervacijahtml").hide();
    $("#rezervisaneProjekcije").hide();
    $.ajax({
        type:"GET",
        url: "http://localhost:8080/api/listaProjekcija",
        dataType:"json",
        success: function(data){
            console.log("SUCCESS: ", data);

            for(i=0;i<data.length;i++){
                var row="<tr>";
                row +="<td>" + data[i]['nazivFilma'] + "</td>";
                row +="<td>"+data[i]['zanrFilma'] + "</td>";
                row +="<td>" + data[i]['danProjekcije'] + "</td>";
                row +="<td>" + data[i]['pocetak'] + "</td>";
                row +="<td>" + data[i]['cena'] +"</td>";
                var vise="<a class='detaljiProjekcije' id=" + data[i]['id'] + "> vise </a>";
                row +="<td>" + vise+"</td>";

                var rezervisi="<a class='rezervisi' id=" + data[i]['id'] + "> rezervisi </a>";
                row +="<td>" + rezervisi +"</td>";
                $('#terminskeListe').append(row);
            }
        },
        error: function (data){
            console.log("ERROR: ", data);
        }
    });

});

$(document).on('click','.detaljiProjekcije', function(){
    $("#sveTerminskeListe").hide();
    $('#pretraga').hide();
    $('#jumbotron').hide();
    $("#rezervisaneProjekcije").hide();
    $.ajax({
        type:"GET",
        url: "http://localhost:8080/api/listaProjekcija/detaljiProjekcije/"+this.id,
        dataType: "json",
        success: function(data){
            console.log("SUCCESS: ",data);
            $('#film').append(data['nazivFilma']);
            $('#ocenaFilma').append(data['ocena']);
            $('#opis').append(data['opisFilma']);
            $('#zanrFilma').append(data['zanrFilma']);
            $('#rezervisanoMesta').append(data['brojRezervacija']);
            $('#ukupnoMesta').append(data['kapacitetSale']);
            $('#salaUkojojJeProjekcija').append(data['nazivSale']);
            $('#pocetak').append(data['pocetak']);
            $('#datum').append(data['danProjekcije']);
            $("#rezervacijahtml").show();
        },
        error: function(data){
            console.log("ERROR : ",data);
        }
    });
});


//pretraga po nazivu
$(document).on('click','#pretrazi',function(){
	  var naziv=$("#naziv1").val();
				$.ajax({
					type:"GET",
					url:"http://localhost:8080/api/listaProjekcija/naziv/"+naziv,
					dataType:"json",
					success:function(data){
						console.log("SUCCESS: ",data);
						alert("Trazimo film "+naziv);
						$('#terminskeListe td').remove();
						for(i=0;i<data.length;i++){
							var row="<tr>";
							row +="<td>" + data[i]['nazivFilma'] + "</td>";
							row +="<td>" + data[i]['zanrFilma'] + "</td>";
							row +="<td>" + data[i]['danProjekcije'] +"</td>";
							row +="<td>" + data[i]['pocetak'] +"</td>";
							row +="<td>" + data[i]['cena'] +"</td>";
							var vise="<a class='detaljiProjekcije' id=" + data['id'] + "> vise </a>";
							row +="<td>" + vise+"</td>";
							var rezervisi="<a class='rezervisi' id=" + data[i]['id'] + "> rezervisi </a>";
							row +="<td>" + rezervisi +"</td>";
							$('#terminskeListe').append(row);
						}
					},
					error: function () {
			            alert("Greška!");
			        }
				});
});
//pretraga naziv i zanr
$(document).on('click','#pretrazi',function(){
	  var naziv=$("#naziv1").val();
	  var zanr=$("#zanr1").val();
				$.ajax({
					type:"GET",
					url:"http://localhost:8080/api/listaProjekcija/naziv/"+naziv +"/"+ zanr,
					dataType:"json",
					success:function(data){
						console.log("SUCCESS: ",data);
						alert("Trazimo film "+naziv+", zanr: "+zanr);
						$('#terminskeListe td').remove();
						for(i=0;i<data.length;i++){
							var row="<tr>";
							row +="<td>" + data[i]['nazivFilma'] + "</td>";
							row +="<td>" + data[i]['zanrFilma'] + "</td>";
							row +="<td>" + data[i]['danProjekcije'] +"</td>";
							row +="<td>" + data[i]['pocetak'] +"</td>";
							row +="<td>" + data[i]['cena'] +"</td>";
							var vise="<a class='detaljiProjekcije' id=" + data['id'] + "> vise </a>";
							row +="<td>" + vise+"</td>";
							var rezervisi="<a class='rezervisi' id=" + data[i]['id'] + "> rezervisi </a>";
							row +="<td>" + rezervisi +"</td>";
							$('#terminskeListe').append(row);
						}
					},
					error: function () {
			            alert("Greška!");
			        }
				});
});

$(document).on("submit","form",function(event){
    event.preventDefault();

    var nazivFilma=$("#naziv1").val();
    var zanrFilma=$("#zanr1").val();
    var cena=$("#cena1").val();
    var danProjekcije=$("#danProjkcije1").val();
    var pocetak=$("#pocetak1").val();

    var pretragaTL=formToJSON(pocetak,cena,nazivFilma,danProjekcije,zanrFilma);
    $.ajax({
        type:"POST",
        url:"http://localhost:8080/api/listaProjekcija/pretraga",
        dataType:"json",
        contentType:"application/json",
        data: pretragaTL,
        success:function(data){
            alert("Trazi se film");
            console.log("SUCCESS: ",data);
            $('#terminskeListe td').remove();
            for(i=0;i<data.length;i++){
                var row="<tr>";
                row +="<td>" + data[i]['nazivFilma'] + "</td>";
                row +="<td>" + data[i]['zanrFilma'] + "</td>";
                row +="<td>" + data[i]['danProjekcije'] +"</td>";
                row +="<td>" + data[i]['pocetak'] +"</td>";
                row +="<td>" + data[i]['cena'] +"</td>";
                var vise="<a class='detaljiProjekcije' id=" + data['id'] + "> vise </a>";
                row +="<td>" + vise+"</td>";
                var rezervisi="<a class='rezervisi' id=" + data[i]['id'] + "> rezervisi </a>";
                row +="<td>" + rezervisi +"</td>";
                $('#terminskeListe').append(row);
            }
        },
        error: function (data) {
            console.log("ERROR: ",data);
            alert("Greška!");
        }
    });
});
function formToJSON(pocetak,cena,nazivFilma,danProjekcije,zanrFilma){
    return JSON.stringify({
        "nazivFilma":nazivFilma,
        "zanrFilma":zanrFilma,
        "cena":cena,
        "danProjekcije":danProjekcije,
        "pocetak":pocetak
    });
}
$(document).on('click','#sortCena',function(){
    $.ajax({
        type:"GET",
        url:"http://localhost:8080/api/listaProjekcija/sortCena",
        dataType:"json",
        success:function(data){

            console.log("SUCCESS: ",data);
            $('#terminskeListe td').remove();
            for(i=0;i<data.length;i++){
                var row="<tr>";
                row +="<td>" + data[i]['nazivFilma'] + "</td>";
                row +="<td>" + data[i]['zanrFilma'] + "</td>";
                row +="<td>" + data[i]['danProjekcije'] +"</td>";
                row +="<td>" + data[i]['pocetak'] +"</td>";
                row +="<td>" + data[i]['cena'] +"</td>";
                var vise="<a class='detaljiProjekcije' id=" + data['id'] + "> vise </a>";
                row +="<td>" + vise+"</td>";
                var rezervisi="<a class='rezervisi' id=" + data[i]['id'] + "> rezervisi </a>";
                row +="<td>" + rezervisi +"</td>";
                $('#terminskeListe').append(row);
            }
        },
        error:function(data){
            console.log("ERROR: ",data);
        }

    });
});