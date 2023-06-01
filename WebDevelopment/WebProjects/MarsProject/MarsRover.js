$('button').click(function(event) {
    event.preventDefault();
    let date =  $('input').val();
    if(date === '') {
        window.alert('Date field cannot be left empty!');
    } else {
        $.ajax({
            url: 'https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos',
            method: 'GET',
            data: {
                earth_date: date,
                api_key: 'DEMO_KEY'
            },
            success: function(data) {
                for(let i = 0; i < data.photos.length; i++) {
                    $('<img>').attr({
                        src: data.photos[i].img_src
                    }).appendTo('#image-container');
                }
            }
        }).fail(function(xhr, textStatus, errorThrown) {
            console.log(errorThrown, textStatus, xhr);
        });
    }
});