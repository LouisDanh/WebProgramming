$("#update-info-form").on("submit", function(event) {
    event.preventDefault(); // Ngừng hành động submit mặc định của form

    var formData = $(this).serialize(); 
    formData += "&action=updateInfo"; 

    $.ajax({
        url: "profiles",  
        type: "POST",
        data: formData,  
        success: function(response) {
            $("#success-message").text("Account info updated successfully!").show();

            setTimeout(function() {
                $("#success-message").fadeOut();
            }, 1000);  
        },
        error: function(xhr, status, error) {
            $("#error-message").text("Error: " + xhr.responseText).show();

            setTimeout(function() {
                $("#error-message").fadeOut();
            }, 1000);  
        }
    });
});
