setInterval(function() {
    var x = document.getElementById("div1");
    var y = document.getElementById("div2");

    function stext() {
        x.style.color = 'red';
        y.style.color = 'black';
    }

    function htext() {
        x.style.color = 'black';
        y.style.color = 'red';
    }
}, 250);