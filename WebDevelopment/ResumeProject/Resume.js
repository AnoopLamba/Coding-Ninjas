//Smooth scrolling functionality
var navMenuAnchorTags = document.querySelectorAll('.nav-menu a');
var interval;
for(let i = 0; i < navMenuAnchorTags.length; i++) {
    navMenuAnchorTags[i].addEventListener('click', function(event) {
        event.preventDefault();
        let targetSection = this.innerHTML.trim().toLowerCase();
        if(targetSection === 'home') {
            return;
        }
        let targetSectionId = document.getElementById(targetSection);
        interval = setInterval(scrollVertically, 10, targetSectionId);
    });
}

function scrollVertically(targetSectionId) {
    let targetSectionRectangle = targetSectionId.getBoundingClientRect();
    if(targetSectionRectangle.top <= 0) {
        clearInterval(interval);
        return;
    }
    window.scrollBy(0, 100);
}



//Auto fill skill bars
var allskills = document.getElementsByClassName('zero-percent');
function fillBar(entry) {
    let skillPercent = entry.getAttribute('data-level');
    let currentPercent = 0;
    let interval = setInterval(function() {
        if(currentPercent > skillPercent) {
            clearInterval(interval);
            return;
        }
        entry.style.width = currentPercent + '%';
        currentPercent++;
    }, 10);
}

let skillsContainer = document.getElementById('skills-container');
var observer = new IntersectionObserver(function(entries) {
	for(let i = 0; i < entries.length; i++) {
        if(entries[i].isIntersecting === true) {
            fillBar(entries[i].target);
        }
    }
}, { threshold: [0.3] });

for(let i = 0; i < allskills.length; i++) {
    observer.observe(allskills[i]);
}