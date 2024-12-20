$(document).ready(function() {
	let hideTimeout; // Biến lưu trữ timeout
	const AUTO_HIDE_TIME = 2000; // Thời gian tự động ẩn menu (ms)

	// Toggle menu khi nhấn vào hamburger icon
	$('#hamburgerIcon').click(function() {
		const $extraIcons = $('#extraIcons');
		$extraIcons.toggleClass('show');
		if ($extraIcons.hasClass('show')) {
			startAutoHideTimer();
		} else {
			clearTimeout(hideTimeout);
		}
		$('.sub-category').hide();
	});

	// Bắt đầu bộ đếm tự động ẩn menu
	function startAutoHideTimer() {
		clearTimeout(hideTimeout); // Xóa bộ đếm cũ nếu tồn tại
		hideTimeout = setTimeout(function() {
			$('#extraIcons').removeClass('show'); // Ẩn menu
		}, AUTO_HIDE_TIME);
	}

	$('#extraIcons, #hamburgerIcon').on('mouseenter', function() {
		clearTimeout(hideTimeout);
	});

	$('#extraIcons').on('mouseleave', function() {
		startAutoHideTimer();
	});
});
