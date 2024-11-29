$(document).ready(function() {
    $(".btn-link").on("click", function() {
        var link = $(this).data("href");
        window.location.href = link;
    });
});