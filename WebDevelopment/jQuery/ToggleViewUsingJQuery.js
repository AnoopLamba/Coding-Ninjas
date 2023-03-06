const body = $('body');
const text = $('p');
const button = $('#button-outer');
$('#button-outer').click(function(){
    let position = button.css('justify-content');
    if(position === 'start') {
        button.css('justify-content', 'end');
        text.css('color', 'white');
        body.css('background-color', 'black');
    } else {
        button.css('justify-content', 'start');
        text.css('color', 'black');
        body.css('background-color', 'white');
    }
});