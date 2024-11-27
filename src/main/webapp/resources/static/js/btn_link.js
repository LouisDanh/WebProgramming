$(".btn-link").on("click", function() {
    var link = $(this).data("href"); // Use $(this) to reference the clicked element
    window.location.href = link; // Redirect to the URL stored in the data-href attribute
});
