var pageNumber = 1;
const input = $('input');
const nextBtn = $('#next-btn');
const backBtn = $('#back-btn');
const imageContainer = $('#image-container');
const apiKey = '4Nz5Wbe4F6IS54KmTfknHb7zmM3TAJGJHfH8fTGO';

function areThereMoreImages(solvalue, pageno) {
    let output;
    $.ajax({
        url: 'https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos',
        method: 'GET',
        async: false,
        data: {
            sol: solvalue,
            page: pageno,
            api_key: apiKey
        },
        success: function(data) {
            let array = data.photos;
            if(array.length === 0){
                output = false;
            } else {
                output = true;
            }
        }
    })
    return output;
}

$('#get-images').click(function() {
    let solValue = input.val();
    $.ajax({
        url: 'https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos',
        method: 'GET',
        async: true,
        data: {
            sol: solValue,
            page: pageNumber,
            api_key: apiKey
        },
        success: function(data) {
            imageContainer.empty();
            //handling back btn
            if(pageNumber > 1) {
                backBtn.attr('disabled', false);
            } else {
                backBtn.attr('disabled' ,true);
            }
            //handling next button
            let anyMoreImages = areThereMoreImages(solValue, pageNumber+1);
            console.log(anyMoreImages);
            if(anyMoreImages === true) {
                nextBtn.attr('disabled', false);
            } else {
                nextBtn.attr('disabled', true);
            }

            //adding photos to container
            let imagesArray = data.photos;
            for(let i = 0; i < imagesArray.length; i++) {
                $('<img>', {
                    src: imagesArray[i].img_src
                }).appendTo(imageContainer);
            }
        }
    }).fail(function(xhr, textStatus, errorThrown) {
        console.log(errorThrown);
        window.alert(`Get Images Button error - ${errorThrown}`);
    })
});

nextBtn.click(function() {
    pageNumber++;
    let solValue = input.val();
    $.ajax({
        url: 'https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos',
        method: 'GET',
        async: true,
        data: {
            sol: solValue,
            page: pageNumber,
            api_key: apiKey
        },
        success: function(data) {
            imageContainer.empty();
            //handling back btn
            if(pageNumber > 1) {
                backBtn.attr('disabled', false);
            } else {
                backBtn.attr('disabled' ,true);
            }
            //handling next button
            let anyMoreImages = areThereMoreImages(solValue, pageNumber+1);
            console.log(anyMoreImages);
            if(anyMoreImages === true) {
                nextBtn.attr('disabled', false);
            } else {
                nextBtn.attr('disabled', true);
            }

            //adding photos to container
            let imagesArray = data.photos;
            for(let i = 0; i < imagesArray.length; i++) {
                $('<img>', {
                    src: imagesArray[i].img_src
                }).appendTo(imageContainer);
            }
        }
    }).fail(function(xhr, textStatus, errorThrown) {
        console.log(errorThrown);
        window.alert(`Next Button error - ${errorThrown}`);
    });
});

backBtn.click(function() {
    pageNumber--;
    let solValue = input.val();
    $.ajax({
        url: 'https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos',
        method: 'GET',
        async: true,
        data: {
            sol: solValue,
            page: pageNumber,
            api_key: apiKey
        },
        success: function(data) {
            imageContainer.empty();
            //handling back btn
            if(pageNumber > 1) {
                backBtn.attr('disabled', false);
            } else {
                backBtn.attr('disabled' ,true);
            }
            //handling next button
            let anyMoreImages = areThereMoreImages(solValue, pageNumber+1);
            console.log(anyMoreImages);
            if(anyMoreImages === true) {
                nextBtn.attr('disabled', false);
            } else {
                nextBtn.attr('disabled', true);
            }

            //adding photos to container
            let imagesArray = data.photos;
            for(let i = 0; i < imagesArray.length; i++) {
                $('<img>', {
                    src: imagesArray[i].img_src
                }).appendTo(imageContainer);
            }
        }
    }).fail(function(xhr, textStatus, errorThrown) {
        console.log(errorThrown);
        window.alert(`Back Button error - ${errorThrown}`);
    });
});