/**
 * Ẩn hiện danh mục
 */
function toggleSubCategory(category) {
	const subCategories = document.querySelectorAll('.sub-category');

	subCategories.forEach(function(subCategory) {
		// Ẩn tất cả danh mục con
		subCategory.style.display = 'none';
	});

	// Lấy danh mục con được chọn
	const selectedCategory = document.getElementById(category);

	// Kiểm tra xem danh mục con đã hiển thị hay chưa, nếu có thì ẩn, nếu không thì hiển thị
	if (selectedCategory.style.display === 'block') {
		selectedCategory.style.display = 'none';
	} else {
		selectedCategory.style.display = 'block';
	}
}

// Hàm đóng danh mục con khi chuột di chuyển ra ngoài
function closeAllSubCategories() {
	const subCategories = document.querySelectorAll('.sub-category');
	subCategories.forEach(function(subCategory) {
		subCategory.style.display = 'none';
	});
}

// Thêm sự kiện `mouseleave` vào phần tử menu để đóng danh mục con khi di chuột ra ngoài
document.querySelector('.danhMuc').addEventListener('mouseleave', closeAllSubCategories);