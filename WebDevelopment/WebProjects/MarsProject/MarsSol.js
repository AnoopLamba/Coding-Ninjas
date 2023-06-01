$('button').click(function(event) {
    event.preventDefault();
    let solValue = $('#sol-value').val();
    let pageNumber = $('#page-number').val();
    if(parseInt(solValue) > 1000 || parseInt(solValue) < 0 || parseInt(pageNumber) <= 0) {
        window.alert('Enter proper values in the field!');
    } else {
        $.ajax({
            url: 'https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos',
            method: 'GET',
            data: {
                sol: solValue,
                page: pageNumber,
                api_key: 'DEMO_KEY'
            },
            success: function(parsedJSON) {
                for(let i = 0; i < parsedJSON.photos.length; i++) {
                    $('<img>').attr({
                        src: parsedJSON.photos[i].img_src
                    }).appendTo('#image-container');
                }
            }
        }).fail(function(xhr, textStatus, errorThrown) {
            console.log(errorThrown, textStatus, xhr);
        });
    }
});