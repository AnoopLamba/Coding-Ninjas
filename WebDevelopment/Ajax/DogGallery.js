var breedsArray;

$.get('https://dog.ceo/api/breeds/list/all', function(data){
    breedsArray = Object.keys(data.message);
    for(let i = 0; i < breedsArray.length; i++) {
        let element = '<option value="' + breedsArray[i] + '">' + breedsArray[i].toUpperCase() + '</option>';
        $(element).appendTo('#dog-breeds');
    }

});

$('#dog-breeds').change(function() {
    let selectedBreed = $(this).val();
    $.get('https://dog.ceo/api/breed/'+ selectedBreed +  '/list',function(data) {
        let subBreedArray = data.message;
        if(subBreedArray.length != 0) {
            $('#dog-sub-breeds').empty();
            for(let i = 0; i < subBreedArray.length; i++) {
                let element = '<option value="' + subBreedArray[i] + '">' + subBreedArray[i].toUpperCase() + '</option>';
                $(element).appendTo('#dog-sub-breeds');
            }
            $('#dog-sub-breeds').css('display', 'block');
        } else {
            $('#dog-sub-breeds').css('display', 'none');
            $('#dog-sub-breeds').empty();
        }
    });
});

$('#get-image').click(function() {
    $('#container-2').empty();
    let breed = $('#dog-breeds');
    let subBreed = $('#dog-sub-breeds');
    if(subBreed.val() === null) {
        $.get('https://dog.ceo/api/breed/' + breed.val() + '/images', function(data) {
            let subBreedImagesArray = data.message;
            for(let i = 0; i < subBreedImagesArray.length; i++) {
                $('<img>' ,{
                    src: subBreedImagesArray[i]
                }).appendTo('#container-2');
            }
        });
    } else {
        $.get('https://dog.ceo/api/breed/'+breed.val()+ '/' +subBreed.val()+'/images', function(data) {
            let subBreedImagesArray = data.message;
            for(let i = 0; i < subBreedImagesArray.length; i++) {
                $('<img>' ,{
                    src: subBreedImagesArray[i]
                }).appendTo('#container-2');
            }
        });
    }
});
