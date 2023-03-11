var breedsArray;
const dogImage = $('#dog-image');
const select = $('select');

$.get('https://dog.ceo/api/breeds/list/all', function(data){
    breedsArray = Object.keys(data.message);
    for(let i = 0; i < breedsArray.length; i++) {
        let element = '<option value="' + breedsArray[i] + '">' + breedsArray[i].toUpperCase() + '</option>';
        $(element).appendTo(select);
    }
});

$('#get-image').click(function() {
    dogImage.css('opacity', '1');
    var randomIndex = Math.floor(Math.random()*breedsArray.length);
    select.val(breedsArray[randomIndex]);
    $.get('https://dog.ceo/api/breed/'+ breedsArray[randomIndex] + '/images/random' , function(data) {
        dogImage.attr('src', data.message);
    });
});

$('#next-image').click(function() {
    dogImage.css('opacity', '1');
    let dogname = select.val();
    console.log(dogname);
    $.get('https://dog.ceo/api/breed/' + dogname + '/images/random', function(data) {
        dogImage.attr('src', data.message);
    });
});