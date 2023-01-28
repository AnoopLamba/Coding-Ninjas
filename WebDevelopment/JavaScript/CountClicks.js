var totalClicks = 0;
var change = document.getElementById("numberOfClicks");
function clicks() {
    totalClicks++;
    change.innerText = totalClicks;
}
var ourBox = document.getElementById("box");
ourBox.addEventListener('click', clicks);