var next1 = document.querySelector('#container1 .next');
var current1 = document.querySelector('#container1 .current');
var next2 = document.querySelector('#container2 .next');
var current2 = document.querySelector('#container2 .current');
var next3 = document.querySelector('#container3 .next');
var current3 = document.querySelector('#container3 .current');
var next4 = document.querySelector('#container4 .next');
var current4 = document.querySelector('#container4 .current');
var next5 = document.querySelector('#container5 .next');
var current5 = document.querySelector('#container5 .current');

var interval;
var currentNumber;
function startCounter() {
    currentNumber = 0;
    current1.innerHTML = '0';
    current2.innerHTML = '0';
    current3.innerHTML = '0';
    current4.innerHTML = '0';
    current5.innerHTML = '0';
    var userInputNumber = parseInt(document.getElementById('number-input').value);
    if(userInputNumber >= 100000 || userInputNumber < 0) {
        window.alert('Enter number only between 0 and 99999!');
        return;
    }
    interval = setInterval(counter, 1000, userInputNumber);
}

function returnCurrentNumber() {
    return parseInt(current5.innerHTML + current4.innerHTML + current3.innerHTML + current2.innerHTML + current1.innerHTML);
}

function animateFunction(current, next) {
    next.classList.add('animate');
    setTimeout(function() {
        current.innerHTML = next.innerHTML;
        next.classList.remove('animate');
    }, 500);
}

function counter(userInputNumber) {
    currentNumber =  returnCurrentNumber();
    if(currentNumber < userInputNumber) {
        if(current1.innerHTML == 9) {
            next1.innerHTML = 0;
            if(current2.innerHTML == 9) {
                next2.innerHTML = 0;
                if(current3.innerHTML == 9) {
                    next3.innerHTML = 0;
                    if(current4.innerHTML == 9) {
                        current4.innerHTML = 0;
                        next5.innerHTML = parseFloat(current5.innerHTML)+1;
                        animateFunction(current5, next5);
                    } else {
                        next4.innerHTML = parseInt(current4.innerHTML)+1;
                    }
                    animateFunction(current4, next4);
                } else {
                    next3.innerHTML = parseInt(current3.innerHTML)+1;
                }
                animateFunction(current3, next3);
            } else {
                next2.innerHTML = parseInt(current2.innerHTML)+1;
            }
            animateFunction(current2, next2);
        } else {
            next1.innerHTML = parseInt(current1.innerHTML)+1;
        }
        animateFunction(current1, next1);
    } else {
        clearInterval(interval);
        window.alert('Counter stopped!');
    }
}