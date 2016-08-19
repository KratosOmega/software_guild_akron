/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function updateHomeImage() {
    var program = document.getElementById("programSelection").value;
    var introduction = document.getElementById("programIntroduction");

    if (program == "#") {
        introduction.style.backgroundImage = "url(\"img/welcome.png\")";
//        $('#programIntroduction').css("background-image", "url(../img/welcome.png)");
    } else if (program == "luckySevens") {
        introduction.style.backgroundImage = "url(\"img/luckySevens.png\")";
    } else if (program == "factorizor") {
        introduction.style.backgroundImage = "url(\"img/factorizer.png\")";
    } else if (program == "interest") {
        introduction.style.backgroundImage = "url(\"img/interestCalculator.png\")";
    } else if (program == "flooring") {
        introduction.style.backgroundImage = "url(\"img/flooringCalculator.png\")";
    } else if (program == "tip") {
        introduction.style.backgroundImage = "url(\"img/tipCalculator.png\")";
    } else if (program == "unit") {
        introduction.style.backgroundImage = "url(\"img/unitConverter.png\")";
    }
}
