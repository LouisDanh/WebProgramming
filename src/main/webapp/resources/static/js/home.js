// When the document is ready
$(document).ready(function() {
	$(".tabled-products").on('click', function() {
		const $currentTopic = $(this).closest(".topic");
		const selectedId = $(this).data("id");
		const $topicTabs = $currentTopic.find(".tabled-products");
		$topicTabs.removeClass("fw-bold");
		$(this).addClass("fw-bold");
		const $topicDetails = $currentTopic.find(".carousel-tabled-products");
		$topicDetails.each(function() {
			if ($(this).data('id') == selectedId) {
				$(this).css("display", "block");
				$(this).find(".topic-product-list").each(function() {
					if ($(this).hasClass("slick-initialized")) {
						$(this).slick("refresh");
					}
				})

			}
			else {
				$(this).css("display", "none");
			}
		})
	})
	const slidesShow = 4;
	const slidesScroll = 4;
	$('.topic-product-list').slick({
		infinite: true,
		slidesToShow: slidesShow,
		slidesToScroll: slidesScroll,
		arrows: true,
		prevArrow: '<button type="button" class="slick-prev btn-slick"><i class="fa fa-chevron-left"></i></button>',
		nextArrow: '<button type="button" class="slick-next btn-slick"><i class="fa fa-chevron-right"></i></button>',
		centerMode: false,
		draggable: false
	});

	$(".topic").each(function() {
		const $firstTab = $(this).find(".tabled-products").first();
		if ($firstTab.length > 0) {
			$firstTab.trigger("click");
		}
	});
});
