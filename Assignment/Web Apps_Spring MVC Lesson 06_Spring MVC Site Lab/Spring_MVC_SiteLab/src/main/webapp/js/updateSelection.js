/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function updateSelection() {
    var type = document.getElementById("type").value;

    if (type == "#") {
        document.getElementById("convertFrom").disabled = true;
        document.getElementById("convertTo").disabled = true;
    } else if (type == "temperature") {
        document.getElementById("convertFrom").disabled = false;
        document.getElementById("convertTo").disabled = false;
        $(document).ready(function () {
            $("#convertFrom").children('option:not(:first)').remove();
            $("#convertTo").children('option:not(:first)').remove();

            $("#convertFrom").append('<option value="celsius">Celsius</option>');
            $("#convertFrom").append('<option value="kelvin">Kelvin</option>');

            $("#convertTo").append('<option value="celsius">Celsius</option>');
            $("#convertTo").append('<option value="kelvin">Kelvin</option>');
        });
    } else if (type == "currency") {
        document.getElementById("convertFrom").disabled = false;
        document.getElementById("convertTo").disabled = false;
        $(document).ready(function () {
            $("#convertFrom").children('option:not(:first)').remove();
            $("#convertTo").children('option:not(:first)').remove();

            $("#convertFrom").append('<option value="dollar">Dollar</option>');
            $("#convertFrom").append('<option value="euro">Euro</option>');
            $("#convertFrom").append('<option value="rmb">RMB</option>');

            $("#convertTo").append('<option value="dollar">Dollar</option>');
            $("#convertTo").append('<option value="euro">Euro</option>');
            $("#convertTo").append('<option value="rmb">RMB</option>');
        });
    } else if (type == "volume") {
        document.getElementById("convertFrom").disabled = false;
        document.getElementById("convertTo").disabled = false;
        $(document).ready(function () {
            $("#convertFrom").children('option:not(:first)').remove();
            $("#convertTo").children('option:not(:first)').remove();

            $("#convertFrom").append('<option value="oz">Fluid Ounce</option>');
            $("#convertFrom").append('<option value="qt">Quart</option>');
            $("#convertFrom").append('<option value="gal">Gallon</option>');

            $("#convertTo").append('<option value="oz">Fluid Ounce</option>');
            $("#convertTo").append('<option value="qt">Quart</option>');
            $("#convertTo").append('<option value="gal">Gallon</option>');
        });
    } else if (type == "mass") {
        document.getElementById("convertFrom").disabled = false;
        document.getElementById("convertTo").disabled = false;
        $(document).ready(function () {
            $("#convertFrom").children('option:not(:first)').remove();
            $("#convertTo").children('option:not(:first)').remove();

            $("#convertFrom").append('<option value="kg">Kilogram</option>');
            $("#convertFrom").append('<option value="lb">Pound</option>');

            $("#convertTo").append('<option value="kg">Kilogram</option>');
            $("#convertTo").append('<option value="lb">Pound</option>');
        });
    }
}



//function updateSelection() {
//    var type = document.getElementById("type").value;
//    var convertFrom = document.getElementById("convertFrom").value;
//
//    if (type == "#") {
//        document.getElementById("convertFrom").disabled = true;
//    } else if (type == "Temperature") {
//        document.getElementById("convertFrom").disabled = false;
////                                                        $("#convertFrom").children('option:not(:first)').remove();
//        $("#convertFrom").append('<option value="Celsius">Celsius</option>');
//        $("#convertFrom").append('<option value="Kelvin">Kelvin</option>');
//    }
//
//    if (convertFrom == "#") {
//        document.getElementById("convertTo").disabled = true;
//    } else {
//        document.getElementById("convertTo").disabled = false;
//    }
//}
//
//
//$(document).ready(function () {
//    $('#btn-add').click(function () {
//        $('#select-from option:selected').each(function () {
//            $('#select-to').append("<option value='" + $(this).val() + "'>" + $(this).text() + "</option>");
//            $(this).remove();
//        });
//    });
//    $('#btn-remove').click(function () {
//        $('#select-to option:selected').each(function () {
//            $('#select-from').append("<option value='" + $(this).val() + "'>" + $(this).text() + "</option>");
//            $(this).remove();
//        });
//    });
//
//});

//// Used for remove all and add new at the same time
//        $('#convertFrom')
//                .find('test')
//                .remove()
//                .end()
//                .append('<option value="test">text</option>')
//                .val('newTest')
//                ;