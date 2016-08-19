/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function updateInputField() {
    var convertFrom = document.getElementById("convertFrom").value;
    var convertTo = document.getElementById("convertTo").value;

    if (convertFrom == "#" || convertTo == "#") {
        document.getElementById("inputSection_text").disabled = true;
        document.getElementById("button").disabled = true;
    } else {
        document.getElementById("inputSection_text").disabled = false;
        document.getElementById("button").disabled = false;
    }
}
