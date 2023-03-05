//rod dimensions
const rods = document.getElementsByClassName('rod');
let rodRect = rods[0].getBoundingClientRect();
let rodLength = rodRect.right-rodRect.left;
let rodHeight = rodRect.bottom - rodRect.top;
const rodLeftDistance = rodRect.left + 'px';
let rodRect1 = rods[0].getBoundingClientRect();
let rodRect2 = rods[1].getBoundingClientRect();

//ball dimensions
const ball = document.getElementById('ball');
var ballRect = ball.getBoundingClientRect();
var ballDimension = ballRect.right - ballRect.left;
const ballLeftDistance = ballRect.left + 'px';

//initial ball placement at start of the game
const placeBallOnRod1 = rodHeight + 'px';
const placeBallOnRod2 = window.innerHeight-rodHeight-ballDimension + 'px';
ball.style.top = placeBallOnRod2;

//window alert at the starting of the game
let lastUserWon = localStorage.getItem('player');
let maxScore = localStorage.getItem('score');
if(lastUserWon === null) {
    window.alert('Welcome to Ping Ping, you are playing this game first time! press Enter to start the game');  
} else {
    window.alert(lastUserWon + ' has the max score of ' + maxScore + '! press Enter to start a new game');
}

//all game functionality
window.addEventListener('keypress', function(event) {
    let currentLeft = rods[0].getBoundingClientRect().left;
    if(event.key === 'a') {
        if(currentLeft > 0) {
            for(let i=0; i<2; i++) {
                rods[i].style.left = currentLeft-3 + 'px';
            }
        }
    } else if(event.key === 'd') {
        if(currentLeft < window.innerWidth-rodLength) {
            for(let i=0; i<2; i++) {
                rods[i].style.left = currentLeft+3 + 'px';
            }
        }
    }
});

var stepValue = 1;
var timer = 1;
var dirH = 'right';
var dirV = 'down';

window.addEventListener('keypress' , function(event) {
    let scores = [0,0];
    if(event.key === 'Enter') {
        let interval = setInterval(function() {
            if(dirH === 'right') {
                ballRect = ball.getBoundingClientRect();
                let leftOfBall = ballRect.left;
                if(leftOfBall <= 0) {
                    dirH = 'left';
                } else {
                    ball.style.left = leftOfBall-stepValue+'px';
                }
            } 
            if(dirH === 'left') {
                ballRect = ball.getBoundingClientRect();
                let leftOfBall = ballRect.left;
                if(ballRect.right >= window.innerWidth) {
                    dirH = 'right';
                } else {
                    ball.style.left = leftOfBall+stepValue+'px';
                }
            }
    
            if(dirV === 'up') {
                ballRect = ball.getBoundingClientRect();
                let topOfBall = ballRect.top;
                let bottomOfBall = ballRect.bottom;
                if(ballRect.bottom >= window.innerHeight) {
                    dirV = 'down';
                } else {
                    if(bottomOfBall+stepValue >= rodRect2.top) {
                        ball.style.top = topOfBall+stepValue+'px';
                        if(isTouching(ball, rods[1])) {
                            dirV = 'down';
                            scores[1] += 1;
                        } else {
                            //ball missed
                            clearInterval(interval);
                            //check if score if present or not
                            let lastUser = localStorage.getItem('player');
                            if(lastUser === null) {
                                localStorage.setItem('player', 'Rod 1');
                                localStorage.setItem('score', scores[0]);
                            } else {
                                let lastScore = localStorage.getItem('score');
                                if(scores[0] > parseInt(lastScore)){
                                    localStorage.setItem('player', 'Rod 1');
                                    localStorage.setItem('score', scores[0]);
                                }
                            }
                            
                            //change rod and ball position
                            rods[0].style.left = rodLeftDistance;
                            rods[1].style.left = rodLeftDistance;
                            ball.style.top = placeBallOnRod1;
                            ball.style.left = ballLeftDistance;
                            //change directions of ball as well
                            dirV = 'up';
                            //show alert
                            window.alert(`Rod 1 won this game with score of ${scores[0]}`);
                        }
                    } else {
                        ball.style.top = topOfBall+stepValue+'px';
                    }
                }
            } 
            if(dirV === 'down') {
                ballRect = ball.getBoundingClientRect();
                let topOfBall = ballRect.top;
                if(topOfBall <= 0) {
                    dirV = 'up';
                } else {
                    if(topOfBall-stepValue <= rodRect1.bottom) {
                        ball.style.top = topOfBall-stepValue+'px';
                        if(isTouching(ball, rods[0])) {
                            dirV = 'up';
                            scores[0] += 1;
                        } else {
                            //ball missed
                            clearInterval(interval);
                            //check if score if present or not
                            let lastUser = localStorage.getItem('player');
                            if(lastUser === null) {
                                localStorage.setItem('player', 'Rod 2');
                                localStorage.setItem('score', scores[1]);
                            } else {
                                let lastScore = localStorage.getItem('score');
                                if(scores[1] > parseInt(lastScore)){
                                    localStorage.setItem('player', 'Rod 2');
                                    localStorage.setItem('score', scores[1]);
                                }
                            }
                            
                            //change rod and ball position
                            rods[0].style.left = rodLeftDistance;
                            rods[1].style.left = rodLeftDistance;
                            ball.style.top = placeBallOnRod2;
                            ball.style.left = ballLeftDistance;
                            //change directions of ball as well
                            dirV = 'down';
                            //show alert
                            window.alert(`Rod 2 won this game with score of ${scores[1]}`);
                        }
                    } else {
                        ball.style.top = topOfBall-stepValue+'px';
                    }
                }
            }
        }, timer);
    }
});

function isTouching(ele1, ele2) {
    let domRect1 = ele1.getBoundingClientRect();
    let domRect2 = ele2.getBoundingClientRect();

    return !(
        domRect1.top > domRect2.bottom ||
        domRect1.right < domRect2.left ||
        domRect1.bottom < domRect2.top ||
        domRect1.left > domRect2.right
    );
}