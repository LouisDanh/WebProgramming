$("#update-info-form").on("submit", function(event) {
	event.preventDefault(); // Ngừng hành động submit mặc định của form

	var formData = $(this).serialize();
	formData += "&action=updateInfo";
/*	alert(formData);
*/	$.ajax({
		url: "profiles",
		type: "POST",
		data: formData,
		success: function(response) {
			$("#update-info-success").text("Account info updated successfully!").show();

			setTimeout(function() {
				$("#update-info-success").fadeOut();
			}, 1000);
		},
		error: function(xhr, status, error) {
			$("#update-info-error").text("Error: " + xhr.responseText).show();

			setTimeout(function() {
				$("#update-info-error").fadeOut();
			}, 1000);
		}
	});
});
$("#change-pass-form").on("submit", function(event) {
	event.preventDefault();

	var formData = $(this).serialize();
	formData += "&action=changePass";

	$.ajax({
		url: "profiles",
		type: "POST",
		data: formData,
		success: function(response) {
			$("#change-pass-success").text("Password updated successfully!").show();

			setTimeout(function() {
				$("#change-pass-success").fadeOut();
			}, 1000);
		},
		error: function(xhr, status, error) {
			$("#change-pass-error").text("Error: " + xhr.responseText).show();

			setTimeout(function() {
				$("#change-pass-error").fadeOut();
			}, 1000);
		}
	});
});
