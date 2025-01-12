/**
 * Lọc tiêu chí
 */

$(document).ready(function() {
	//sự kiện chọn brand
	$('.dropdown-brand-item').on('click', function() {
		$('.dropdown-brand-item').removeClass('drop-brand-item__active');
		$(this).addClass('drop-brand-item__active');
		var selectedText = $(this).text();
		$('#dropdown-text-brand').text(selectedText);
		var id = $(this).data('id');
		$('input[name="brandId"]').val(id);
	});
	//Sự kiện chọn loại filter
	$('.filter-item').on('click', function() {
		var target = $(this).data('target');
		var id = $(this).data('id');
		if (target == 'category') {
			$('input[name="categoryId"]').val(id);
			$('.filter-category').removeClass('filter-item__active');
		}
		else if (target == "attributes") {
			let purposes = $('input[name="attributesId"]').val();
			    purposes = purposes ? purposes.split(','): [];
			if (purposes.includes(`${id}`)) {
				purposes = purposes.filter(item => item !== `${id}`);
			} else {
				purposes.push(id);
			}
			$('input[name="attributesId"]').val([...new Set(purposes)].join(','));
		}
		$(this).toggleClass('filter-item__active');

	});
});
