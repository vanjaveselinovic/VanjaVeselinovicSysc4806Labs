$(document).ready(function() {
    $('#create-address-book').submit(function(event) {
        event.preventDefault();
        $.ajax({
            method: 'POST',
            url: 'http://localhost:8090/addressbooks',
            cache: false,
            data: '{"dummy": "dummy"}',
            crossDomain: true,
            dataType: 'json',
            contentType: 'application/json'
        })
            .done(function(data) {
                $('#address-books').append('Address book '+data.id);
            })
            .fail(function() {

            });
    })
});