// When the document is ready
$(document).ready(function() {
	const $tabledProducts = $(".tabled-products"); // Select all tabs
	const $containerTabled = $(".tabled-product-detail"); // Select all corresponding containers

	// Function to update the "fw-bold" class for the selected tab
	function updateTabHighlight($selectedElement) {
		$tabledProducts.removeClass("fw-bold"); // Remove "fw-bold" class from all tabs
		$selectedElement.addClass("fw-bold"); // Add "fw-bold" class to the selected tab
	}

	// Function to show the product list corresponding to the selected tab
	function showContainerTabled(index) {
		$containerTabled.each(function(i) {
			$(this).toggleClass("d-none", i !== index); // Hide or show containers based on the index
		});
	}

	// Attach click event to each tab
	$tabledProducts.each(function(index) {
		$(this).on("click", function() {
			updateTabHighlight($(this)); // Highlight the selected tab
			showContainerTabled(index); // Show the corresponding container
		});
	});

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
});
