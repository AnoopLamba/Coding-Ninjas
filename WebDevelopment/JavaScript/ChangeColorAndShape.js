var container = document.getElementById('div1');
var shapeContainer = document.getElementById('shape');git
var changeColor = document.getElementById('btn1');
var changeShape = document.getElementById('btn2');

var shapes = ['square', 'triangle', 'bottom-left-triangle', 'cross', 'heart'];
var colors = ['coral', 'cornflowerblue', 'orange', 'yellow', 'black', 'hotpink', 'blue', 'olive'];

changeShape.addEventListener('click', function() {
    let randomIndex = Math.floor(Math.random()*shapes.length);
    let classes = shapeContainer.classList;
    shapeContainer.classList.remove(classes[0]);
    shapeContainer.classList.add(shapes[randomIndex]);
});

changeColor.addEventListener('click', function() {
    let randomIndex = Math.floor(Math.random()*colors.length);
    container.style.backgroundColor = colors[randomIndex];
});