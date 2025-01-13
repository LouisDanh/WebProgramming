$(document).ready(function() {
	var normalStar = '&#9734;'; // Empty star
	var filledStar = '&#9733;'; // Filled star

	// Handle click on a star
	$('.stars').each(function() {
		getRating(this);
	});
	$('.star').click(function() {
		var index = $(this).parent('.stars').children('.star').index(this); // Get the index of the clicked star
		$(this).parent('.stars').addClass('stars-selected');
		$(this).parent('.stars').data('value', index + 1);
		$(this).prevAll().html(filledStar).addClass('stars_active');
		$(this).html(filledStar).addClass('star_active');
		$(this).nextAll().html(normalStar).removeClass('star_active');
	});

	// Handle hover over a star
	$('.star').mouseenter(function() {
		$(this).prevAll().html(filledStar).addClass('star_active');
		$(this).html(filledStar).addClass('star_active');
		$(this).nextAll().html(normalStar).removeClass('star_active')
	});

	// Handle mouse leaving the stars area
	$('.stars').mouseleave(function() {
		getRating(this);
	});
	function getRating(stars) {
		var rating = $(stars).data('value');
		$(stars).children('.star').each(function(index) {
			if (index < rating) {
				$(this).html(filledStar).addClass('star_active');
			} else {
				$(this).html(normalStar).removeClass('star_active');
			}
		});
	}
});
$(document).ready(function() {
	$('.recieved_order-btn').on('click', function() {
		$(this).prev('.buy_again-btn').removeClass('disabled-btn');
		$(this).addClass('disabled-btn');
	});
}); $(document).ready(function() {
	// Hiển

	// Ẩn tất cả các phần tử collapse-content khi trang tải
	$('.collapse-content').hide();

	// Khi nhấp vào nút collapse
	$('.collapse-btn').click(function() {
		var index = $(this).index('.collapse-btn');
		$('.collapse-content').eq(index).slideToggle();
	});
	// Hiển thị phần "Account Overview" mặc định khi trang được tải
	$('#account-overview').removeClass('d-none');

	// Thêm sự kiện khi người dùng click vào các mục menu
	$('ul.new-list li').on('click', function() {
		// Ẩn tất cả các phần chi tiết
		$('.detail-form').addClass('d-none');

		// Lấy mục tiêu (section) của phần tử được click
		var target = $(this).data('target');

		// Hiển thị phần mục tiêu
		$('#' + target).removeClass('d-none');

		// Loại bỏ lớp 'active' khỏi tất cả các mục trong danh sách
		$('ul.new-list li').removeClass('active');

		// Thêm lớp 'active' vào mục đã được click
		$(this).addClass('active');
	});

	// Tùy chọn: Bạn có thể làm nổi bật phần đang hoạt động khi trang tải, dựa trên phần hiện tại
	var currentPage = window.location.hash.replace('#', '') || 'account-overview'; // Mặc định là 'account-overview'
	$('#' + currentPage).removeClass('d-none');
	$('ul.new-list li[data-target="' + currentPage + '"]').addClass('active');
});

