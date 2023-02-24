var box = document.getElementById('box');
var boxHeight = parseInt(getComputedStyle(box).getPropertyValue('height'));
var boxWidth = parseInt(getComputedStyle(box).getPropertyValue('width'));
var innerHeight;
var innerWidth;

function getRandomInt(min, max) {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random()*(max-min+1) + min);
}

box.addEventListener('mouseover', function() {
    innerHeight = window.innerHeight;
    innerWidth = window.innerWidth;
    let randomWidth = getRandomInt(0, innerWidth-boxWidth);
    let randomHeight = getRandomInt(0, innerHeight-boxHeight);
    box.style.top = randomHeight + 'px';
    box.style.left = randomWidth + 'px';
});