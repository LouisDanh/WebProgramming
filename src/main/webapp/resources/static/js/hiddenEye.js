$(document).ready(function() {
	// Đảm bảo mật khẩu ẩn và biểu tượng là mắt đóng khi trang được tải
	$('#toggle-password').click(function() {
		var passwordField = $('#password');  // Lấy trường mật khẩu
		var icon = $(this).find('i');  // Lấy biểu tượng mắt trong nút

		// Kiểm tra xem mật khẩu đang ẩn hay hiển thị
		if (passwordField.attr('type') === 'password') {
			passwordField.attr('type', 'text');  // Hiện mật khẩu
			icon.removeClass('bi-eye-slash');  // Xóa biểu tượng mắt đóng
			icon.addClass('bi-eye');  // Thêm biểu tượng mắt mở
		} else {
			passwordField.attr('type', 'password');  // Ẩn mật khẩu
			icon.removeClass('bi-eye');  // Xóa biểu tượng mắt mở
			icon.addClass('bi-eye-slash');  // Thêm biểu tượng mắt đóng
		}
	});

	// Đảm bảo mật khẩu xác nhận ẩn và biểu tượng là mắt đóng khi trang được tải
	$('#toggle-confirm-password').click(function() {
		var confirmPasswordField = $('#confirmPassword');  // Lấy trường mật khẩu xác nhận
		var icon = $(this).find('i');  // Lấy biểu tượng mắt trong nút

		// Kiểm tra xem mật khẩu xác nhận đang ẩn hay hiển thị
		if (confirmPasswordField.attr('type') === 'password') {
			confirmPasswordField.attr('type', 'text');  // Hiện mật khẩu xác nhận
			icon.removeClass('bi-eye-slash');  // Xóa biểu tượng mắt đóng
			icon.addClass('bi-eye');  // Thêm biểu tượng mắt mở
		} else {
			confirmPasswordField.attr('type', 'password');  // Ẩn mật khẩu xác nhận
			icon.removeClass('bi-eye');  // Xóa biểu tượng mắt mở
			icon.addClass('bi-eye-slash');  // Thêm biểu tượng mắt đóng
		}
	});
});
