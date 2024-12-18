$(document).ready(function() {
	// Lắng nghe sự kiện khi người dùng chọn phương thức thanh toán
	$('.payment-method').click(function() {
		// Lấy tên phương thức thanh toán người dùng chọn
		var paymentMethod = $(this).text();  // Sử dụng .text() để lấy nội dung văn bản của button

		// Tìm nút "Tiến hành thanh toán" và cập nhật nội dung
		$('.collapse-btn').html('<i class="bi bi-caret-down-fill"></i> ' + paymentMethod);  // Cập nhật nội dung nút

		// Đóng các button và nội dung khác (nếu có)
		var $collapseContent = $('.collapse-content');

		// Nếu có các nội dung mở (collapse), đóng chúng
		if ($collapseContent.length) {
			$collapseContent.hide();  // Đóng nội dung (ẩn nó)
		}

		// Đóng tất cả các nút có class collapse-btn (nếu cần thiết)
		$('.collapse-btn').removeClass('active');  // Loại bỏ class active của tất cả các collapse-btn
	});
});