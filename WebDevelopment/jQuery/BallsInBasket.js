const colors = [
    'red', 'blue', 'yellow', 'darkgoldenrod', 'darkorchid', 'black', 'orange', 'deeppink', 'green', 'purple', 'saddlebrown', 'lightseagreen', 'deepskyblue', 'firebrick', 'crimson'
];

$('button').click(function() {
    const maxBalls = 25;
    var counter = 0;
    var interval = setInterval(function() {
        if(counter >= maxBalls) {
            clearInterval(interval);
            return;
        }
        let randomColor = colors[Math.floor(Math.random()*colors.length)];
        $('<div class="ball"></div>').appendTo('#basket');
        let balls = $('.ball');
        let numberOfBalls = balls.length;
        let lastBall = balls.eq(numberOfBalls-1);
        lastBall.css('background-color', randomColor);
        counter++;
    }, 1000);
});