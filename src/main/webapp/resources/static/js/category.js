function toggleSubCategory(category) {
	$('.sub-category').hide();
	const selectedCategory = $('#' + category);
	if (selectedCategory.css('display') === 'block') {
		selectedCategory.hide();
	} else {
		selectedCategory.show();
	}
}

$(document).ready(function() {
	$('.danhMuc').on('mouseleave', function() {
		$('.sub-category').hide();
	});
});