"use strict";
var toggler = document.getElementById('toggler-outer');
var text = document.getElementById('heading');
toggler.addEventListener('click', function() {
            if(toggler.style.justifyContent === 'end') {
                toggler.style.justifyContent = 'start';
                text.style.color = 'black';
                document.body.style.backgroundColor = 'white';
            } else {
                toggler.style.justifyContent = 'end';
                text.style.color = 'white';
                document.body.style.backgroundColor = 'black';
            }
        });