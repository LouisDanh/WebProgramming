$('#checkVoucherbtn').on('click', function() {
	var voucherCode = $('#voucher').val().trim();

	if (voucherCode === "") {
		alert("Please enter a voucher code.");
		return;
	}

	$.ajax({
		url: '/WebMyPham/voucher',
		method: 'POST',
		data: {
			voucher: voucherCode
		},
		dataType: 'json',
		success: function(response) {
			var messageDiv = $('#voucherMessage');
			console.log(voucherCode);
			if (response.status === "success") {
				messageDiv.show(); 
				messageDiv.removeClass("alert-danger").addClass("alert-success");
				messageDiv.text(response.message); 
			} else {
				messageDiv.show(); 
				messageDiv.removeClass("alert-success").addClass("alert-danger"); 
				messageDiv.text(response.message); 
			}
		},
		error: function(xhr, status, error) {
		    alert("An error occurred while checking the voucher.");
		}

	});
});
