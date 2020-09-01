var id;
$(document).ready(function(){
    var searchParams=new URLSearchParams(window.location.search);
    id=searchParams.get('id');
    $.ajax({
        type:"GET",
        url:"http://localhost:8080/api/filmovi/"+id,
        dataType:"json",
        success:function(data){
            console.log("SUCCCESS: ",data);
            $("#nazivFilmaZaOcenu").text(data['naziv']);
        },
        error: function(data){
            console.log("ERROR: ",data);
        }

    });
});
$(document).on("submit","form",function(event){
    event.preventDefault();
    var ocena=$("#ocena").val();
    $.ajax({
        type:"POST",
        url:"http://localhost:8080/api/ocena",
        dataType:"json",
        contentType:"application/json",
        data: ocena,
        success:function(){
            //console.log("SUCCESS: ",data);
            alert("Uspesno ste ocenili film");
            window.location.href="pregledProfila.html";
        },
        error: function () {
            console.log("ERROR: ",data);
            alert("Greška!");
        }
    });
});