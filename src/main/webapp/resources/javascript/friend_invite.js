/**
 * Created by ivan on 21.01.16.
 */
console.log("hello!");

jQuery(document).ready(function($) {
    $("#addToFriend").click(function(event) {
//        alert("dddd");
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        searchAjax();

    });
});

function searchAjax() {
    var data = {};
    data.userId = $("#addToFriend").val();

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/requestForFriendship",
        data: JSON.stringify(data),
        dataType: 'json',
        success: function (data) {
            //console.log("SUCCESS: ", data);
            display();
        },
        error: function (e) {
            console.log("ERROR: ", e);
            display(e);
        },
        done: function (e) {
            console.log("DONE");
        }
    });
}

    function enableSearchButton(flag) {
        $("#btn-search").prop("disabled", flag);
    }

    function display() {
        var message = successAlert("You sent request! Please, wait!") ;
        $('#addToFriendDiv').html(message);
    }

    function successAlert(message) {
        return "<div class='alert alert-success' role='alert'>" + message + "</div>"
    }