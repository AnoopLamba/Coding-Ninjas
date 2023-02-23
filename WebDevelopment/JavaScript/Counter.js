var current = document.querySelector('.current');
var next = document.querySelector('.next');

var currentNumber;
var interval;
function startCounter() {
	currentNumber = 0;
	current.innerHTML = 0;
    var userInputNumber = parseInt(document.getElementById('number-input').value);
    if(userInputNumber >= 10 || userInputNumber < 0) {
        window.alert('Enter number only between 0 and 9!');
        return;
    }
    interval = setInterval(counter, 1000, userInputNumber);
}

function counter(userInputNumber) {
	if(parseInt(current.innerHTML) < userInputNumber) {
		next.innerHTML = parseInt(current.innerHTML)+1;
		next.classList.add('animate');
		setTimeout(function() {
			current.innerHTML = next.innerHTML;
			next.classList.remove('animate');
		}, 500);
	} else {
		clearInterval(interval);
		window.alert('Counter stopped!');
	}
}