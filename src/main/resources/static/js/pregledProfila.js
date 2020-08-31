$(document).ready(function(){
    var korisnik = "<tr>";
    korisnik += "<th>" + localStorage.getItem('Ime') + "</th>";
    korisnik += "<th>" + localStorage.getItem('Prezime') + "</th>";
    korisnik += "<th>" + localStorage.getItem('Uloga') + "</th>";
    korisnik += "<th>" + localStorage.getItem('kontaktTelefon') + "</th>";
    korisnik += "<th>" + localStorage.getItem('E_mail') + "</th>";
    korisnik += "<th>" + localStorage.getItem('korisnickoIme') + "</th>";
    korisnik += "</tr>";
    $('#nalog').append(korisnik);
});