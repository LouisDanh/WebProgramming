$(document).ready(function() {
	$('#checkVoucherbtn').click(function() {
		var voucherCode = $('#voucher').val();

		var productIds = [];

		if (voucherCode.trim() === "") {
			alert('Vui lòng nhập mã voucher');
			return;
		}

		// Lấy danh sách productId trong giỏ hàng
		       var productIds = [];
		       $('.cart-item').each(function() {
		           var productId = $(this).data('productId');
		           if (productId) {
		               productIds.push(productId);
		           }
		       });

		// Kiểm tra nếu không có sản phẩm nào trong giỏ hàng
		if (productIds.length === 0) {
			alert('Giỏ hàng trống. Vui lòng chọn sản phẩm.');
			return;
		}

		// Thực hiện gửi yêu cầu AJAX
		$.ajax({
			url: "/WebMyPham/cart", 
			type: "POST",
			data: {
				voucherCode: voucherCode,
				productId: productIds
			},
			success: function(response) {
				if (response === "OK") {
					alert("Voucher hợp lệ!");
				} else {
					alert("Voucher không hợp lệ.");
				}
			},
			error: function(xhr, status, error) {
				alert("Lỗi xảy ra khi kiểm tra mã voucher.");
			}
		});
	});
});
