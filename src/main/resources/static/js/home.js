$(document).ready(function(){
    var ulogovaniKorisnik;
    if(isLoggedIn()){
        $('#login').hide();
        $.ajax({
            timeout: 1000,
            type: 'GET',
            url: '/api/korisnici'

        }).done(function(data, textStatus, jqXHR) {
            ulogovaniKorisnik = data;
            if(ulogovaniKorisnik.uloga==="ADMIN"){
                $('#korisniciAdmin').show();
                $('#bioskopiAdmin').show();
                $('#bioskopiMenadzer').hide();
            }
            if(ulogovaniKorisnik.uloga==="MENADZER"){
                $('#bioskopiMenadzer').show();
                $('#bioskopiAdmin').hide();
                $('#korisniciAdmin').hide();
            }
            if(ulogovaniKorisnik.uloga==="GLEDALAC"){
                $('#bioskopiMenadzer').hide();
                $('#bioskopiAdmin').hide();
                $('#korisniciAdmin').hide();
            }

        });
    }else{
        $('#logout').hide();
        $('#mojProfil').hide();
        $('#bioskopiMenadzer').hide();
        $('#bioskopiAdmin').hide();
        $('#korisniciAdmin').hide();
    }

    $('#logout').on('click', function (event){
        $.ajax({
            data: {},
            timeout: 1000,
            type: 'POST',
            url: '/logout'

        }).done(function(data, textStatus, jqXHR) {
            $('#login').show();
            $('#logout').hide();
            $.removeCookie('bioskop', { path: '/' });

        }).fail(function(jqXHR, textStatus, errorThrown) {

            console.error('Greska');
        });
    });

    function isLoggedIn(){
        return $.cookie('bioskop');
    }
});

$(document).ajaxError(function myErrorHandler(event, xhr, ajaxOptions, thrownError) {
    if (xhr.status === 401) {
        window.location = '/prijava.html';
    } else if (xhr.status === 403) {//forbidden
        window.location = '/';
    } else {
        console.error('Greska');
    }
});