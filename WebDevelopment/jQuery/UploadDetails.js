$('button').click(function(event) {
    event.preventDefault();
    let rollNumber = $('#roll').val();
    let name = $('#name').val();
    let marks = $('#marks').val();
    if(rollNumber === '' || name === '' || marks === '') {
        window.alert('Please fill correct details and all fields are mendatory!');
        return;
    }
    let element = '<li>Roll no - <div class="input-roll">' + rollNumber + '</div> , <div class="input-name">' + name + '</div> has scored <div class="input-marks">' + marks + '</div> marks</li>';
    $(element).appendTo('ul');

    $('form input').val('');
});