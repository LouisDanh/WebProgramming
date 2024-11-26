/**
 * Sự kiện cho đánh giá sản phẩm
 */
// Hàm mở phần đánh giá
$(document).ready(function() {
	$('.open-rating-container').on('click', function() {
		var index = $('.open-rating-container').index(this);
		openRatingContainer(index);
	});

	
	$('.cancelRating').on('click', function() {
		var index = $('.cancelRating').index(this);
		closeRatingContainer(index);
	});
	$('.submitRating').on('click', function() {
		var index = $('.submitRating').index(this);
		closeRatingContainer(index);
		var btn = $('.open-rating-container').eq(index);
		btn.addClass('btn-link');
		btn.text('Mua lại');
	});
	$('.rating-star').on('click', function() {
		var index = $('.start').index(this);
		var rating = index + 1;
		var stars = $('.rating-star');
		for (var i = 0; i < stars.length; i++) {
			if (i <= index) {
				stars.eq(i).addClass('text-warning');
			} else {
				stars.eq(i).removeClass('text-warning');
			}
		}
		$('#ratingValue').val(rating);
	});
	function closeRatingContainer(index) {
		$('.rating-container').eq(index).addClass('d-none');
		$('.open-rating-container').eq(index).removeClass('d-none');
	}
	function openRatingContainer(index) {
		$('.rating-container').eq(index).removeClass('d-none');
		$('.open-rating-container').eq(index).addClass('d-none');
	}
});