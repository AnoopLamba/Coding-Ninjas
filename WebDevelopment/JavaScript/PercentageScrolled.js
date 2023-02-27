var innerHeight;
var scrollHeight;
var calculatedPercentage;
var scrollAvailable;
var scrollPercent = document.getElementById('scroll-percent');
window.onscroll = function() {
    innerHeight = window.innerHeight;
    scrollHeight = document.body.scrollHeight;
    scrollAvailable = scrollHeight-innerHeight;
    calculatedPercentage = (window.scrollY/scrollAvailable)*100;
    scrollPercent.innerText = parseInt(calculatedPercentage) + '% Viewed'; 
};