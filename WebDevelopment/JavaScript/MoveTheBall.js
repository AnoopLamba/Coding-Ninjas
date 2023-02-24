var ball = document.querySelector('.ball');
var rect = ball.getBoundingClientRect();
var innerHeight;
var innerWidth;

function moveUp() {
    let interval = setInterval(function() {
        rect = ball.getBoundingClientRect();
        let top = rect.top;
        if(top > 0) {
            ball.style.top = top - 1 + 'px';
        } else {
            clearInterval(interval);
        }
    }, 20);
}

function moveDown() {
    let interval = setInterval(function() {
        innerHeight = window.innerHeight;
        rect = ball.getBoundingClientRect();
        let bottom = rect.bottom;
        let top = rect.top;
        if(bottom < innerHeight) {
            ball.style.top = top + 1 + 'px';
        } else {
            clearInterval(interval);
        }
    }, 20);
}

function moveLeft() {
    let interval = setInterval(function() {
        rect = ball.getBoundingClientRect();
        let left = rect.left;
        if(left > 0) {
            ball.style.left = left - 1 + 'px';
        } else {
            clearInterval(interval);
        }
    }, 20);
}

function moveRight() {
    let interval = setInterval(function() {
        rect = ball.getBoundingClientRect();
        let left = rect.left;
        let right = rect.right;
        innerWidth = window.innerWidth;
        if(right < innerWidth) {
            ball.style.left = left + 1 + 'px';
        } else {
            clearInterval(interval);
        }
    }, 20);
}

document.addEventListener('keypress' , function(event) {
    console.log('key', event.key);
    if(event.key === 'w') {
        moveUp();
    } else if(event.key === 's') {
        moveDown();
    } else if(event.key === 'd') {
        moveRight();
    } else if(event.key === 'a') {
        moveLeft();
    }
});