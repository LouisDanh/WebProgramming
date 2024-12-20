$(document).ready(function() {
	$(".link").on("click", function() {
		var link = $(this).data("href");
		window.location.href = link;
	});
});

